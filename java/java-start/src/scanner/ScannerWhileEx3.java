package scanner;

import java.util.Scanner;

public class ScannerWhileEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("슷자를 입력하세요. 입력을 중단하려면 -1을 입력하세요");
        int sum = 0;
        int cnt = 0;
        while (true) {
            int i = scanner.nextInt();
            if (i == -1) {
                System.out.println("입력한 숫자들의 합계: " + sum);
                System.out.println("입력한 숫자들의 평균: " + (double)sum / cnt);
                return;
            }
            sum += i;
            cnt++;
        }
    }
}
