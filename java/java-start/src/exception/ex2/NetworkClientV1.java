package exception.ex2;

public class NetworkClientV1 {
    private final String address;
    private boolean connctError;
    private boolean sendError;

    public NetworkClientV1(String address) {
        this.address = address;
    }

    public String connect() {
        if (connctError) {
            System.out.println("Server[" + address + "]:connect error");
            return "connectError";
        }
        System.out.println("Server[" + address + "]:Successfully connected");
        return "success";
    }

    public String send(String message) {
        if (sendError) {
            System.out.println("Server[" + address + "]: failed to send message " + message);
            return "sendError";
        }
        System.out.println("Server[" + address + "]:" + message);
        return "success";
    }

    public String disconnect() {
        System.out.println("Server[" + address + "]:Successfully disconnected");
        return "success";
    }

    public void initError(String data) {
        if (data.contains("error1")) {
            connctError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }
}
