package generic.test.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {
	public static void main(String[] args) {
		Box<Object> objectBox = new Box<>();
		Box<Dog> dogBox = new Box<>();
		Box<Cat> catBox = new Box<>();
		dogBox.set(new Dog("멍멍이", 100));
		catBox.set(new Cat("냐옹이", 50));

		WildcardEx.<Dog>printGenericV1(dogBox);
		WildcardEx.printGenericV1(catBox);

		WildcardEx.printWildcardGenericV1(dogBox);

		WildcardEx.printGenericV2(dogBox);

		WildcardEx.printWildcardV2(dogBox);

		Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
		Cat cat = WildcardEx.printAndReturnGeneric(catBox);

		Animal doggie = WildcardEx.printAndReturnWildcard(dogBox);
		Dog doggie1 = (Dog)WildcardEx.printAndReturnWildcard(dogBox);

	}
}
