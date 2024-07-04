package collection.array;

public class MyArrayListV3Main {
	public static void main(String[] args) {
		MyArrayListV3 list = new MyArrayListV3(2);
		System.out.println("add data");
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println("addLast");
		list.add(3, "addLast");
		System.out.println("addFirst");
		list.add(0, "addFirst");
		System.out.println(list);

		Object remove = list.remove(4);//O(1)
		System.out.println("remove = " + remove);
		System.out.println(list);

		Object remove1 = list.remove(0);//O(n)
		System.out.println("remove1 = " + remove1);
		System.out.println(list);

	}
}
