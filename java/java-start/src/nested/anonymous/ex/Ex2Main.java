package nested.anonymous.ex;

import java.util.Random;

public class Ex2Main {

	interface MyOperation {
		void action();
	}

	static class Dice implements MyOperation {
		@Override
		public void action() {
			for (int i = 0; i < 3; i++) {
				System.out.println("i = " + i);
			}
		}
	}

	static class Sum implements MyOperation {

		@Override
		public void action() {
			int randomValue = new Random().nextInt(6) + 1;
			System.out.println("randomValue = " + randomValue);

		}
	}

	public static void main(String[] args) {
		hello(new Dice());
		hello(new Sum());

	}

	private static void hello(MyOperation myOperation) {
		System.out.println("starts");
		myOperation.action();
		System.out.println("ends");
	}
}
