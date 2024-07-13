package com.mtakworld.basic.order;

public class Order {
	private Long id;
	private String itemName;
	private int itemPrice;
	private int discountPrice;

	public Order(Long id, String itemName, int itemPrice, int discountPrice) {
		this.id = id;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
	}

	@Override
	public String toString() {
		return "Order{" +
			"id=" + id +
			", itemName='" + itemName + '\'' +
			", itemPrice=" + itemPrice +
			", discountPrice=" + discountPrice +
			'}';
	}

	public Long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
}
