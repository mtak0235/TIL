package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV3<E> implements MySet<E> {
	static final int DEFAULT_iNITIAL_CAPACITY = 16;
	private LinkedList<E>[] buckets;
	private int size = 0;
	private int capacity = DEFAULT_iNITIAL_CAPACITY;

	public MyHashSetV3() {
		initBuckets();
	}

	private void initBuckets() {
		buckets = new LinkedList[DEFAULT_iNITIAL_CAPACITY];
		for (int i = 0; i < capacity; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	public MyHashSetV3(int capacity) {
		this.capacity = capacity;
		initBuckets();
	}

	public boolean add(E value) {
		int hashIndex = hashIndex(value);
		LinkedList<E> bucket = buckets[hashIndex];
		if (bucket.contains(value)) {
			return false;
		}
		bucket.add(value);
		size++;
		return true;
	}

	private int hashIndex(E value) {
		return Math.abs(value.hashCode()) % capacity;
	}

	public boolean contains(E searachValue) {
		int hashIndex = hashIndex(searachValue);
		LinkedList<E> bucket = buckets[hashIndex];
		return bucket.contains(searachValue);
	}

	public int getSize() {
		return size;
	}

	public boolean remove(E value) {
		int hashIndex = hashIndex(value);
		LinkedList<E> bucket = buckets[hashIndex];
		boolean result = bucket.remove(value);
		if (!result) {
			return false;
		}
		size--;
		return true;
	}

	@Override
	public String toString() {
		return "MyHashSetV3{" +
			"buckets=" + Arrays.toString(Arrays.copyOf(buckets, capacity)) +
			", size=" + size +
			", capacity=" + capacity +
			'}';
	}
}
