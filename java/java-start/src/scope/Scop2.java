package scope;

public class Scop2 {
    public static void main(String[] args) {
        int m = 10;
        for (int i = 0; i < 2; i++) {
            System.out.println("i = " + i);
            System.out.println("m = " + m);
        }
//        System.out.println("i = " + i);//err
        System.out.println("m = " + m);
    }
}
