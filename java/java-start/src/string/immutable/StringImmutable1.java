package string.immutable;

public class StringImmutable1 {
    public static void main(String[] args) {
        String bye = "bye";
        bye.concat(" java");
        System.out.println("bye = " + bye);

        String str = "hello";
        str = str.concat(" java");
        System.out.println("str = " + str);
    }
}
