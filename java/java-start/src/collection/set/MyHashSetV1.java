package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV1 {
	static final int DEFAULT_iNITIAL_CAPACITY = 16;
	LinkedList<Integer>[] buckets;
	private int size = 0;
	private int capacity = DEFAULT_iNITIAL_CAPACITY;

	public MyHashSetV1() {
		initBuckets();
	}

	private void initBuckets() {
		buckets = new LinkedList[DEFAULT_iNITIAL_CAPACITY];
		for (int i = 0; i < capacity; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	public MyHashSetV1(int capacity) {
		this.capacity = capacity;
		initBuckets();
	}

	public boolean add(int value) {
		int hashIndex = hashIndex(value);
		LinkedList<Integer> bucket = buckets[hashIndex];
		if (bucket.contains(value)) {
			return false;
		}
		bucket.add(value);
		size++;
		return true;
	}

	private int hashIndex(int value) {
		return value % capacity;
	}

	public boolean contains(int searachValue) {
		int hashIndex = hashIndex(searachValue);
		LinkedList<Integer> bucket = buckets[hashIndex];
		return bucket.contains(searachValue);
	}

	public int getSize() {
		return size;
	}

	public boolean remove(int value) {
		int hashIndex = hashIndex(value);
		LinkedList<Integer> bucket = buckets[hashIndex];
		boolean result = bucket.remove(Integer.valueOf(value));
		if (!result) {
			return false;
		}
		size--;
		return true;
	}

	@Override
	public String toString() {
		return "MyHashSetV1{" +
			"buckets=" + Arrays.toString(buckets) +
			", size=" + size +
			", capacity=" + capacity +
			'}';
	}
}
