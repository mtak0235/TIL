package operator;

public class Comp2 {
    public static void main(String[] args) {
        String s1 = "문자열1";
        String s2 = "문자열2";

        boolean result1 = "hello".equals("hello");
        boolean result2 = s1.equals("문자열1");
        boolean result3 = s1.equals(s2);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);

    }
}
