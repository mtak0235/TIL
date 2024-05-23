package enumeration.test;

import java.util.Arrays;
import java.util.Scanner;

public class AuthGradeMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("당신의 등급을 입력하세요 %s:", Arrays.toString(AuthGrade.values()));
        String cmd = scanner.nextLine();
        AuthGrade.valueOf(cmd.toUpperCase()).getMenu();
    }
}
