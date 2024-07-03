package exception.basic.checked;

public class Service {
    Client client = new Client();

    //처리
    public void callCatch() {
        try {
            client.call();
        } catch (MyCheckedException e) {
            System.out.println("error handling: " + e.getMessage());
        }
        System.out.println("normal flow");
    }

    //던지기
    public void catchThrow() throws MyCheckedException {
        client.call();
    }
}
