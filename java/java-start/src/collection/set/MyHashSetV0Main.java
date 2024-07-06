package collection.set;

public class MyHashSetV0Main {
	public static void main(String[] args) {
		MyHashSetV0 set = new MyHashSetV0();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		System.out.println(set);
		boolean dup = set.add(4);
		System.out.println("dup = " + dup);
		System.out.println(set);
		System.out.println("set.contains(3) = " + set.contains(3));

	}

}
