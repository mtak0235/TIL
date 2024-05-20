package enumeration.ex3;


import static enumeration.ex3.Grade.*;

public class DiscountService {
    public int discount(Grade grade, int price) {
        int discountPercent = 0;
        if (grade.equals(BASIC)) {
            discountPercent = 10;
        } else if (grade.equals(GOLD)) {
            discountPercent = 20;
        } else if (grade.equals(DIAMOND)) {
            discountPercent = 30;
        } else {
            System.out.printf("%s is not a valid discount grade.\n", grade);
        }
        return (price * discountPercent) / 100;
    }

}
