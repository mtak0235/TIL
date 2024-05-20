package enumeration.ex2;

import enumeration.ex1.StringGrade;

public class DiscountService {
    public int discount(ClassGrade grade, int price) {
        int discountPercent = 0;
        if (grade.equals(ClassGrade.BASIC)) {
            discountPercent = 10;
        } else if (grade.equals(ClassGrade.GOLD)) {
            discountPercent = 20;
        } else if (grade.equals(ClassGrade.DIAMOND)) {
            discountPercent = 30;
        } else {
            System.out.printf("%s is not a valid discount grade.\n", grade);
        }
        return (price * discountPercent) / 100;
    }

}
