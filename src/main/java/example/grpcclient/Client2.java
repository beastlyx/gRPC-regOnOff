package example.grpcclient;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

import service.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.protobuf.Empty; // needed to use Empty


/**
 * Client that requests `parrot` method from the `EchoServer`.
 */
public class Client2 {
    private final EchoGrpc.EchoBlockingStub blockingStubEcho;
    private final JokeGrpc.JokeBlockingStub blockingStubJoke;
    private final RegistryGrpc.RegistryBlockingStub blockingStubRegistry1;
    private final RegistryGrpc.RegistryBlockingStub blockingStubRegistry2;
    private final EncryptionGrpc.EncryptionBlockingStub blockingStubEncrypt;
    private final HometownsGrpc.HometownsBlockingStub blockingStubHometowns;
    private final BillpayGrpc.BillpayBlockingStub blockingStubBillpay;

    /**
     * Construct client for accessing server using the existing channel.
     */
    public Client2(Channel channel, Channel regChannel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
        // responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to
        // reuse Channels.
        blockingStubEcho = EchoGrpc.newBlockingStub(channel);
        blockingStubJoke = JokeGrpc.newBlockingStub(channel);
        blockingStubRegistry1 = RegistryGrpc.newBlockingStub(regChannel);
        blockingStubRegistry2 = RegistryGrpc.newBlockingStub(channel);
        blockingStubEncrypt = EncryptionGrpc.newBlockingStub(channel);
        blockingStubHometowns = HometownsGrpc.newBlockingStub(channel);
        blockingStubBillpay = BillpayGrpc.newBlockingStub(channel);
    }

    /**
     * Construct client for accessing server using the existing channel.
     */
    public Client2(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
        // responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to
        // reuse Channels.
        blockingStubEcho = EchoGrpc.newBlockingStub(channel);
        blockingStubJoke = JokeGrpc.newBlockingStub(channel);
        blockingStubRegistry1 = null;
        blockingStubRegistry2 = null;
        blockingStubEncrypt = EncryptionGrpc.newBlockingStub(channel);
        blockingStubHometowns = HometownsGrpc.newBlockingStub(channel);
        blockingStubBillpay = BillpayGrpc.newBlockingStub(channel);
    }

