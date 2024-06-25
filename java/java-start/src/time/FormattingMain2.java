package time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingMain2 {
    public static void main(String[] args) {
        //date & time to string
        LocalDateTime now = LocalDateTime.of(2024, 12, 31, 13, 30, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        String formatted = now.format(formatter);
        System.out.println("formatted = " + formatted);
        System.out.println("now = " + now);

        //string to date&time
        String dateTime = "2030-01-01 11:30:00";
        LocalDateTime date = LocalDateTime.parse(dateTime, formatter);
        System.out.println("date = " + date);
    }
}
