package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestZone {
    public static void main(String[] args) {
        LocalDateTime localDate = LocalDateTime.of(2024, 1, 1, 9,0);
        ZonedDateTime seoul = ZonedDateTime.of(localDate, ZoneId.of("Asia/Seoul"));
        ZonedDateTime london = seoul.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime ny = seoul.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("서울의 회의 시간" + seoul);
        System.out.println("런던위 회의 시간" + london);
        System.out.println("뉴욕의 회의시간" + ny);
    }
}
