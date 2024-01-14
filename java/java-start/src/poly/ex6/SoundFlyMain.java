package poly.ex6;

import poly.ex5.InterfaceAnimal;

public class SoundFlyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Bird bird = new Bird();
        Chicken chicken = new Chicken();
        soundAnimal(dog);
        soundAnimal(bird);
        soundAnimal(chicken);
        flyAnimal(bird);
        flyAnimal(chicken);
    }

    private static void soundAnimal(AbstractAnimal animal) {
        System.out.println("sound 테스트 시작");
        animal.sound();
        System.out.println("sound 테스트 종료");

    }
    private static void flyAnimal(Fly animal) {
        System.out.println("fly 테스트 시작");
        animal.fly();
        System.out.println("fly 테스트 종료");

    }

}
