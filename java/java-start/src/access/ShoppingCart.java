package access;

import java.util.Arrays;

public class ShoppingCart {
    Item[] items;
    int cnt = 0;

    public ShoppingCart() {
        items = new Item[10];
    }

    public void addItem(Item item) {
        if (item != null && cnt < 10) {
            items[cnt++] = item;
            return;
        }
        System.out.println("장바구니가 가득 찼습니다.");
    }
    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (Item item : Arrays.copyOfRange(items, 0, cnt)) {
            System.out.println(String.format("상품명:%s, 합계:%d", item.getName(),  item.getCost()));
        }
    }
}
