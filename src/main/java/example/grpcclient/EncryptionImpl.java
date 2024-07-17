package example.grpcclient;

import io.grpc.stub.StreamObserver;
import service.EncryptionGrpc;
import service.Request;
import service.Response;

class EncryptionImpl extends EncryptionGrpc.EncryptionImplBase {

    @Override
    public void encrypt(Request req, StreamObserver<Response> responseObserver) {
        System.out.println("Received the following string to encrypt from client: " + req.getInput());

        Response.Builder response = Response.newBuilder();

        if (req.getInput().isEmpty()) {
            response.setIsSuccess(false).setError("No message provided");
        } else {
            response.setIsSuccess(true);
            switch(req.getAlgorithm()) {
                case ALGO1:
                    response.setSolution(caesarCipher(req.getInput(), true));
                    break;
                case ALGO2:
                    response.setSolution(xorCipher(req.getInput()));
                    break;
                default:
                    //error
                    response.setIsSuccess(false).setError("Invalid algorithm");
            }
        }
        Response send = response.build();
        responseObserver.onNext(send);
        responseObserver.onCompleted();
    }


    @Override
    public void decrypt(Request req, StreamObserver<Response> responseObserver) {
        System.out.println("Received the following string to decrypt from client: " + req.getInput());

        Response.Builder response = Response.newBuilder();

        if (req.getInput().isEmpty()) {
            response.setIsSuccess(false).setError("No message provided");
        } else {
            response.setIsSuccess(true);
            switch(req.getAlgorithm()) {
                case ALGO1:
                    response.setSolution(caesarCipher(req.getInput(), false));
                    break;
                case ALGO2:
                    response.setSolution(xorCipher(req.getInput()));
                    break;
                default:
                    //error
                    response.setIsSuccess(false).setError("Invalid algorithm");
            }
        }
        Response send = response.build();
        responseObserver.onNext(send);
        responseObserver.onCompleted();
    }

    private String caesarCipher(String input, boolean encrypt) {
        int shift = input.length() % 11;
        int offset = encrypt ? shift : (94 - shift);
        StringBuilder str = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c >= 32 && c <= 126) {
                int originalPosition = c - 32;
                int newPosition = (originalPosition + offset) % 94;
                if (newPosition < 0) {
                    newPosition += 94;
                }
                char newChar = (char) (newPosition + 32);
                str.append(newChar);
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }

    private String xorCipher(String input) {
        char xorKey = 'Q';
        StringBuilder str = new StringBuilder();

        for (char c : input.toCharArray()) {
            str.append((char)(c ^ xorKey));
        }

        return str.toString();
    }
}
