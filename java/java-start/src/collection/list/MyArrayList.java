package collection.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
	private static final int DEFAULT_CAPACITY = 5;
	private Object[] elementData;
	private int size = 0;

	public MyArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int size) {
		elementData = new Object[size];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(E o) {
		if (size == elementData.length) {
			grow();
		}
		elementData[size] = o;
		size++;
	}

	@Override
	public void add(int index, E o) {
		if (size == elementData.length) {
			grow();
		}
		//move data
		shiftRightFrom(index);
		elementData[index] = o;
		size++;
	}

	//code added
	private void shiftRightFrom(int index) {
		for (int i = size; i > index; i--) {
			elementData[i] = elementData[i - 1];
		}
	}

	private void grow() {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity * 2;
		//make new array and copy from old one
		/**
		 E[] newArr = new E[newCapacity];
		 for (int i = 0; i < elementData.length; i++) {
		 newArr[i] = elementData[i];
		 }
		 **/
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E)elementData[index];
	}

	@Override
	public E set(int index, E element) {
		E oldValue = get(index);
		elementData[index] = element;
		return oldValue;
	}

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + ", capacity=" + elementData.length;
	}

	@Override
	//code added
	public E remove(int index) {
		E oldValue = get(index);
		shiftLeftFrom(index);
		size--;
		elementData[size] = null;
		return oldValue;
	}

	//code added
	private void shiftLeftFrom(int index) {
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
	}
}
