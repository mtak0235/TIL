package com.mtakworld.basic.singleton;

public class StatefulService {
	private int price;

	public void order(String name, int price) {
		System.out.println("Ordering " + name + " with price " + price);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
