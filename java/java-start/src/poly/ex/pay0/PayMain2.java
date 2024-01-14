package poly.ex.pay0;

import java.nio.charset.Charset;
import java.util.Scanner;

public class PayMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayService payService = new PayService();
        System.out.print("결제 수단을 입력하세요:");
        String payOption1 = scanner.nextLine();
        System.out.print("결제 급액을 입력하세요:");
        int amount1 = scanner.nextInt();
        payService.processPay(payOption1, amount1);
    }
}
