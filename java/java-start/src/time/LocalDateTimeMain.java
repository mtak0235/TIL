package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(1999, 6, 7, 8, 1, 1);
        System.out.println("now = " + now);
        System.out.println("localDateTime = " + localDateTime);
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime1 = " + localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.plusDays(1000);
        System.out.println("localDateTime2 = " + localDateTime2);
        LocalDateTime localDateTime3 = localDateTime.plusYears(1);
        System.out.println("localDateTime3 = " + localDateTime3);

        System.out.println(now.isBefore(localDateTime));
        System.out.println(now.isAfter(localDateTime));
        System.out.println(now.isEqual(localDateTime));


    }
}
