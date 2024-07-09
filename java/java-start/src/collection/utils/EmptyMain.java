package collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmptyMain {
	public static void main(String[] args) {
		//빈 가변 리스트
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<Integer> list1 = new LinkedList<>();

		//빈 불변 리스트
		List<Integer> list3 = Collections.emptyList();
		List<Integer> list4 = List.of();

		System.out.println("list3 = " + list3.getClass());
		System.out.println("list4 = " + list4.getClass());

		Integer[] arr = {1, 2, 3, 4, 5};
		List<Integer> useRefArr = Arrays.asList(arr);
		useRefArr.set(0, 1000);
		System.out.println("useRefArr = " + useRefArr);
		System.out.println("arr = " + Arrays.toString(arr));

	}
}
