package collection.list.test.ex2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	List<Item> list;

	public ShoppingCart() {
		list = new ArrayList<>();
	}

	public void addItem(Item item) {
		list.add(item);
	}

	public void displayItems() {
		System.out.println("장바구니 상품 출력");
		int total = 0;
		for (Item item : list) {
			System.out.println(item);
			total += item.getTotalPrice();
		}
		System.out.println("전체 가격 합:" + total);
	}
}
