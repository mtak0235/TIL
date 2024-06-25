package time;

import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(2050, 12, 21);
        System.out.println("now = " + now);
        System.out.println("localDate = " + localDate);

        LocalDate plusDays = localDate.plusDays(10);
        System.out.println("localDate = " + localDate);
        System.out.println("plusDays = " + plusDays);
    }
}
