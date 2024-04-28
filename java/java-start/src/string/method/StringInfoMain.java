package string.method;

public class StringInfoMain {
    public static void main(String[] args) {
        String s = "hello java!";
        System.out.println("s.length() = " + s.length());
        System.out.println("s.isEmpty() = " + s.isEmpty());
        System.out.println("s.isBlank() = " + s.isBlank());
        System.out.println("\"       \".isBlank() = " + "       ".isBlank());
        System.out.println("s.charAt(0) = " + s.charAt(0));

    }
}
