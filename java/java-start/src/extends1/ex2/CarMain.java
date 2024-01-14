package extends1.ex2;

import extends1.ex2.ElectricCar;
import extends1.ex2.GasCar;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();
        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();

    }
}
