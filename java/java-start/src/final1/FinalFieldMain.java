package final1;

public class FinalFieldMain {
    public static void main(String[] args) {
        System.out.println("생성자 초기화");
        ConstructInit constructInit = new ConstructInit(10);
        ConstructInit constructInit1 = new ConstructInit(20);
        System.out.println("constructInit = " + constructInit.value);
        System.out.println("constructInit1.value = " + constructInit1.value);
        System.out.println("필드 초기화");
        FieldInit fieldInit = new FieldInit();
        FieldInit fieldInit1 = new FieldInit();
        FieldInit fieldInit2 = new FieldInit();
        System.out.println("fieldInit.value = " + fieldInit.value);
        System.out.println("fieldInit1.value = " + fieldInit1.value);
        System.out.println("fieldInit2.value = " + fieldInit2.value);

        System.out.println("상수");
        System.out.println(FieldInit.CONST_VALUE);

    }
}
