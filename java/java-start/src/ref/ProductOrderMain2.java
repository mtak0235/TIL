package ref;

import java.util.Scanner;

public class ProductOrderMain2 {
    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.productName = productName;
        productOrder.price = price;
        productOrder.quantity = quantity;
        return productOrder;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요:\t");
        int cnt = scanner.nextInt();
        scanner.nextLine();
        ProductOrder[] productOrders = new ProductOrder[cnt];
        for (int i = 1; i <= cnt; i++) {
            System.out.println(String.format("%d번째 주문 정보를 입력하세요.", i));
            System.out.print("상품명:");
            String name = scanner.nextLine();
            System.out.print("가격:");
            int price = scanner.nextInt();
            System.out.print("수량:");
            int quantitiy = scanner.nextInt();
            scanner.nextLine();
            productOrders[i - 1] = createOrder(name, price, quantitiy);
        }
        printOrders(productOrders);
        System.out.println("총 결제 금액:\t" + getTotalAmount(productOrders));
    }


    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("order = " + order);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int ret = 0;
        for (ProductOrder order : orders) {
            ret += order.price * order.quantity;
        }
        return ret;
    }
}
