package casting;

public class Casting3 {
    public static void main(String[] args) {
        long maxIntValue = 2147483647; //int max
        long maxIntOver = 2147483648L;
        int intValue;
        intValue = (int) maxIntValue;
        System.out.println("intValue = " + intValue);
        intValue = (int) maxIntOver;
        System.out.println("intValue = " + intValue);


    }
}
