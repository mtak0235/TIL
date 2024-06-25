package time;

import java.time.LocalDate;

public class TestLoopPlus {
    public static void main(String[] args) {
        LocalDate standard = LocalDate.of(2024, 1, 1);
        for (int i = 1; i <= 5; i++) {
            System.out.println("날짜 " + i + ":" + standard);
            standard = standard.plusWeeks(2);
        }
    }
}
