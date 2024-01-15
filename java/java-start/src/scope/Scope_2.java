package scope;

public class Scope_2 {
    public static void main(String[] args) {
        int m = 10;
        if (m > 0) {
            int tmp = m * 2;
            System.out.println("tmp = " + tmp);
        }
        System.out.println("m = " + m);
    }


}
