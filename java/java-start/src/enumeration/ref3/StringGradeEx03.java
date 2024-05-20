package enumeration.ref3;

import static enumeration.ref3.Grade.*;

public class StringGradeEx03 {
    public static void main(String[] args) {
        int price = 10_000;
        printDiscount(BASIC, price);
        printDiscount(GOLD, price);
        printDiscount(DIAMOND, price);
    }
    private static void printDiscount(Grade grade, int price) {
        System.out.printf("%s 등급의 할인 금액:%d\n", grade.name(), grade.discount(price));
    }
}
