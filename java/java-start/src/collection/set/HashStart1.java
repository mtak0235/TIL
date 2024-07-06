package collection.set;

public class HashStart1 {
	public static void main(String[] args) {
		Integer[] inputArray = new Integer[5];
		inputArray[0] = 1;
		inputArray[1] = 2;
		inputArray[2] = 5;
		inputArray[3] = 8;
		inputArray[4] = 10;
		int searchValue = 8;
		for (Integer i : inputArray) {
			if (searchValue == i) {
				System.out.println(searchValue);
			}
		}
	}
}
