package ref;

public class VarChange1 {
    public static void main(String[] args) {
        Data a = new Data();
        a.value = 10;
        Data b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a.value = " + a.value);
        System.out.println("b.value = " + b.value);
        a.value = 20;
        System.out.println("a.value = " + a.value);
        System.out.println("b.value = " + b.value);
    }
}
