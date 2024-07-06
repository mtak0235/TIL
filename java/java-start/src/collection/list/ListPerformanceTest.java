package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {
	public static void main(String[] args) {
		int size = 50_000;
		System.out.println("ArrayList 추가");
		addFirst(new ArrayList<>(), size);
		addMid(new ArrayList<>(), size);
		ArrayList<Integer> arrayList = new ArrayList<>();
		addLast(arrayList, size);

		System.out.println("ArrayList 조회");
		int loop = 10_000;
		getIndex(arrayList, loop, 0);
		getIndex(arrayList, loop, size / 2);
		getIndex(arrayList, loop, size - 1);

		System.out.println("ArrayList 검색");
		search(arrayList, loop, 0);
		search(arrayList, loop, size / 2);
		search(arrayList, loop, size - 1);



		System.out.println("LinkedList 추가");
		addFirst(new LinkedList<>(), size);
		addMid(new LinkedList<>(), size);
		LinkedList<Integer> linkedList = new LinkedList<>();
		addLast(linkedList, size);

		System.out.println("LinkedList 조회");
		getIndex(linkedList, loop, 0);
		getIndex(linkedList, loop, size / 2);
		getIndex(linkedList, loop, size - 1);

		System.out.println("LinkedList 검색");
		search(linkedList, loop, 0);
		search(linkedList, loop, size / 2);
		search(linkedList, loop, size - 1);

	}

	private static void addFirst(List<Integer> list, int size) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			list.add(0, i);
		}
		long endTime = System.currentTimeMillis();
		System.out.printf("크기: %d, 계산 시간: %dms%n", size, endTime - startTime);
	}
	private static void addMid(List<Integer> list, int size) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			list.add(i / 2, i);
		}
		long endTime = System.currentTimeMillis();
		System.out.printf("크기: %d, 계산 시간: %dms%n", size, endTime - startTime);
	}
	private static void addLast(List<Integer> list, int size) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.printf("크기: %d, 계산 시간: %dms%n", size, endTime - startTime);
	}

	private static void getIndex(List<Integer> list, int loop, int index) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < loop; i++) {
			list.get(index);
		}
		long endTime = System.currentTimeMillis();
		System.out.printf("index: %d, 반복: %d, 계산 시간: %dms%n", index, loop, endTime - startTime);
	}
	private static void search(List<Integer> list, int loop, int findValue) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < loop; i++) {
			list.indexOf(findValue);
		}
		long endTime = System.currentTimeMillis();
		System.out.printf("반복: %d, 계산 시간: %dms%n", loop, endTime - startTime);
	}
}
