package poly.car1;

public class Driver {

    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void drive() {
        System.out.println("driving");
        car.startEngine();
        car.pressAccelerator();
        car.offEngine();
    }
}
