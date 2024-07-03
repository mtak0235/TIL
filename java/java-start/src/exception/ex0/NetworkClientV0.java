package exception.ex0;

public class NetworkClientV0 {
    private final String address;

    public NetworkClientV0(String address) {
        this.address = address;
    }

    public String connect() {
        System.out.println("Server[" +address + "]:Successfully connected");
        return "success";
    }
    public String send(String message) {
        System.out.println("Server[" + address + "]:" + message);
        return "success";
    }
    public String disconnect() {
        System.out.println("Server["+address + "]:Successfully disconnected");
        return "success";
    }
}
