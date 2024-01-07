package method;

public class MethodTest {
    public static void main(String[] args) {

        double number = 1.5;
//        printNumber(number);//err
        printNumber((int) number);
        int number1 = 100;
        printNumber1(number1);
    }

    private static void printNumber1(double number1) {
        System.out.println("number1 = " + number1);
    }

    private static void printNumber(int number) {
        System.out.println("number = " + number);
    }
}
