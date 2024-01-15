package scanner;

import java.util.Scanner;

public class ScannerEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("음식의 이름을 입력해주세요:");
        String name = scanner.nextLine();
        System.out.print("음식의 가격을 입력해주세요:");
        int foodPrice = scanner.nextInt();
        System.out.print("음식의 수량을 입력해주세요:");
        int footQuantity = scanner.nextInt();
        System.out.print(name + " " + foodPrice + "개를 주문하셨습니다. 총 가격은 " + (footQuantity * foodPrice) + "원 입니다.");
    }
}
