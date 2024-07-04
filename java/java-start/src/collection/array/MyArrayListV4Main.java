package collection.array;

public class MyArrayListV4Main {
	public static void main(String[] args) {
		MyArrayListV4<String> stringList = new MyArrayListV4<>();
		stringList.add("a");
		stringList.add("B");
		// stringList.add(1); compile err
		System.out.println("stringList = " + stringList);
		System.out.println("stringList.get(0) = " + stringList.get(0));
		MyArrayListV4<Integer> intList = new MyArrayListV4<>();
		intList.add(1);
		intList.add(2);
		System.out.println("intList = " + intList);
		System.out.println("intList.get(0) = " + intList.get(0));
	}
}
