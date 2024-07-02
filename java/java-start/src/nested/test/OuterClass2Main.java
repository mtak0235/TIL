package nested.test;

public class OuterClass2Main {
	public static void main(String[] args) {
		new OuterClass2().new InnerClass().hello();
	}
}
