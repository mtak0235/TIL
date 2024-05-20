package enumeration.ex2;

public class ClassRefMain {
    public static void main(String[] args) {
        Class<? extends ClassGrade> basic = ClassGrade.BASIC.getClass();
        System.out.println("basic = " + basic);
        Class<? extends ClassGrade> gold = ClassGrade.GOLD.getClass();
        System.out.println("gold = " + gold);
        Class<? extends ClassGrade> diamond = ClassGrade.DIAMOND.getClass();
        System.out.println("diamond = " + diamond);

        System.out.println("ClassGrade.BASIC = " + ClassGrade.BASIC);
        System.out.println("ClassGrade.GOLD = " + ClassGrade.GOLD);
        System.out.println("ClassGrade.DIAMOND = " + ClassGrade.DIAMOND);
    }
}
