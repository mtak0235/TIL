package nested.anonymous.ex;

import java.util.Random;

public class Ex3Main {

	interface MyOperation {
		void action();
	}
	public static void main(String[] args) {
		hello(() -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("i = " + i);
			}
		});
		hello(() -> {
			int randomValue = new Random().nextInt(6) + 1;
			System.out.println("randomValue = " + randomValue);
		});
	}

	private static void hello(MyOperation myOperation) {
		System.out.println("starts");
		myOperation.action();
		System.out.println("ends");
	}
}
