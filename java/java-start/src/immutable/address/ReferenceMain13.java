package immutable.address;

public class ReferenceMain13 {
    public static void main(String[] args) {
        Address a = new Address("seoul");
        Address b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        extracted(b, "부산");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private static void extracted(Address b, String area) {
        b.setValue(area);
    }
}
