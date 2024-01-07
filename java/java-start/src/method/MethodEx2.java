package method;

public class MethodEx2 {
    public static void main(String[] args) {
        sequenceNum(3);
        sequenceNum(5);
        sequenceNum(7);

    }

    public static void sequenceNum(int n) {
        String message = "Hello, world!";
        for (int i = 0; i < n; i++) {
            System.out.println(message);
        }

    }
}
