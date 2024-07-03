package exception.ex0;

public class NetworkServiceV0 {

    public static final String address = "http://example.com";

    public void sendMessage(String data) {
        NetworkClientV0 client = new NetworkClientV0(address);
        client.connect();
        client.send(data);
        client.disconnect();
    }
}
