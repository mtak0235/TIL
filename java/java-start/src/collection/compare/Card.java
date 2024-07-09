package collection.compare;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card implements Comparable<Card>{
	public static final int MAX_NUMBER = 13;
	public static final int MIN_NUMBER = 1;

	@Override
	public int compareTo(Card o) {
		if (number < o.number)
			return -1;
		return shape.compareTo(o.shape);
	}

	public enum Shape implements Comparable<Shape> {
		SPADE("\u2660"), HEART("\u2665"), DIA("\u2666"), CLOVER("\u2663"),
		;
		private String value;

		Shape(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	private int number;
	private Shape shape;

	public int getNumber() {
		return number;
	}

	public Shape getShape() {
		return shape;
	}

	public Card(int number, Shape shape) {
		if (!(MIN_NUMBER <= number && number <= MAX_NUMBER))
			throw new OutOfRangeException("card number out of boundary");
		this.number = number;
		this.shape = shape;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Card card = (Card)o;
		return number == card.number && shape == card.shape;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, shape);
	}

	@Override
	public String toString() {
		return String.format("%d(%s)", number, shape.value);
	}
}
