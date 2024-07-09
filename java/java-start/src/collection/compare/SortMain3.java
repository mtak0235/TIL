package collection.compare;

import java.util.Arrays;

public class SortMain3 {
	public static void main(String[] args) {
		MyUser m1 = new MyUser("a", 30);
		MyUser m2 = new MyUser("b", 20);
		MyUser m3 = new MyUser("c", 10);
		MyUser[] arr = {m1, m2, m3};
		System.out.println("기본 데이터");
		System.out.println(Arrays.toString(arr));
		System.out.println("Comparable 기본 정렬");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		System.out.println("IdComparator 정렬");
		Arrays.sort(arr, new IdComparator());
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, new IdComparator().reversed());
		System.out.println(Arrays.toString(arr));

	}
}
