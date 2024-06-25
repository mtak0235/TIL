package time;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChangeTimePlusMain {
    public static void main(String[] args) {
        LocalDateTime lt = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
        System.out.println("lt = " + lt);
        LocalDateTime plus = lt.plus(10, ChronoUnit.YEARS);
        System.out.println("plus = " + plus);

        Period period = Period.ofYears(10);
        LocalDateTime plus1 = lt.plus(period);
        System.out.println("plus1 = " + plus1);
    }
}
