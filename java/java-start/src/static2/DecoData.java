package static2;

public class DecoData {
    private static int staticValue;

    public static void staticCall() {
        staticValue++;
        staticMethod();
//        instanceValue++;//err
//        instanceMethod();//err
    }

    private int instanceValue;
    public void instanceCall() {
        staticValue++;
        staticMethod();

        instanceValue++;
        instanceMethod();
    }

    private void instanceMethod() {
        System.out.println("instanceValue = " + instanceValue);
        System.out.println("staticValue = " + staticValue);
        System.out.println("DecoData.instanceMethod");
    }

    private static void staticMethod() {
        System.out.println("DecoData.staticMethod");
    }

    public static void staticCall(DecoData data) {
        data.instanceValue++;
        data.instanceMethod();

    }
}

