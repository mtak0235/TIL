package poly.basic;

public class CastingMain2 {
    public static void main(String[] args) {
        Parent poly = new Child();
//        poly.childMethod();//err
//        Child child = poly;//err
        Child child = (Child) poly;
        child.childMethod();

        ((Child) poly).childMethod();
    }
}
