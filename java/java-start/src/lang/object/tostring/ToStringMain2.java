package lang.object.tostring;

public class ToStringMain2 {
    public static void main(String[] args) {
        Car car = new Car("Tesla");
        Dog white = new Dog("흰둥이", 4);
        Dog blabk = new Dog("검둥이", 4);

        System.out.println("car = " + car);
        System.out.println("blabk = " + blabk);
        System.out.println("white = " + white);

        System.out.println("car.toString() = " + car.toString());
        System.out.println("blabk.toString() = " + blabk.toString());
        System.out.println("white.toString() = " + white.toString());

        ObjectPrinter.print(car);
        ObjectPrinter.print(blabk);
        ObjectPrinter.print(white);

        String hexString = Integer.toHexString(System.identityHashCode(white));
        System.out.println("hexString = " + hexString);
    }
}
