package example.grpcclient;

import buffers.ResponseProtos;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import service.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

class HomeTownsImpl extends HometownsGrpc.HometownsImplBase {
    private String entryFilename = "hometowns.txt";
    private Map<String, List<Hometown>> hometownMap;
    private List<Hometown> hometownList;

    public HomeTownsImpl() {
        super();
        hometownMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        hometownList = new ArrayList<>();
        writeToEntry(null);
    }

    @Override
    public void read(Empty empty, StreamObserver<HometownsReadResponse> responseObserver) {
        System.out.println("Received a request from client to see all hometowns");

        HometownsReadResponse.Builder response = HometownsReadResponse.newBuilder();

        if (hometownList.isEmpty()) {
            response.setIsSuccess(false).setError("No hometowns in database...");
        } else {
            response.setIsSuccess(true);
            response.addAllHometowns(hometownList);
        }

        HometownsReadResponse send = response.build();

        responseObserver.onNext(send);
        responseObserver.onCompleted();
    }

    @Override
    public void search(HometownsSearchRequest request, StreamObserver<HometownsReadResponse> responseObserver) {
        System.out.println("Client requested to see all classmates in city: " + request.getCity());

        HometownsReadResponse.Builder response = HometownsReadResponse.newBuilder();

        if (request.getCity().isBlank()) {
            response.setIsSuccess(false).setError("No city provided");
        } else {
            if (!hometownMap.containsKey(request.getCity().toString())) {
                response.setIsSuccess(false).setError("There are no records of any student in this city.");
            } else {
                response.setIsSuccess(true).addAllHometowns(hometownMap.get(request.getCity()));
            }
        }

        HometownsReadResponse send = response.build();
        responseObserver.onNext(send);
        responseObserver.onCompleted();
    }

    @Override
    public void write(HometownsWriteRequest request, StreamObserver<HometownsWriteResponse> responseObserver) {
        System.out.println("Client requested to add the following hometown data to the database: " + request.getHometown());

        String name = request.getHometown().getName();
        String city = request.getHometown().getCity();
        String region = request.getHometown().getRegion();

        HometownsWriteResponse.Builder response = HometownsWriteResponse.newBuilder();

        List<Hometown> townToSearch = hometownMap.get(city);

        if (townToSearch != null && !townToSearch.isEmpty()) {
            for (Hometown town : townToSearch) {
                String checkName = town.getName();
                String checkCity = town.getCity();
                String checkRegion = town.getRegion();

                if (checkName.equalsIgnoreCase(name) && checkCity.equalsIgnoreCase(city) && checkRegion.equalsIgnoreCase(region)) {
                    response.setIsSuccess(false).setError("This person already exists in the database.");
                    responseObserver.onNext(response.build());
                    responseObserver.onCompleted();
                    return;
                }
            }
        }

        writeToEntry(request.getHometown());

        townToSearch = hometownMap.get(city);
        if (townToSearch != null && !townToSearch.isEmpty()) {
            for (Hometown town : townToSearch) {
                String checkName = town.getName();
                String checkCity = town.getCity();
                String checkRegion = town.getRegion();
                if (checkName.equalsIgnoreCase(name) && checkCity.equalsIgnoreCase(city) && checkRegion.equalsIgnoreCase(region)) {
                    response.setIsSuccess(true);
                }
            }
        } else {
            response.setIsSuccess(false).setError("An error occurred when trying to add hometown to database...");
        }

        HometownsWriteResponse send = response.build();
        responseObserver.onNext(send);
        responseObserver.onCompleted();
    }

    private void writeToEntry(Hometown request) {
        try {
            HometownsReadResponse.Builder res = readEntryFile();

            Map<String, List<Hometown>> entryMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

            for (Hometown e : res.getHometownsList()) {
                if (!entryMap.containsKey(e.getCity())) {
                    entryMap.put(e.getCity(), new ArrayList<>());
                }
                entryMap.get(e.getCity()).add(e);
            }

            if (request != null) {
                if (!entryMap.isEmpty()) {
                    if (!entryMap.containsKey(request.getCity())) {
                        entryMap.put(request.getCity(), new ArrayList<>());
                    }
                    entryMap.get(request.getCity()).add(request);
                } else {
                    List<Hometown> temp = new ArrayList<>();
                    temp.add(request);
                    entryMap.put(request.getCity(), temp);
                }
            }

            res.clearHometowns();

            for (Map.Entry<String, List<Hometown>> entry : entryMap.entrySet()) {
                List<Hometown> hometownList = entry.getValue();
                for (Hometown e : hometownList) {
                    res.addHometowns(e);
                }
            }

            hometownMap.clear();
            hometownList.clear();

            hometownMap = entryMap;
            hometownList.addAll(res.getHometownsList());

            FileOutputStream output = new FileOutputStream(entryFilename);
            res.build().writeTo(output);

        } catch (Exception e) {
            System.out.println("Issue while trying to save");
        }

    }

    private HometownsReadResponse.Builder readEntryFile() throws Exception {
        HometownsReadResponse.Builder entries = HometownsReadResponse.newBuilder();

        try {
            return entries.mergeFrom(new FileInputStream(entryFilename));
        } catch (FileNotFoundException fe) {
            System.out.println(entryFilename + ": File not found.  Creating a new file.");
            return entries;
        }
    }
}
