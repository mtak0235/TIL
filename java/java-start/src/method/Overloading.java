package method;

public class Overloading {
    public static void main(String[] args) {
        int add1 = add(1, 2);
        System.out.println("add1 = " + add1);
        int a2dd = add(1, 2, 3);
        System.out.println("a2dd = " + a2dd);
    }

    public static int add(int a, int b) {
        System.out.println("No1");
        return a + b;
    }

    public static int add(int a, int b, int c) {
        System.out.println("No2");
        return a + b + c;
    }
}
