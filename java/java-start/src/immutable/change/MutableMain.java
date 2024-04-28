package immutable.change;

public class MutableMain {
    public static void main(String[] args) {
        MutableObj mutableObj = new MutableObj(10);
        mutableObj.add(20);
        System.out.println("mutableObj.getValue() = " + mutableObj.getValue());
    }
}
