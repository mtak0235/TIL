package static1;

public class DataCountMain2 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Data2 a = new Data2("A", counter);
        System.out.println("a = " + a);

        Data2 b = new Data2("B", counter);
        System.out.println("b = " + b);

    }
}
