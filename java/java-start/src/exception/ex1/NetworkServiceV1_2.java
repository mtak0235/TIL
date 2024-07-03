package exception.ex1;

public class NetworkServiceV1_2 {

    public static final String address = "http://example.com";

    public void sendMessage(String data) {
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);

        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[network error] errno: " + connectResult);
            return;
        }
        String sendResult = client.send(data);
        if (isError(sendResult)) {
            System.out.println("[network error] errno: " + sendResult);
            return;
        }
        client.disconnect();
    }

    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
