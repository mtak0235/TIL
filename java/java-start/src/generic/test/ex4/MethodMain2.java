package generic.test.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain2 {
    public static void main(String[] args) {
        Dog white = new Dog("white", 100);
        Cat black = new Cat("black", 100);
        AnimalMethod.checkup(white);
        AnimalMethod.checkup(black);

        Dog biggerPuppy = new Dog("bigger puppy", 200);
        Dog bigger = AnimalMethod.bigger(white, biggerPuppy);
        System.out.println("bigger = " + bigger);
    }
}
