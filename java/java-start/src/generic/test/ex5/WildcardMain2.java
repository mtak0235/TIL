package generic.test.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain2 {
	public static void main(String[] args) {
		Box<Object> objectBox = new Box<>();
		Box<Animal> animalBox = new Box<>();
		Box<Dog> dogBox = new Box<>();
		Box<Cat> catBox = new Box<>();
		dogBox.set(new Dog("멍멍이", 100));
		catBox.set(new Cat("냐옹이", 50));

		 //Animal포함 상위 타입 전달 가능
		writeBox(objectBox);
		writeBox(animalBox);
		// writeBox(dogBox); 하한 ㄴㄴ
		// writeBox(catBox); 하한 ㄴㄴ 2

		Animal animal = animalBox.get();
		System.out.println("animal = " + animal);
	}

	static void writeBox(Box<? super Animal> box) {
		box.set(new Dog("멍멍이", 100));

	}
}
