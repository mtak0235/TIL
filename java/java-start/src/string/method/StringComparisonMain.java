package string.method;

public class StringComparisonMain {
    public static void main(String[] args) {
        String s = "Hello World!";
        String s1 = "hello world!";
        System.out.println("s.equals(s1) = " + s.equals(s1));
        System.out.println("s.equalsIgnoreCase(s1) = " + s.equalsIgnoreCase(s1));
        System.out.println("\"a\".compareTo(\"b\") = " + "a".compareTo("b"));
        System.out.println("\"a\".compareTo(\"c\") = " + "a".compareTo("c"));
        System.out.println("s.compareToIgnoreCase(s1) = " + s.compareToIgnoreCase(s1));
        System.out.println("s.startsWith(\"Hello\") = " + s.startsWith("Hello"));
        System.out.println("s.endsWith(\"!\") = " + s.endsWith("!"));

    }
}
