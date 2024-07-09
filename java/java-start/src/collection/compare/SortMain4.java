package collection.compare;

import java.util.Collections;
import java.util.LinkedList;

public class SortMain4 {
	public static void main(String[] args) {
		MyUser m1 = new MyUser("a", 30);
		MyUser m2 = new MyUser("b", 20);
		MyUser m3 = new MyUser("c", 10);
		LinkedList<MyUser> list = new LinkedList<>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		System.out.println("기본 정렬");
		System.out.println(list);
		System.out.println("Comparable 기본 정렬");
		// list.sort(null);
		Collections.sort(list);
		System.out.println(list);

		System.out.println("IdComparator 정렬");
		// list.sort(new IdComparator());
		Collections.sort(list, new IdComparator());
		System.out.println(list);

	}
}
