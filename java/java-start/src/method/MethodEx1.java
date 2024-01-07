package method;

public class MethodEx1 {
    public static void main(String[] args) {
        sumTri(1, 2, 3);
        sumTri(15, 25, 35);
    }

    private static void sumTri(int a, int b, int c) {
        System.out.println("평군 값:\t" + (a + b + c) / 3.);
    }
}
