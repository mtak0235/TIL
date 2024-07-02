package nested.anonymous;

import nested.local.Printer;

public class AnonymousOuter {
	private int outInstanceVar = 3;

	public void process(int paramVar) {
		int localVar = 1;

		Printer localPrinter = new Printer() {
			final int value = 0;

			@Override
			public void printData() {
				System.out.println("value = " + value);
				System.out.println("localVar = " + localVar);
				System.out.println("paramVar = " + paramVar);
				System.out.println("outInstanceVar = " + outInstanceVar);
			}
		};
		localPrinter.printData();
		System.out.println("localPrinter.getClass() = " + localPrinter.getClass());
	}

	public static void main(String[] args) {
		AnonymousOuter main = new AnonymousOuter();
		main.process(2);
	}
}
