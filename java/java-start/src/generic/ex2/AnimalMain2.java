package generic.ex2;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalMain2 {
	public static void main(String[] args) {
		Animal animal = new Animal("animal", 0);
		Dog white = new Dog("white", 100);
		Cat black = new Cat("black", 50);
		Box<Animal> animalBox = new Box<>();
		animalBox.set(white);
		Animal findAnimal = animalBox.get();
		System.out.println("findAnimal = " + findAnimal);
	}
}
