package example.grpcclient;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import service.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.protobuf.Empty; // needed to use Empty


/**
 * Client that requests `parrot` method from the `EchoServer`.
 */
public class Client {
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
    public Client(Channel channel, Channel regChannel) {
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
    public Client(Channel channel) {
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
        if (args.length != 7) {
            System.out
                    .println("Expected arguments: <host(String)> <port(int)> <regHost(string)> <regPort(int)> <message(String)> <regOn(bool)> <auto(int)>");
            System.exit(1);
        }
        int port = 9099;
        int regPort = 9003;
        String host = args[0];
        String regHost = args[2];
        String message = args[4];
        int auto = Integer.parseInt(args[6]);
        try {
            port = Integer.parseInt(args[1]);
            regPort = Integer.parseInt(args[3]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] must be an integer");
            System.exit(2);
        }

        // Create a communication channel to the server (Node), known as a Channel. Channels
        // are thread-safe
        // and reusable. It is common to create channels at the beginning of your
        // application and reuse
        // them until the application shuts down.
        String target = host + ":" + port;
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS
                // to avoid
                // needing certificates.
                .usePlaintext().build();

        String regTarget = regHost + ":" + regPort;
        ManagedChannel regChannel = ManagedChannelBuilder.forTarget(regTarget).usePlaintext().build();

        try {

            // ##############################################################################
            // ## Assume we know the port here from the service node it is basically set through Gradle
            // here.
            // In your version you should first contact the registry to check which services
            // are available and what the port
            // etc is.

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

            Client client = new Client(channel, regChannel);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int option = 0;

            // Included the following tests here because I did not know how to not make the original data file not get
            // modified when doing test runs.
            if (auto == 1) {
                Hometown hometown1 = Hometown.newBuilder().setName("Borys").setCity("Chicago").setRegion("IL").build();
                Hometown hometown2 = Hometown.newBuilder().setName("Jeff").setCity("Chicago").setRegion("IL").build();
                Hometown hometown3 = Hometown.newBuilder().setName("Henry").setCity("Las Vegas").setRegion("NV").build();
                client.writeHometowns(hometown1);
                client.writeHometowns(hometown2);
                client.writeHometowns(hometown3);

                System.out.println("Testing reading data for hometowns... (expecting some output since I just added 3 hometowns)");
                client.getHometowns();
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing searching data for hometowns in Chicago...");
                client.searchHometowns("Chicago");
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing adding duplicate data for hometowns...");
                Hometown hometown = Hometown.newBuilder().setName("Borys").setCity("Chicago").setRegion("IL").build();
                client.writeHometowns(hometown);
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing reading data after adding duplicate hometowns... (should still be 3)");
                client.getHometowns();
                System.out.println();
                Thread.sleep( 2500);

                System.out.println("Testing adding unique data for hometowns... (now should be 4)");
                hometown = Hometown.newBuilder().setName("Doug").setCity("Las Vegas").setRegion("NV").build();
                client.writeHometowns(hometown);
                System.out.println();
                client.getHometowns();
                Thread.sleep(2500);

                Bills bill1 = Bills.newBuilder().setVendor("Chase").setAmount(258.45).setDue("09/29/2024").build();
                Bills bill2 = Bills.newBuilder().setVendor("Chase").setAmount(251.33).setDue("10/29/2024").build();
                Bills bill3 = Bills.newBuilder().setVendor("Bank of America").setAmount(710.82).setDue("07/29/2024").build();
                client.addBill(bill1);
                client.addBill(bill2);
                client.addBill(bill3);

                System.out.println("Testing reading data for bills... (expecting some output since I just added 3 bills)");
                client.getBills();
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing for searching for bills due before 09/30/2024... (Should give 2 bills)");
                client.getBillsByDueDate("09/30/2024");
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing for adding a new bill for vendor Chase, amount due of 250.22 with a due date of 08/29/2024...");
                Bills bill = Bills.newBuilder().setVendor("Chase").setAmount(250.22).setDue("08/29/2024").build();
                client.addBill(bill);
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing to make sure added bill is in list...");
                client.getBills();
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing for invalid payment of bill that was just added (paying more than owed)...");
                client.payBill("Chase", 350.22,"08");
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing for invalid payment of bill that was just added (paying negative amount)...");
                client.payBill("Chase", -50.22,"08");
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing for valid full payment of bill that was just added...");
                client.payBill("Chase", 250.22,"08");
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing to make sure paid bill is not longer in list...");
                client.getBills();
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing for adding a new bill for vendor Chase, amount due of 650.11 with a due date of 08/29/2024...");
                bill = Bills.newBuilder().setVendor("Chase").setAmount(650.11).setDue("08/29/2024").build();
                client.addBill(bill);
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing to make sure added bill is in list...");
                client.getBills();
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing for valid partial payment of bill that was just added...");
                client.payBill("Chase", 550.22,"08");
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing to make sure paid bill is updated in list...");
                client.getBills();
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing for adding a new bill for vendor Chase, amount due of 781.39 with a due date of 06/29/2024...");
                System.out.println("NOTE: Bill should not be added since the date is before the date of July 10th, 2024");
                bill = Bills.newBuilder().setVendor("Chase").setAmount(781.39).setDue("06/29/2024").build();
                client.addBill(bill);
                System.out.println();
                Thread.sleep(2500);

                System.out.println("Testing exiting functionality...");
                System.out.println();
                Thread.sleep(2500);
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
                if (args[5].equals("true")) {
                    regChannel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
                }
                System.exit(0);
            }
            else {
                while (true) {
                    System.out.println("Please select a service that you would like to use:");
                    System.out.println("1 - Parrot");
                    System.out.println("2 - Jokes");
                    System.out.println("3 - Encryption");
                    System.out.println("4 - Manage Hometowns");
                    System.out.println("5 - Manage bills");
                    System.out.println("6 - Exit");

                    try {
                        option = Integer.parseInt(reader.readLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid input. Input must be an integer!");
                        continue;
                    }

                    switch (option) {
                        case 1:
                            client.askServerToParrot(message);
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
                            client.askForJokes(numJokes);
                            client.setJoke("I made a pencil with two erasers. It was pointless.");
                            client.askForJokes(6);
                            break;
                        case 3:
                            System.out.println("Choose one of the following:\n1 - Encrypt\n2 - Decrypt\n");
                            int encOption;
                            try {
                                encOption = Integer.parseInt(reader.readLine());
                                if (encOption < 1 || encOption > 2) throw new NumberFormatException();
                            } catch (NumberFormatException nfe) {
                                System.out.println("Invalid input. Input must be an integer between 1 and 2!");
                                continue;
                            }

                            System.out.println("Enter the algorithm you would like to use:\n0 - Caesar Cipher\n1 - XOR Cipher");
                            int algo;
                            try {
                                algo = Integer.parseInt(reader.readLine());
                                if (algo < 0 || algo > 1) throw new NumberFormatException();
                            } catch (NumberFormatException nfe) {
                                System.out.println("Invalid input. Input must be an integer between 0 and 1!");
                                continue;
                            }

                            if (encOption == 1) {
                                System.out.println("Enter the message that you would like to encrypt:");
                                String encryptMessage = reader.readLine();
                                client.getEncryption(encryptMessage, algo);
                            } else if (encOption == 2) {
                                System.out.println("Enter the message that you would like to decrypt:");
                                String decryptMessage = reader.readLine();
                                client.getDecryption(decryptMessage, algo);
                            } else {
                                System.out.println("Invalid option for encryption.");
                            }
                            break;
                        case 4:
                            System.out.println("Choose one of the following:\n1 - Read all hometowns\n2 - Search for classmate by city\n3 - Add a new hometown");
                            int homeOption;
                            try {
                                homeOption = Integer.parseInt(reader.readLine());
                                if (homeOption < 1 || homeOption > 3) throw new NumberFormatException();
                            } catch (NumberFormatException nfe) {
                                System.out.println("Invalid input. Input must be an integer between 1 and 3!");
                                continue;
                            }

                            if (homeOption == 1) {
                                client.getHometowns();
                            } else if (homeOption == 2) {
                                System.out.println("Enter the name of the city that you would like to search:");
                                String citySearch = reader.readLine();
                                client.searchHometowns(citySearch);
                            } else if (homeOption == 3) {
                                System.out.println("Enter the name of the person:");
                                String name = reader.readLine();
                                System.out.println("Enter the name of the city that the person lives in:");
                                String city = reader.readLine();
                                System.out.println("Enter the name of the state or country that the city is in:");
                                String region = reader.readLine();
                                Hometown hometown = Hometown.newBuilder().setName(name).setCity(city).setRegion(region).build();
                                client.writeHometowns(hometown);
                            } else {
                                System.out.println("Invalid option for Hometowns.");
                            }
                            break;
                        case 5:
                            System.out.println("Choose one of the following:\n1 - Get all bills\n2 - Search for bills due before given date\n3 - Pay an existing bill\n4 - Add a new bill");
                            int billOption;
                            try {
                                billOption = Integer.parseInt(reader.readLine());
                                if (billOption < 1 || billOption > 4) throw new NumberFormatException();
                            } catch (NumberFormatException nfe) {
                                System.out.println("Invalid input. Input must be an integer between 1 and 4!");
                                continue;
                            }

                            if (billOption == 1) {
                                client.getBills();
                            } else if (billOption == 2) {
                                System.out.println("Enter the bills you would like to see before the due date in format MM/DD/YYYY:");
                                String billDueDate = reader.readLine();
                                client.getBillsByDueDate(billDueDate);
                            } else if (billOption == 3) {
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
                                client.payBill(vendor, amount, month);
                            } else if (billOption == 4) {
                                System.out.println("Enter the name of the vendor:");
                                String vendor = reader.readLine();
                                System.out.println("Enter the amount due on the bill as a double:");
                                double amount = 0.0;
                                while (true) {
                                    try {
                                        amount = Double.parseDouble(reader.readLine());
                                        break;
                                    } catch (NumberFormatException nfe) {
                                        System.out.println("Invalid input. Input must be a Double!");
                                    }
                                }
                                System.out.println("Enter the due date of the bill in format MM/DD/YYYY:");
                                String duedate = reader.readLine();
                                Bills bill = Bills.newBuilder().setVendor(vendor).setAmount(amount).setDue(duedate).build();
                                client.addBill(bill);
                            } else {
                                System.out.println("Invalid option for Bills.");
                            }
                            break;
                        case 6:
                            System.out.println("Exiting...");
                            return;
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
