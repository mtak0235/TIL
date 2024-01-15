package method;

public class Overloading3 {
    public static void main(String[] args) {
        System.out.println("add = " + add(1, 2));
        System.out.println("add1 = " + add(1.2, 1.5));

    }

//    public static int add(int a, int b) {
//        System.out.println("No1");
//        return a + b;
//    }

    public static double add(double a, double b) {
        System.out.println("No2");
        return a + b;
    }
}
