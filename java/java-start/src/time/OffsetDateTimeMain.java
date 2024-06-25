package time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeMain {
    public static void main(String[] args) {
        OffsetDateTime now = OffsetDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime localDateTime = LocalDateTime.of(2030, 1, 1, 13, 30, 50);
        System.out.println("localDateTime = " + localDateTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.of("+01:00"));
        System.out.println("offsetDateTime = " + offsetDateTime);
    }
}
