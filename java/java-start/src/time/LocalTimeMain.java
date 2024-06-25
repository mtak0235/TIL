package time;

import java.time.LocalTime;

public class LocalTimeMain {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime localTime = LocalTime.of(9, 10, 30);
        System.out.println("localTime = " + localTime);
        System.out.println("now = " + now);

        LocalTime localTime1 = localTime.plusSeconds(30);
        System.out.println("localTime1 = " + localTime1);
    }
}
