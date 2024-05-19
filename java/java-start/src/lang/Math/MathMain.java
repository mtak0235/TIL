package lang.Math;

public class MathMain {
    public static void main(String[] args) {
        System.out.println("Math.max(10, 20) = " + Math.max(10, 20));
        System.out.println("Math.min(10, 20) = " + Math.min(10, 20));
        System.out.println("Math.abs(-10) = " + Math.abs(-10));
        System.out.println("Math.ceil(2.3) = " + Math.ceil(2.3));
        System.out.println("Math.floor(2.3) = " + Math.floor(2.3));
        System.out.println("Math.round(2.5) = " + Math.round(2.5));

        System.out.println("Math.sqrt(4) = " + Math.sqrt(4));
        System.out.println("Math.random() = " + Math.random() * 3); //0.0 ~ 1.0

    }
}
