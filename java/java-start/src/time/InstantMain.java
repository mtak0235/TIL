package time;

import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantMain {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("now = " + now);

        ZonedDateTime zdt = ZonedDateTime.now();
        Instant from = Instant.from(zdt);
        System.out.println("from = " + from);

        Instant instant = Instant.ofEpochSecond(100);
        System.out.println("instant = " + instant);

        Instant plus = instant.plusSeconds(100);
        System.out.println("plus = " + plus);

        long epochSecond = plus.getEpochSecond();
        System.out.println("epochSecond = " + epochSecond);
    }
}
