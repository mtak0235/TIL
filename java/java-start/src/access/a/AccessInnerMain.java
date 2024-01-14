package access.a;

public class AccessInnerMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();
        accessData.publidField = 10;
        accessData.publicMethod();

        accessData.defaultField = 10;
        accessData.defaultMethod();

//        accessData.privateField = 3;
//        accessData.privateMethod();

        accessData.innerAccess();

    }
}
