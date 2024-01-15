package poly.basic;

public class CastingMain1 {
    public static void main(String[] args) {
        Parent poly = new Child();
//        poly.childMethod();//err
//        Child child = poly;//err
        Child child = (Child) poly;
        child.childMethod();

    }
}
