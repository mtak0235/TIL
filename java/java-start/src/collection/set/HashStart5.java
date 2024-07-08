package collection.set;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashStart5 {
	static final int CAPACITY = 10;

	public static void main(String[] args) {
		List<Integer>[] buckets = new LinkedList[CAPACITY];
		for (int i = 0; i < CAPACITY; i++) {
			buckets[i] = new LinkedList<>();
		}
		add(buckets, 1);
		add(buckets, 2);
		add(buckets, 5);
		add(buckets, 8);
		add(buckets, 14);
		add(buckets, 99);
		add(buckets, 9);
		System.out.println("buckets = " + Arrays.toString(buckets));

		int searchValue = 9; 
		boolean contains = contains(buckets, searchValue);
		System.out.println("buckets.contains(" + searchValue + ") = " + contains);
	}

	private static void add(List<Integer>[] buckets, int value) {
		int hashIndex = hashIndex(value);
		List<Integer> bucket = buckets[hashIndex];
		if (!bucket.contains(value)) { //중복 체크 O(n)
			bucket.add(value);
		}
	}

	private static boolean contains(List<Integer>[] buckets, int searchValue) {
		int hashIndex = hashIndex(searchValue);
		List<Integer> bucket = buckets[hashIndex];//O(1)

		// for (Integer integer : bucket) {
		// 	if (integer.equals(searchValue)) {
		// 		return true;
		// 	}
		// }
		// return false;

		return bucket.contains(searchValue);//O(n)
	}
	static int hashIndex(int value) {
		return value % CAPACITY;
	}
}
