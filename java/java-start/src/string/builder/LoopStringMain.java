package string.builder;

public class LoopStringMain {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += "hello java";

        }
        long endTime = System.currentTimeMillis();
//        System.out.println("result = " + result);
        System.out.println(endTime - startTime);
    }
}
