package generic.test.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV3 {
    public static void main(String[] args) {
        AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
        AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();
//        AnimalHospitalV3<Integer> integerHospital = new AnimalHospitalV3<>(); compile err

        Dog white = new Dog("white", 100);
        Cat black = new Cat("black", 50);
        dogHospital.set(white);
        catHospital.set(black);

        dogHospital.checkup();
        catHospital.checkup();

//        dogHospital.set(black); //fail param checking

        dogHospital.set(new Dog("brown", 200));
        Dog bigger = dogHospital.bigger(white);
        System.out.println("bigger = " + bigger);
    }
}
