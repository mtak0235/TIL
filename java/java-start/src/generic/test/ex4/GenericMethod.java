package generic.test.ex4;

public class GenericMethod {
    public static Object objMethod(Object object) {
        System.out.println("Object print:" + object);
        return object;
    }

    public static <T> T genericMethod(T object) {
        System.out.println("Object print:" + object);
        return object;
    }

    public static <T extends  Number > T numberMethod(T object) {
        System.out.println("bound print:" + object);
        return object;
    }

}
