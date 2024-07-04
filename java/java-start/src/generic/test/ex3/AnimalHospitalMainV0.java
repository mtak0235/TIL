package generic.test.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV0 {
    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();
        Dog white = new Dog("white", 100);
        Cat black = new Cat("black", 50);
        dogHospital.set(white);
        catHospital.set(black);

        dogHospital.checkup();
        catHospital.checkup();

//        dogHospital.set(black); 다른 타입 입력하면 compile err
        dogHospital.set(new Dog("brown", 200));
        Dog bigger = dogHospital.bigger(white);
        System.out.println("bigger = " + bigger);
    }
}
