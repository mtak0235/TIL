package exception.basic.checked;

public class CheckedThrowMain {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        service.catchThrow();
        System.out.println("normal termination");
    }
}
