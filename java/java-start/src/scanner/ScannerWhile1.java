package scanner;

import java.util.Scanner;

public class ScannerWhile1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
        String echo = scanner.nextLine();
        if (echo.equals("exit")) return ;
        System.out.println("echo = " + echo);
        }
    }
}
