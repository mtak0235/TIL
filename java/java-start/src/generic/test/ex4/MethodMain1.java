package generic.test.ex4;

public class MethodMain1 {
    public static void main(String[] args) {
        Integer i = 10;
        Object object = GenericMethod.objMethod(i);

        System.out.println("명시적 타입 인자 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i);
        System.out.println("result = " + result);
        Integer integerValue = GenericMethod.<Integer>numberMethod(i);
        Double doubleValue = GenericMethod.<Double>numberMethod(20.0);

        System.out.println("type inferred");
        Integer integerValue1 = GenericMethod.numberMethod(i);
        Double doubleValue1 = GenericMethod.numberMethod(20.0);
    }
}
