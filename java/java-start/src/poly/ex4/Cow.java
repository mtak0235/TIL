package poly.ex4;

public class Cow extends AbstractAnimal {

    @Override
    public void move() {
        System.out.println("쿵쿵");
    }

    @Override
    public void sound() {
        System.out.println("음메");
    }
}
