package poly.ex4;

public class AbstractAnimalImpl extends AbstractAnimal {
    @Override
    public void move() {
        System.out.println("AbstractAnimalImpl.move");
    }

    @Override
    public void sound() {
        System.out.println("AbstractAnimalImpl.sound");
    }
}
