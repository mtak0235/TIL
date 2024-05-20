package enumeration.ref3;

import static enumeration.ref3.Grade.*;

public class StringGradeEx02 {
    public static void main(String[] args) {
        int price = 10_000;

        System.out.println("basic = " + BASIC.discount(price));
        System.out.println("diamond = " + DIAMOND.discount( price));
        System.out.println("gold = " + GOLD.discount( price));

    }
}
