package array;

import java.util.Scanner;

public class ProoductAdminEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limitation = 2;
        String[] productNames = new String[limitation];
        int[] productPrices = new int[limitation];
        int productCount = 0;
        while (true) {
            System.out.println("1. 상품 등록 | 2. 상품 목록 | 3. 종료");
            System.out.print("메뉴를 선택하세요:");
            int cmd = scanner.nextInt();
            scanner.nextLine();
            if (cmd == 1) {
                if (productCount >= limitation) {
                    System.out.println("더 이상 상품을 등록할 수 없습니다.");
                    continue;
                }
                System.out.print("상품 이름을 입력하세요:");
                productNames[productCount] = scanner.nextLine();
                System.out.print("상품 가격을 입력하세요:");
                productPrices[productCount] = scanner.nextInt();
                productCount++;
            } else if (cmd == 2) {
                if (productCount == 0) {
                    System.out.println("등록된 상품이 없습니다.");
                    continue;
                }
                for (int i = 0; i < productCount; i++) {
                    System.out.println(productNames[i] + ":\t" + productPrices[i] + "원");
                }
            } else if (cmd == 3) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else {
                System.out.println("잘못된 메뉴를 선택하셨습니다.");
            }
        }
    }
}
