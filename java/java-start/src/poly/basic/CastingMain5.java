package poly.basic;

public class CastingMain5 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println("parent call");
        call(parent);

        Parent parent2 = new Child();
        System.out.println("parent2 call");
        call(parent2);
    }

    private static void call(Parent parent) {
        parent.parentMethod();
        if (parent instanceof Child) {
            System.out.println("Child");
            ((Child) parent).childMethod();
        }
    }
}
