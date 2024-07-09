package collection.compare;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain2 {
	public static void main(String[] args) {
		Integer[] arr = {3, 2, 1};
		System.out.println(Arrays.toString(arr));
		System.out.println("comparator 비교");
		Arrays.sort(arr, new AscComparator());
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, new DscComparator());
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, new AscComparator().reversed());
		System.out.println(Arrays.toString(arr));

	}

	static class AscComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			System.out.println("o1=" + o1 + " o2=" + o2);
			return (o1 < o2) ? -1 : (o1 == o2) ? 0 : 1;
			//-1 을 반환하면 첫번째 값이 더 앞으로 와야하는구나. (작구나)
		}
	}
	static class DscComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			System.out.println("o1=" + o1 + " o2=" + o2);
			return ((o1 < o2) ? -1 : (o1 == o2) ? 0 : 1) * -1;
			//-1 을 반환하면 첫번째 값이 더 앞으로 와야하는구나. (작구나)
		}
	}
}
