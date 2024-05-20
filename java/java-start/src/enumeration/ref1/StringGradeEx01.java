package enumeration.ref1;



public class StringGradeEx01 {
    public static void main(String[] args) {
        int price = 10_000;
        DiscountService discountService = new DiscountService();

        int basic = discountService.discount(ClassGrade.BASIC, price);
        int gold = discountService.discount(ClassGrade.GOLD, price);
        int diamond = discountService.discount(ClassGrade.DIAMOND, price);

        System.out.println("basic = " + basic);
        System.out.println("diamond = " + diamond);
        System.out.println("gold = " + gold);

//        discountService.discount("VIP", price); //err

        //no discount happened
//        ClassGrade classGrade = new ClassGrade(); //constructor private으로 막음
//        int discount = discountService.discount(classGrade, price);
//        System.out.println("discount = " + discount);

    }
}
