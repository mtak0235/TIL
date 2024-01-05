package scope;

public class Scope1 {
    public static void main(String[] args) {
        int m = 10;
        if (true) {
            int x = 30;
            System.out.println("x = " + x);
            System.out.println("m = " + m);
        }
//        System.out.println("x = " + x);//err
        System.out.println("m = " + m);
    }
}
