package generic.test.ex3.unit;

public class UnitPrinter<E> {
	public static <T extends Shuttle> void printV1(T element) {
		element.showInfo();
	}

	public static void printV2(Shuttle<?> element) {
		element.showInfo();
	}
}
