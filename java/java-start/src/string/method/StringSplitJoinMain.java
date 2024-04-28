package string.method;

public class StringSplitJoinMain {
    public static void main(String[] args) {
        String s = "Apple, Banana, Orange";
        String[] split = s.split(", ");
        for (String string : split) {
            System.out.println(string);
        }
        String joinStr = "";
        for (int i = 0; i < split.length; i++) {
            joinStr += split[i];
            if (i < split.length - 1) {
                joinStr += "/";
            }
        }
        System.out.println("joinStr = " + joinStr);
        String join = String.join("-", "apple", "banana", "orange");
        System.out.println("join = " + join);
        String join1 = String.join("==", split);
        System.out.println("join1 = " + join1);
    }
}
