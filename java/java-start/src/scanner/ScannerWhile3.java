package scanner;

import java.util.Scanner;

public class ScannerWhile3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            int got = scanner.nextInt();
            if (got == 0) {
                System.out.println("sum = " + sum);
                return ;
            }
            sum += got;
        }

    }
}
