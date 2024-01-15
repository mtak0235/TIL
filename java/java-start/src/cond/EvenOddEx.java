package cond;

public class EvenOddEx {
    public static void main(String[] args) {
        int x = 34;
        System.out.println("x = " + x + (x % 2 == 0 ? "짝수" : "홀수"));
    }
}
