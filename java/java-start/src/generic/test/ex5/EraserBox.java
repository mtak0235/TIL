package generic.test.ex5;

public class EraserBox<T> {
	public boolean instanceCheck(Object param) {
		// return param instanceof T;
		return true;
	}

	public T create() {
		// return new T();
		return null;
	}
}
