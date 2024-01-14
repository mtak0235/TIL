package memory;

public class JavaMemoryMain1 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(10);
        System.out.println("main end");
    }

    private static void method1(int i) {
        System.out.println("JavaMemoryMain1.method1 start");
        method2(i * 2);
        System.out.println("JavaMemoryMain1.method1 end");
    }

    private static void method2(int i) {
        System.out.println("JavaMemoryMain1.method2 start");
        System.out.println("JavaMemoryMain1.method2 end");

    }


}
