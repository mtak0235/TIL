package immutable.address;

public class ReferenceMain2 {
    public static void main(String[] args) {
        ImmutableAddress a = new ImmutableAddress("seoul");
        ImmutableAddress b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
//        b.setValue("busan");//compile err
        b = new ImmutableAddress("busan");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
