package static1;

public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 a = new Data3("A");
        System.out.println("a.count = " + Data3.count);
        Data3 b = new Data3("B");
        System.out.println("b.count = " + Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println("data3.count = " + data3.count);
    }
}
