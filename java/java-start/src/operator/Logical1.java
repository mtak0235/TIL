package operator;

public class Logical1 {
    public static void main(String[] args) {
        System.out.println("&&: AND");
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && false);

        System.out.println("||: OR");
        System.out.println(true || false);
        System.out.println(true || true);
        System.out.println(false || false);

        System.out.println("! : not");
        System.out.println(!true);
        System.out.println(!false);

        System.out.println("use variable");
        boolean a = true;
        boolean b = false;
        System.out.println(a && b);
    }
}
