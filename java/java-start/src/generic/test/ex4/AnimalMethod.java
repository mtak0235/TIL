package generic.test.ex4;

import generic.animal.Animal;

public class AnimalMethod {

    public static <T extends Animal> void checkup(T t) {
        System.out.println("동물 이름: " + t.getName());
        System.out.println("동물 크기: " + t.getSize());
        t.sound();
    }

    public static <T extends Animal> T bigger(T target1, T target2) {
        return target1.getSize() > target2.getSize() ? target1 : target2;}
}
