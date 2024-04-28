package string.method;

public class StringUtilsMain {
    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        Object object = new Object();
        String str = "Hello, Java!";
        System.out.println("String.valueOf(num) = " + String.valueOf(num));
        System.out.println("String.valueOf(bool) = " + String.valueOf(bool));
        System.out.println("String.valueOf(object) = " + String.valueOf(object));
        String numString = "" + num;
        System.out.println("numString = " + numString);
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            System.out.print(c);
        }
        System.out.println();

        System.out.println(String.format("num = %d, bool = %b, str = %s", num, bool, str));
        System.out.println("String.format(\"number: %.2f\", 3.1415) = " + String.format("number: %.2f", 3.1415));
        System.out.printf("number: %.2f\n", 3.1415f);
        String regex = "Hello, (Java!|World)";
        System.out.println("str.matches(regex) = " + str.matches(regex));
    }
}
