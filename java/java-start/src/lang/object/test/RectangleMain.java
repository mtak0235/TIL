package lang.object.test;

public class RectangleMain {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(100, 20);
        Rectangle rectangle1 = new Rectangle(100, 20);
        System.out.println(rectangle);
        System.out.println(rectangle1);
        System.out.println(rectangle1 == rectangle);
        System.out.println(rectangle1.equals(rectangle));
    }
}
