package collection.compare;

import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

public class SortMain5 {
	public static void main(String[] args) {
		MyUser m1 = new MyUser("a", 30);
		MyUser m2 = new MyUser("b", 20);
		MyUser m3 = new MyUser("c", 10);
		TreeSet<MyUser> myUsers = new TreeSet<>();
		myUsers.add(m1);
		myUsers.add(m2);
		myUsers.add(m3);
		System.out.println("Comparable 기본 정렬");
		System.out.println(myUsers);

		TreeSet<MyUser> myUsers1 = new TreeSet<>(new IdComparator());
		myUsers1.add(m1);
		myUsers1.add(m2);
		myUsers1.add(m3);
		System.out.println("IdComparator 기본 정렬");
		System.out.println(myUsers1);

	}
}
