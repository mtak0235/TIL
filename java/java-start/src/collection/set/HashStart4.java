package collection.set;

public class HashStart4 {
	static final int CAPACITY = 10;
	public static void main(String[] args) {
		System.out.println(hashIndex(1));
		System.out.println(hashIndex(2));
		System.out.println(hashIndex(5));
		System.out.println(hashIndex(8));
		System.out.println(hashIndex(14));
		Integer[] inputArray = new Integer[CAPACITY];
		add(inputArray);

	}

	private static void add(Integer[] inputArray) {
		int hashIndex = hashIndex(1);
		inputArray[hashIndex] = 1;
	}

	private static int hashIndex(int value) {
		return value % CAPACITY;
	}
}
