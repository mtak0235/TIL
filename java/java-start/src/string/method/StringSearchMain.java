package string.method;

public class StringSearchMain {
    public static void main(String[] args) {
        String s = "Hello java! Welcome to java world.";
        System.out.println("s.contains(\"java\") = " + s.contains("java"));
        System.out.println("s.indexOf(\"java\") = " + s.indexOf("java"));
        System.out.println("s.indexOf(\"java\", 10) = " + s.indexOf("java", 10));
        System.out.println("s.lastIndexOf(\"java\" = " + s.lastIndexOf("java"));
    }
}
