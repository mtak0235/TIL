package oop1;

public class RectangleOpMain {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(8);
        rectangle.setHeight(5);
        System.out.println("넓이:" + rectangle.calculateArea());
        System.out.println("둘레 길이:" + rectangle.calculatePerimeter());
        System.out.println("정사각형 여부:" + rectangle.isSquare());
    }
}
