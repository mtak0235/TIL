package string.method;

public class StringChangeMain {
    public static void main(String[] args) {
        String s = "hello java! welcome to java!";
        System.out.println("s.substring(7) = " + s.substring(7));
        System.out.println("s.substring(7, 12) = " + s.substring(7, 12));
        System.out.println("s.concat(\"!!!\") = " + s.concat("!!!"));
        System.out.println("s.replace(\"java\", \"python\") = " + s.replace("java", "python"));
        System.out.println("s.replaceFirst(\"java\", \"world\") = " + s.replaceFirst("java", "world"));
        String s1 = "        Java Programming             ";
        System.out.println("s1.toLowerCase() = " + s1.toLowerCase());
        System.out.println("s1.toUpperCase() = " + s1.toUpperCase());
        System.out.println("s1.trim() = " + s1.trim());
        System.out.println("s1.strip() = " + s1.strip());
        System.out.println("s1.stripLeading() = " + s1.stripLeading());
        System.out.println("s1.stripTrailing() = " + s1.stripTrailing());
    }
}
