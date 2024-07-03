package generic.ex2;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalMain1 {
	public static void main(String[] args) {
		Animal animal = new Animal("animal", 0);
		Dog white = new Dog("white", 100);
		Cat black = new Cat("black", 50);
		Box<Dog> dogBox = new Box<>();
		dogBox.set(white);
		Dog dog = dogBox.get();
		System.out.println("dog = " + dog);
		Box<Cat> catBox = new Box<>();
		catBox.set(black);
		Cat cat = catBox.get();
		System.out.println("cat = " + cat);
		Box<Animal> animalBox = new Box<>();
		animalBox.set(animal);
		Animal animal1 = animalBox.get();
		System.out.println("animal1 = " + animal1);
	}
}
