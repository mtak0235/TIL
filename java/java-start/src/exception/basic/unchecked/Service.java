package exception.basic.unchecked;

public class Service {
    Client client = new Client();

    public void callCatch() {
        try {
            client.call();
        } catch (RuntimeException e) {
            System.out.println("[handling exception]" + e.getMessage());
        }
        System.out.println("normal flow");
    }

    public void callThrow() {
        client.call();
    }
}
