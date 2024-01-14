package ref;

public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("a = " + a);
        changePrimitive(a);
        System.out.println("a = " + a);

        Data data = new Data();
        data.value = 10;
        System.out.println("data.value = " + data.value);
        changeReference(data);
        System.out.println("data.value = " + data.value);

    }

    private static void changeReference(Data data) {
        data.value = 20;
    }

    static void changePrimitive(int x) {
        x = 20;
    }
}
