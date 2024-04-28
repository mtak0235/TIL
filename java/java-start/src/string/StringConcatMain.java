package string;

public class StringConcatMain {
    public static void main(String[] args) {
        String a = "hello";
        String b = "world";
        String concat = a.concat(b);
        String plus = a + b;
        System.out.println("concat = " + concat);
        System.out.println("plus = " + plus);
    }
}