    public void askServerToParrot(String message) {

        ClientRequest request = ClientRequest.newBuilder().setMessage(message).build();
        ServerResponse response;
        try {
            response = blockingStubEcho.parrot(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
        System.out.println("Received from server: " + response.getMessage());
    }

    public void askForJokes(int num) {
        JokeReq request = JokeReq.newBuilder().setNumber(num).build();
        JokeRes response;

        // just to show how to use the empty in the protobuf protocol
        Empty empt = Empty.newBuilder().build();

        try {
            response = blockingStubJoke.getJoke(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
        System.out.println("Your jokes: ");
        for (String joke : response.getJokeList()) {
            System.out.println("--- " + joke);
        }
    }

    public void setJoke(String joke) {
        JokeSetReq request = JokeSetReq.newBuilder().setJoke(joke).build();
        JokeSetRes response;

        try {
            response = blockingStubJoke.setJoke(request);
            System.out.println(response.getOk());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public void getEncryption(String message, int algorithm) {
        Algorithm algo = Algorithm.forNumber(algorithm);
        Request req = Request.newBuilder().setInput(message).setAlgorithm(algo).build();
        Response response;

        try {
            response = blockingStubEncrypt.encrypt(req);
            System.out.println("Encrypted message: " + response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
        }
    }

    public void getDecryption(String message, int algorithm) {
        Algorithm algo = Algorithm.forNumber(algorithm);
        Request req = Request.newBuilder().setInput(message).setAlgorithm(algo).build();
        Response response;

        try {
            response = blockingStubEncrypt.decrypt(req);
            System.out.println("Decrypted message: " + response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
        }
    }

    public void getHometowns() {
        HometownsReadResponse response;
        try {
            response = blockingStubHometowns.read(Empty.getDefaultInstance());
            System.out.println(response.getIsSuccess());
            System.out.println(response.getError());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
        System.out.println("Hometowns read:");
        List<Hometown> hometowns = response.getHometownsList();
        for (Hometown hometown : hometowns) {
            System.out.println("\tName: " + hometown.getName());
            System.out.println("\tCity: " + hometown.getCity());
            System.out.println("\tRegion: " + hometown.getRegion());
            System.out.println();
        }
    }

    public void searchHometowns(String city) {
        HometownsSearchRequest req = HometownsSearchRequest.newBuilder().setCity(city).build();
        HometownsReadResponse response;

        try {
            response = blockingStubHometowns.search(req);
            System.out.println(response.getIsSuccess());
            System.out.println(response.getError());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
        System.out.println("Hometown search results:");
        List<Hometown> hometowns = response.getHometownsList();
        for (Hometown hometown : hometowns) {
            System.out.println("\tName: " + hometown.getName());
            System.out.println("\tCity: " + hometown.getCity());
            System.out.println("\tRegion: " + hometown.getRegion());
            System.out.println();
        }
    }

    public void writeHometowns(Hometown hometown) {
        HometownsWriteRequest req = HometownsWriteRequest.newBuilder().setHometown(hometown).build();
        HometownsWriteResponse response;

        try {
            response = blockingStubHometowns.write(req);
            System.out.println(response.getIsSuccess());
            System.out.println(response.getError());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
    }

    public void getBills() {
        BillpayReadResponse response;
        try {
            response = blockingStubBillpay.get(Empty.getDefaultInstance());
            System.out.println(response.getIsSuccess());
            System.out.println(response.getError());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
        System.out.println("Bills read:");
        List<Bills> bills = response.getBillsList();
        for (Bills bill : bills) {
            System.out.println("\tVendor: " + bill.getVendor());
            System.out.println("\tAmount due: " + bill.getAmount());
            System.out.println("\tDue date: " + bill.getDue());
            System.out.println();
        }
    }

    public void getBillsByDueDate(String dueDate) {
        BillpaySearchRequest req = BillpaySearchRequest.newBuilder().setDue(dueDate).build();
        BillpayReadResponse response;
        try {
            response = blockingStubBillpay.getByDue(req);
            System.out.println(response.getIsSuccess());
            System.out.println(response.getError());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
        System.out.println("Bills read:");
        List<Bills> bills = response.getBillsList();
        for (Bills bill : bills) {
            System.out.println("\tVendor: " + bill.getVendor());
            System.out.println("\tAmount due: " + bill.getAmount());
            System.out.println("\tDue date: " + bill.getDue());
            System.out.println();
        }
    }

    public void payBill(String vendor, double amount, String month) {
        BillpaySearchRequest req = BillpaySearchRequest.newBuilder().setVendor(vendor).setAmount(amount).setDue(month).build();
        BillpayReadResponse response;

        try {
            response = blockingStubBillpay.pay(req);
            System.out.println(response.getIsSuccess());
            System.out.println(response.getError());
            System.out.println();
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
    }

    public void addBill(Bills bill) {
        BillpayWriteRequest req = BillpayWriteRequest.newBuilder().setBills(bill).build();
        BillpayWriteResponse response;

        try {
            response = blockingStubBillpay.add(req);
            System.out.println(response.getIsSuccess());
            System.out.println(response.getError());
            System.out.println();
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
    }

    public void getNodeServices() {
        GetServicesReq request = GetServicesReq.newBuilder().build();
        ServicesListRes response;
        try {
            response = blockingStubRegistry2.getServices(request);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public void getServices() {
        GetServicesReq request = GetServicesReq.newBuilder().build();
        ServicesListRes response;
        try {
            response = blockingStubRegistry1.getServices(request);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public String getServicesAsString() {
        GetServicesReq request = GetServicesReq.newBuilder().build();
        ServicesListRes response;
        StringBuilder services = new StringBuilder();
        try {
            response = blockingStubRegistry1.getServices(request);
            services.append(response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return "";
        }
        return services.toString();
    }

    public SingleServerRes getServer(String service) {
        FindServerReq request = FindServerReq.newBuilder().setServiceName(service).build();
        SingleServerRes response;
        try {
            response = blockingStubRegistry1.findServer(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return null;
        }
        return response;
    }

    public void findServer(String name) {
        FindServerReq request = FindServerReq.newBuilder().setServiceName(name).build();
        SingleServerRes response;
        try {
            response = blockingStubRegistry1.findServer(request);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public void findServers(String name) {
        FindServersReq request = FindServersReq.newBuilder().setServiceName(name).build();
        ServerListRes response;
        try {
            response = blockingStubRegistry1.findServers(request);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 6) {
            System.out
                    .println("Expected arguments: <host(String)> <port(int)> <regHost(string)> <regPort(int)> <message(String)> <regOn(bool)>");
            System.exit(1);
        }
        int port = 9099;
        int regPort = 9003;
        String host = args[0];
        String regHost = args[2];
        String message = args[4];

        try {
            port = Integer.parseInt(args[1]);
            regPort = Integer.parseInt(args[3]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] must be an integer");
            System.exit(2);
        }

        String target = host + ":" + port;
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext().build();

        String regTarget = regHost + ":" + regPort;
        ManagedChannel regChannel = ManagedChannelBuilder.forTarget(regTarget).usePlaintext().build();

        try {

            /**
             * Your client should start off with
             * 1. contacting the Registry to check for the available services
             * 2. List the services in the terminal and the client can
             *    choose one (preferably through numbering)
             * 3. Based on what the client chooses
             *    the terminal should ask for input, eg. a new sentence, a sorting array or
             *    whatever the request needs
             * 4. The request should be sent to one of the
             *    available services (client should call the registry again and ask for a
             *    Server providing the chosen service) should send the request to this service and
             *    return the response in a good way to the client
             *
             * You should make sure your client does not crash in case the service node
             * crashes or went offline.
             */

            Client2 client = new Client2(channel, regChannel);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int option = 0;

            if (args[5].equals("true")) {
                String services = client.getServicesAsString();
                String[] strArr = services.split("services: \"services.");

                Map<String, List<String>> servicesMap = new LinkedHashMap<>();
                List<String> servicesList = new ArrayList<>();

                for (String str : strArr) {
                    if (str.contains("isSuccess: true") || str.contains("Registry")) continue;
                    servicesList.add(str.substring(0, str.indexOf("\"")));
                }

                while (true) {
                    System.out.println("Here are the registered services currently offered:");

                    for (int i = 0; i < servicesList.size(); i++) {
                        System.out.println(i + " - " + servicesList.get(i));
                    }
                    System.out.println(servicesList.size() + " - Exit");

                    System.out.println("Please choose a service by inputting a number corresponding to the service listed above:");
                    String input = reader.readLine();

                    while (true) {
                        try {
                            option = Integer.parseInt(input);
                            if (option < 0 || option > servicesList.size()) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Input must be an integer between 1 and " + (servicesList.size()));
                        }
                    }

                    if (option == servicesList.size()) {
                        System.out.println("Exiting...");
                        return;
                    }

                    String service = servicesList.get(option);

                    SingleServerRes serverRes = client.getServer("services." + service);
                    if (!serverRes.getIsSuccess()) {
                        System.out.println("Failed to find server: " + serverRes.getError());
                        continue;
                    }


                    String uri = serverRes.getConnection().getUri();
                    int portRes = serverRes.getConnection().getPort();
                    target = uri + ":" + portRes;
                    ManagedChannel newChannel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

                    Client2 newClient = new Client2(channel, newChannel);

                    switch (option) {
                        case 0:
                            newClient.askServerToParrot(message);
                            break;
                        case 1:
                            newClient.setJoke("I made a pencil with two erasers. It was pointless.");
                            break;
                        case 2:
                            System.out.println("How many jokes would you like?");
                            int numJokes;
                            try {
                                numJokes = Integer.parseInt(reader.readLine());
                            } catch (NumberFormatException nfe) {
                                System.out.println("Invalid input. Input must be an integer!");
                                continue;
                            }
                            newClient.askForJokes(numJokes);
                            break;
                        case 3:
                            System.out.println("Enter the algorithm you would like to use:\n0 - Caesar Cipher\n1 - XOR Cipher");
                            int algodec;
                            try {
                                algodec = Integer.parseInt(reader.readLine());
                                if (algodec < 0 || algodec > 1) throw new NumberFormatException();
                            } catch (NumberFormatException nfe) {
                                System.out.println("Invalid input. Input must be an integer between 0 and 1!");
                                continue;
                            }

                            System.out.println("Enter the message that you would like to decrypt:");
                            String decryptMessage = reader.readLine();
                            newClient.getDecryption(decryptMessage, algodec);

                            break;
                        case 4:
                            System.out.println("Enter the algorithm you would like to use:\n0 - Caesar Cipher\n1 - XOR Cipher");
                            int algoenc;
                            try {
                                algoenc = Integer.parseInt(reader.readLine());
                                if (algoenc < 0 || algoenc > 1) throw new NumberFormatException();
                            } catch (NumberFormatException nfe) {
                                System.out.println("Invalid input. Input must be an integer between 0 and 1!");
                                continue;
                            }

                            System.out.println("Enter the message that you would like to encrypt:");
                            String encryptMessage = reader.readLine();
                            newClient.getEncryption(encryptMessage, algoenc);

                            break;
                        case 5:
                            newClient.getHometowns();
                            break;
                        case 6:
                            System.out.println("Enter the name of the city that you would like to search:");
                            String citySearch = reader.readLine();
                            newClient.searchHometowns(citySearch);
                            break;
                        case 7:
                            System.out.println("Enter the name of the person:");
                            String name = reader.readLine();
                            System.out.println("Enter the name of the city that the person lives in:");
                            String city = reader.readLine();
                            System.out.println("Enter the name of the state or country that the city is in:");
                            String region = reader.readLine();
                            Hometown hometown = Hometown.newBuilder().setName(name).setCity(city).setRegion(region).build();
                            newClient.writeHometowns(hometown);
                            break;
                        case 8:
                            newClient.getBills();
                            break;
                        case 9:
                            System.out.println("Enter the bills you would like to see before the due date in format MM/DD/YYYY:");
                            String billDueDate = reader.readLine();
                            newClient.getBillsByDueDate(billDueDate);
                            break;
                        case 10:
                            System.out.println("Enter the vendor of the bill you would like to pay:");
                            String vendor = reader.readLine();
                            System.out.println("Enter the amount that you would like to pay as a double:");
                            double amount = 0.0;
                            while (true) {
                                try {
                                    amount = Double.parseDouble(reader.readLine());
                                    break;
                                } catch (NumberFormatException nfe) {
                                    System.out.println("Invalid input. Input must be a Double!");
                                }
                            }
                            System.out.println("Enter the month of the due date in format MM:");
                            String month = reader.readLine();
                            newClient.payBill(vendor, amount, month);
                            break;
                        case 11:
                            System.out.println("Enter the name of the vendor:");
                            String vendorAdd = reader.readLine();
                            System.out.println("Enter the amount due on the bill as a double:");
                            double amountAdd = 0.0;
                            while (true) {
                                try {
                                    amountAdd = Double.parseDouble(reader.readLine());
                                    break;
                                } catch (NumberFormatException nfe) {
                                    System.out.println("Invalid input. Input must be a Double!");
                                }
                            }
                            System.out.println("Enter the due date of the bill in format MM/DD/YYYY:");
                            String duedate = reader.readLine();
                            Bills bill = Bills.newBuilder().setVendor(vendorAdd).setAmount(amountAdd).setDue(duedate).build();
                            newClient.addBill(bill);
                            break;
                        default:
                            System.out.println("Invalid option. Please choose again.");
                            break;
                    }
                }
            }

        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            if (args[5].equals("true")) {
                regChannel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            }
        }
    }
}
