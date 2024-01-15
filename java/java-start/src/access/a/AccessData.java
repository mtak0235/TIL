package access.a;

public class AccessData {
    public int publidField;
    int defaultField;
    private int priateField;

    public void publicMethod() {
        System.out.println("AccessData.publicMethod");
    }

    void defaultMethod() {
        System.out.println("AccessData.defaultMethod");
    }

    private void privateMethod() {
        System.out.println("AccessData.privateMethod");
    }

    public void innerAccess() {
        System.out.println("내부 호출");
        publidField = 10;
        defaultField = 10;
        priateField = 10;
        publicMethod();
        defaultMethod();
        privateMethod();

    }
}
