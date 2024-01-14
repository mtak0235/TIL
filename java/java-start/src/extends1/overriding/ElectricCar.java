package extends1.overriding;

public class ElectricCar extends Car {
    public void charge() {
        System.out.println("충전중");
    }
    @Override
    public void move() {
        System.out.println("전기차 러쉬");
    }
}
