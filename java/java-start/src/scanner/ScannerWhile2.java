package scanner;

import java.util.Scanner;

public class ScannerWhile2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            if (i == 0 && j == 0) {
                return ;
            }
            System.out.println(i + j);

        }

    }
}
