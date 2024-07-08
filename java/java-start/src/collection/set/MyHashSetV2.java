package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV2 {
	static final int DEFAULT_iNITIAL_CAPACITY = 16;
	private LinkedList<Object>[] buckets;
	private int size = 0;
	private int capacity = DEFAULT_iNITIAL_CAPACITY;

	public MyHashSetV2() {
		initBuckets();
	}

	private void initBuckets() {
		buckets = new LinkedList[DEFAULT_iNITIAL_CAPACITY];
		for (int i = 0; i < capacity; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	public MyHashSetV2(int capacity) {
		this.capacity = capacity;
		initBuckets();
	}

	public boolean add(Object value) {
		int hashIndex = hashIndex(value);
		LinkedList<Object> bucket = buckets[hashIndex];
		if (bucket.contains(value)) {
			return false;
		}
		bucket.add(value);
		size++;
		return true;
	}

	private int hashIndex(Object value) {
		return Math.abs(value.hashCode()) % capacity;
	}

	public boolean contains(Object searachValue) {
		int hashIndex = hashIndex(searachValue);
		LinkedList<Object> bucket = buckets[hashIndex];
		return bucket.contains(searachValue);
	}

	public int getSize() {
		return size;
	}

	public boolean remove(Object value) {
		int hashIndex = hashIndex(value);
		LinkedList<Object> bucket = buckets[hashIndex];
		boolean result = bucket.remove(value);
		if (!result) {
			return false;
		}
		size--;
		return true;
	}

	@Override
	public String toString() {
		return "MyHashSetV2{" +
			"buckets=" + Arrays.toString(Arrays.copyOf(buckets, capacity)) +
			", size=" + size +
			", capacity=" + capacity +
			'}';
	}
}
