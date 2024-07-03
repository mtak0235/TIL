package generic.ex1;

public class RowTypeMain {
	public static void main(String[] args) {
		GenericBox objectGenericBox = new GenericBox();
		objectGenericBox.set(10);
		Integer result = (Integer)objectGenericBox.get();
		System.out.println("result = " + result);
	}
}
