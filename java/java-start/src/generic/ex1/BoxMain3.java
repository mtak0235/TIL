package generic.ex1;

public class BoxMain3 {
	public static void main(String[] args) {
		GenericBox<Integer> integerGenericBox = new GenericBox<Integer>();
		integerGenericBox.set(10);
		// integerGenericBox.set("10"); compile err
		Integer integer = integerGenericBox.get();
		System.out.println("integer = " + integer);
		GenericBox<String> stringGenericBox = new GenericBox<>();
		stringGenericBox.set("hello");
		String str = stringGenericBox.get();
		System.out.println("str = " + str);

		GenericBox<Double> doubleGenericBox = new GenericBox<>();
		doubleGenericBox.set(10.5);
		Double doubleValue = doubleGenericBox.get();
		System.out.println("doubleValue = " + doubleValue);

		//type inferred
		GenericBox<Integer> integerGenericBox1 = new GenericBox<>();
	}
}
