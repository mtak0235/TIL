package method;

import java.util.Scanner;
import java.util.logging.LoggingPermission;

public class MethodEx4 {
    public static void main(String[] args) {
        int balance = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-".repeat(70));
            System.out.println("1. 입금\t|2. 출금\t|3. 잔액 확인\t|4. 종료");
            System.out.println("-".repeat(70));
            System.out.print("선택:\t");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    balance = deposit(balance, scanner);
                    break;
                case 2:
                    balance = withdraw(balance, scanner);
                    continue;
                case 3:
                    System.out.println(String.format("현재 잔액:\t%d원", balance));
                    break;
                case 4:
                    System.out.println("시스텝을 종료합니다.");
                    return;
                default:
                    System.out.println("wrong action");
            }
        }
    }

    private static int withdraw(int balance, Scanner scanner) {
        System.out.print("출금액을 입력하세요:\t");
        int withdrawAmount = scanner.nextInt();
        if (balance < withdrawAmount) {
            System.out.println(String.format("%d원을 출금하려 했으나 잔액이 부족합니다.", withdrawAmount));
        } else {
            balance -= withdrawAmount;
            System.out.println(String.format("%d원을 출금하셨습니다. 현재 잔액 %d원", withdrawAmount, balance));
        }
        return balance;
    }

    private static int deposit(int balance, Scanner scanner) {
        System.out.print("입금액을 입력하세요:\t");
        int depositAmount = scanner.nextInt();
        balance += depositAmount;
        System.out.println(String.format("%d원을 입금하셨습니다. 현재 잔액 %d", depositAmount, balance));
        return balance;
    }
}
