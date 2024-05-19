package lang.wrapper.test;

public class WrapperTest1 {
    public static void main(String[] args) {
        String str1 = "10";
        String str2 = "20";
        int result = Integer.parseInt(str1) + Integer.parseInt(str2);
        System.out.println("result = " + result);

        String[] arr = {"1.5", "2.5", "3.5", "4.5", "5.5"};
        double resultDouble = 0;
        for (String str : arr) {
            resultDouble += Double.parseDouble(str);
        }
        System.out.println("resultDouble = " + resultDouble);

        String str = "100";
        Integer integer1 = Integer.valueOf(str);
        System.out.println("integer1 = " + integer1);
        int intValue = integer1.intValue();
        System.out.println("intValue = " + intValue);
        Integer integer2 = Integer.valueOf(intValue);
        System.out.println("integer2 = " + integer2);

        Integer integer11 = Integer.valueOf(str);
        System.out.println("integer11 = " + integer11);
        int intValue2 = integer11;
        System.out.println("intValue2 = " + intValue2);
        Integer inter22 = intValue2;
        System.out.println("inter22 = " + inter22);
    }
}
