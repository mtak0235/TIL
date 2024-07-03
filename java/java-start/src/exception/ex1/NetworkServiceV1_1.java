package exception.ex1;

public class NetworkServiceV1_1 {

    public static final String address = "http://example.com";

    public void sendMessage(String data) {
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
