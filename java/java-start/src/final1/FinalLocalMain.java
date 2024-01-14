package final1;

public class FinalLocalMain {
    public static void main(String[] args) {
        final int data1;
        data1 = 100;
//        data1 = 100;//err
        final int data2 = 10;
//        data2 = 10;//err
        method(10);
    }

    static void method(final int parameter) {
//        parameter = 10;//err
    }
}
