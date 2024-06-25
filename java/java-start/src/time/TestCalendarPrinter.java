package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TestCalendarPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("년도를 입력하세요: ");
        int year = scanner.nextInt();

        System.out.print("월을 입력하세요: ");
        int month = scanner.nextInt();

        printCalendar(year, month);
    }

    private static void printCalendar(int year, int month) {
        System.out.println("Su Mo Tu We Th Fr Sa ");
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate firstDayOfNextMonth = firstDayOfMonth.plusMonths(1);
        for (int i = 0; i < firstDayOfMonth.getDayOfWeek().getValue() % 7; i++) {
            System.out.print("   ");
        }
        LocalDate iter = firstDayOfMonth;
        while (iter.isBefore(firstDayOfNextMonth)) {
            System.out.printf("%2d ", iter.getDayOfMonth());
            if (iter.getDayOfWeek() == DayOfWeek.SATURDAY)
                System.out.println();
            iter = iter.plusDays(1);
        }

    }
}
