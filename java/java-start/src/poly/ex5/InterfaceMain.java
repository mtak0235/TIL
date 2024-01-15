package poly.ex5;

import poly.ex4.AbstractAnimal;

public class InterfaceMain {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();

        soundAnimal(cat);
        soundAnimal(dog);
        soundAnimal(cow);

        moveAnimal(cat);
        moveAnimal(dog);
        moveAnimal(cow);
    }
    private static void soundAnimal(InterfaceAnimal animal) {
        System.out.println("동물소리 테스트 시작");
        animal.sound();
        System.out.println("동물소리 테스트 종료");

    }
    private static void moveAnimal(InterfaceAnimal animal) {
        System.out.println("동물movement 테스트 시작");
        animal.move();
        System.out.println("동물movement 테스트 종료");

    }
}
