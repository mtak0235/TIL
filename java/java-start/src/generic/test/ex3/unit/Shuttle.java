package generic.test.ex3.unit;

public class Shuttle<T extends BioUnit> {
	private T value;
	public void in(T target) {
		value = target;
	}

	public void showInfo() {
		System.out.printf("이름: %s, HP: %d%n", value.getName(), value.getHp());
	}
}
