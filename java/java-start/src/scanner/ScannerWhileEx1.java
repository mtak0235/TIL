package scanner;

import java.util.Scanner;

public class ScannerWhileEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("name (종료입력하면 종료):");
            String name = scanner.nextLine();
            if (name.equals("종료")) {
                System.out.println("프로그램의 종료합니다.");
                return;
            }
            System.out.print("age:");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("입력한 이름 : " + name + ", 나이" + age);
        }

    }
}
