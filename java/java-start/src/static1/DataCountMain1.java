package static1;

public class DataCountMain1 {
    public static void main(String[] args) {
        Data1 a = new Data1("A");
        System.out.println("a.count = " + a.count);

        Data1 b = new Data1("'B");
        System.out.println("b.count = " + b.count);

    }
}
