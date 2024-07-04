package generic.test.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV1 {
    public static void main(String[] args) {
        AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
        AnimalHospitalV1 catHospital = new AnimalHospitalV1();
        Dog white = new Dog("white", 100);
        Cat black = new Cat("black", 50);
        dogHospital.set(white);
        catHospital.set(black);

        dogHospital.checkup();
        catHospital.checkup();

        dogHospital.set(black); //fail param checking

        dogHospital.set(new Dog("brown", 200));
        Dog bigger = (Dog) dogHospital.bigger(white);
        System.out.println("bigger = " + bigger);
    }
}
