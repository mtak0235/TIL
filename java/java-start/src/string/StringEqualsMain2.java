package string;

public class StringEqualsMain2 {
    public static void main(String[] args) {
        String a = new String("hello");
        String b = new String("hello");
        System.out.println("isSame(a,b) = " + isSame(a,b));
        String c = "hello";
        String d = "hello";
        System.out.println("isSame(c,d) = " + isSame(c,d));
    }
    private static boolean isSame(String a, String b) {
//        return a == b;
        return a.equals(b);
    }
}
