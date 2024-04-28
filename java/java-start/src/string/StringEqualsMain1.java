package string;

public class StringEqualsMain1 {
    public static void main(String[] args) {
        String a = new String("hello");
        String b = new String("hello");
        System.out.println("a==b = " + (a == b));
        System.out.println("a.equals(b) = " + a.equals(b));
        String c = "hello";
        String d = "hello";
        System.out.println("(c==d) = " + (c == d));
        System.out.println("c.equals(d) = " + c.equals(d));
    }
}
