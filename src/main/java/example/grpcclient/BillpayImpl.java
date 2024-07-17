package example.grpcclient;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import service.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BillpayImpl  extends BillpayGrpc.BillpayImplBase{
    private String entryFilename = "bills.txt";
    private Map<String, List<Bills>> billsMap;
    private List<Bills> billsList;

    public BillpayImpl() {
        super();
        billsMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        billsList = new ArrayList<>();
        writeToEntry(null);
    }

    @Override
    public void get(Empty empty, StreamObserver<BillpayReadResponse> responseObserver) {
        System.out.println("Received a request from client to see all bills");

        BillpayReadResponse.Builder response = BillpayReadResponse.newBuilder();

        if (billsList.isEmpty()) {
            response.setIsSuccess(false).setError("No bills in database...");
        } else {
            response.setIsSuccess(true);
            response.addAllBills(billsList);
        }

        BillpayReadResponse send = response.build();
        responseObserver.onNext(send);
        responseObserver.onCompleted();
    }

    @Override
    public void getByDue(BillpaySearchRequest request, StreamObserver<BillpayReadResponse> responseObserver) {
        System.out.println("Client requested to see all bills that are due before: " + request.getDue());
        BillpayReadResponse.Builder response = BillpayReadResponse.newBuilder();

        String dueDateStr = request.getDue();

        if (dueDateStr.length() != 10 || dueDateStr.charAt(2) != '/' || dueDateStr.charAt(5) != '/') {
            response.setIsSuccess(false).setError("Date entered is not in format MM/DD/YYYY...");
            BillpayReadResponse send = response.build();
            responseObserver.onNext(send);
            responseObserver.onCompleted();
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dueDate;

        try {
            dueDate = LocalDate.parse(dueDateStr, formatter);
        } catch (NumberFormatException e) {
            response.setIsSuccess(false).setError("Date entered is not in format MM/DD/YYYY...");
            BillpayReadResponse send = response.build();
            responseObserver.onNext(send);
            responseObserver.onCompleted();
            return;
        }

        String currentDate = "07/10/2024";
        LocalDate current = LocalDate.parse(currentDate, formatter);

        if (dueDate.isBefore(current)) {
            response.setIsSuccess(false).setError("Date entered is not a future date...");
            BillpayReadResponse send = response.build();
            responseObserver.onNext(send);
            responseObserver.onCompleted();
            return;
        }

        if (request.getDue().isBlank()) {
            response.setIsSuccess(false).setError("No due date provided");
        } else {
            List<Bills> billsTemp = new ArrayList<>();
            for (Map.Entry<String, List<Bills>> entry : billsMap.entrySet()) {
                String due = entry.getKey();
                LocalDate thisBillDate = LocalDate.parse(due, formatter);

                if (thisBillDate.isBefore(dueDate) || thisBillDate.isEqual(dueDate)) {
                    billsTemp.addAll(entry.getValue());
                }
            }
            if (billsTemp.isEmpty()) {
                response.setIsSuccess(false).setError("There are no bills due before the given date.");
            } else {
                response.setIsSuccess(true).addAllBills(billsTemp);
            }
        }

        BillpayReadResponse send = response.build();
        responseObserver.onNext(send);
        responseObserver.onCompleted();
    }

    @Override
    public void pay(BillpaySearchRequest request, StreamObserver<BillpayReadResponse> responseObserver) {
        System.out.println("Client requested to pay a bill due for vendor: " + request.getVendor() + " due in " + request.getDue());
        BillpayReadResponse.Builder response = BillpayReadResponse.newBuilder();

        String vendor = request.getVendor();
        double amount = request.getAmount();
        int month = 0;

        try {
            month = Integer.parseInt(request.getDue());
        } catch (NumberFormatException e) {
            response.setIsSuccess(false).setError("Date entered is not in format MM...");
            BillpayReadResponse send = response.build();
            responseObserver.onNext(send);
            responseObserver.onCompleted();
            return;
        }

        if (vendor.isBlank()) {
            response.setIsSuccess(false).setError("No vendor provided");
        } else if (request.getDue().isBlank()) {
            response.setIsSuccess(false).setError("No due date provided");
        } else if (amount < 0) {
            response.setIsSuccess(false).setError("Cannot pay a negative amount");
        } else {
            for (Bills bill : billsList) {
                if (bill.getVendor().equalsIgnoreCase(vendor) && Integer.parseInt(bill.getDue().substring(0, 2)) == month) {
                    // pay bill
                    if (bill.getAmount() < amount) {
                        response.setIsSuccess(false).setError("You cannot pay more than you owe.");
                        BillpayReadResponse send = response.build();
                        responseObserver.onNext(send);
                        responseObserver.onCompleted();
                        return;
                    }
                    double newAmount = bill.getAmount() - amount;
                    newAmount = Double.parseDouble(String.format("%.2f", newAmount));

                    Bills paidBill = Bills.newBuilder(bill).setAmount(newAmount).build();
                    writeToEntry(paidBill);
                    response.setIsSuccess(true);
                    break;
                }
            }
        }

        BillpayReadResponse send = response.build();
        responseObserver.onNext(send);
        responseObserver.onCompleted();
    }

    @Override
    public void add(BillpayWriteRequest request, StreamObserver<BillpayWriteResponse> responseObserver) {
        System.out.println("Client requested to add the following bill to the database: " + request.getBills());
        BillpayWriteResponse.Builder response = BillpayWriteResponse.newBuilder();

        String vendor = request.getBills().getVendor();
        double amount = request.getBills().getAmount();
        String dueDateStr = request.getBills().getDue();

        if (dueDateStr.length() != 10 || dueDateStr.charAt(2) != '/' || dueDateStr.charAt(5) != '/') {
            response.setIsSuccess(false).setError("Date entered is not in format MM/DD/YYYY...");
            BillpayWriteResponse send = response.build();
            responseObserver.onNext(send);
            responseObserver.onCompleted();
            return;
        }

        if (amount <= 0) {
            response.setIsSuccess(false).setError("Amount must be positive");
            BillpayWriteResponse send = response.build();
            responseObserver.onNext(send);
            responseObserver.onCompleted();
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dueDate;

        try {
            dueDate = LocalDate.parse(dueDateStr, formatter);
        } catch (NumberFormatException e) {
            response.setIsSuccess(false).setError("Date entered is not in format MM/DD/YYYY...");
            BillpayWriteResponse send = response.build();
            responseObserver.onNext(send);
            responseObserver.onCompleted();
            return;
        }

        String currentDate = "07/10/2024";
        LocalDate current = LocalDate.parse(currentDate, formatter);

        if (dueDate.isBefore(current)) {
            response.setIsSuccess(false).setError("Date entered is not a future date...");
            BillpayWriteResponse send = response.build();
            responseObserver.onNext(send);
            responseObserver.onCompleted();
            return;
        }

        for (Bills bill : billsList) {
            String checkVendor = bill.getVendor();
            if (checkVendor.equalsIgnoreCase(vendor) && Integer.parseInt(bill.getDue().substring(0, 2)) == dueDate.getMonthValue()) {
                response.setIsSuccess(false).setError("There already exists a bill with this vendor for this month in the database.");
                responseObserver.onNext(response.build());
                responseObserver.onCompleted();
                return;
            }
        }

        writeToEntry(request.getBills());

        response.setIsSuccess(true);
        BillpayWriteResponse send = response.build();
        responseObserver.onNext(send);
        responseObserver.onCompleted();
    }

    private void writeToEntry(Bills bill) {
        try {

            BillpayReadResponse.Builder res = readEntryFile();
            Map<String, List<Bills>> entryMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

            for (Bills e : res.getBillsList()) {
                if (!entryMap.containsKey(e.getDue())) {
                    entryMap.put(e.getDue(), new ArrayList<>());
                }
                entryMap.get(e.getDue()).add(e);
            }

            if (bill != null) {
                if (!entryMap.isEmpty()) {
                    if (!entryMap.containsKey(bill.getDue())) {
                        entryMap.put(bill.getDue(), new ArrayList<>());
                    }
                    List<Bills> currentBills = entryMap.get(bill.getDue());
                    currentBills.removeIf(b -> b.getVendor().equals(bill.getVendor()));
                    currentBills.add(bill);
                } else {
                    List<Bills> temp = new ArrayList<>();
                    temp.add(bill);
                    entryMap.put(bill.getDue(), temp);
                }
            }

            res.clearBills();

            for (Map.Entry<String, List<Bills>> entry : entryMap.entrySet()) {
                List<Bills> billList = entry.getValue();
                for (Bills e : billList) {
                    if (e.getAmount() > 0) {
                        res.addBills(e);
                    }
                }
            }

            billsMap.clear();
            billsList.clear();

            billsMap = entryMap;
            billsList.addAll(res.getBillsList());

            FileOutputStream output = new FileOutputStream(entryFilename);
            res.build().writeTo(output);

        } catch (Exception e) {
            System.out.println("Issue while trying to save");
        }

    }

    private BillpayReadResponse.Builder readEntryFile() throws Exception {
        BillpayReadResponse.Builder entries = BillpayReadResponse.newBuilder();

        try {
            return entries.mergeFrom(new FileInputStream(entryFilename));
        } catch (FileNotFoundException fe) {
            System.out.println(entryFilename + ": File not found.  Creating a new file.");
            return entries;
        }
    }
}
