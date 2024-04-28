package immutable.change;

public class ImmutableMain {
    public static void main(String[] args) {
        ImmutableObj immutableObj = new ImmutableObj(10);
        ImmutableObj added = immutableObj.add(20);
        System.out.println("immutableObj.getValue() = " + immutableObj.getValue());
        System.out.println("added.getValue() = " + added.getValue());
    }
}
