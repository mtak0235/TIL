package lang.wrapper;

public class AutoBoxingMain2 {
    public static void main(String[] args) {
        int value = 7;
        Integer boxedValue = value;//auto boxing
        int unboxedValue = boxedValue; // auto unboxing
        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);
    }
}
