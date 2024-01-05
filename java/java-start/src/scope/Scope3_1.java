package scope;

public class Scope3_1 {
    public static void main(String[] args) {
        int m = 10;
        int tmp = 0;
        if (m > 0) {
            tmp = m * 2;
            System.out.println("tmp = " + tmp);
        }
        System.out.println("tmp = " + tmp);
    }


}
