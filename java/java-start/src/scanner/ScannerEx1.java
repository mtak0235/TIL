package scanner;

import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("name\t:");
        String name = scanner.nextLine();
        System.out.print("age\t:");
        int age = scanner.nextInt();
        System.out.println("당신의 이름은 " + name + "이고 나이는, " + age + "살 입니다. ");

    }
}
