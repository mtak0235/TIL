package method;

public class Overloading2 {
    public static void main(String[] args) {
        m(1, 1.2);
    }

    public static void m(int a, double b) {
        System.out.println("No1");
    }

    public static void m(double a, double b) {
        System.out.println("No2");
    }
}
