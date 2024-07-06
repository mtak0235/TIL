package collection.list.test.ex2;

public class Item {
	private String name;
	private int price;
	private int quantity;

	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getTotalPrice() {
		return price * quantity;
	}

	@Override
	public String toString() {
		return String.format("상품명: %s, 함계:%d", name, getTotalPrice());
	}
}
