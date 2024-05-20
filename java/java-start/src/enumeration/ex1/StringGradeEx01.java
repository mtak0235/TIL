package enumeration.ex1;

public class StringGradeEx01 {
    public static void main(String[] args) {
        int price = 10_000;
        DiscountService discountService = new DiscountService();

        int basic = discountService.discount(StringGrade.BASIC, price);
        int gold = discountService.discount(StringGrade.GOLD, price);
        int diamond = discountService.discount(StringGrade.DIAMOND, price);

        System.out.println("basic = " + basic);
        System.out.println("diamond = " + diamond);
        System.out.println("gold = " + gold);

        discountService.discount("VIP", price);

    }
}
