package lang.wrapper;

public class WrapperClassMain {
    public static void main(String[] args) {
        Integer newInteger = new Integer(10);//deprecated
//        Integer newInteger = Integer.valueOf(10);
        System.out.println("newInteger = " + newInteger);

        Long newLong = Long.valueOf(10);
        System.out.println("newLong = " + newLong);

        Double newDouble = Double.valueOf(10.0);
        System.out.println("newDouble = " + newDouble);

        //내부 값 읽기
        int intValue = newInteger.intValue();
        System.out.println("intValue = " + intValue);
        long longValue = newLong.longValue();
        System.out.println("longValue = " + longValue);
        double doubleValue = newDouble.doubleValue();
        System.out.println("doubleValue = " + doubleValue);

        //비교
        Integer valueOfInteger = Integer.valueOf(10);
        Integer valueOfInteger1 = Integer.valueOf(10);
        System.out.println("valueOfInteger1 == valueOfInteger = " + (valueOfInteger1 == valueOfInteger));
        System.out.println("valueOfInteger1.equals(valueOfInteger) = " + valueOfInteger1.equals(valueOfInteger));

        System.out.println("newInteger == valueOfInteger = " + (newInteger == valueOfInteger));
        System.out.println("(newInteger.equals(valueOfInteger)) = " + (newInteger.equals(valueOfInteger)));
    }
}
