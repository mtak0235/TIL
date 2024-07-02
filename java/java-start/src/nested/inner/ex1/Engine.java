package nested.inner.ex1;

import java.sql.SQLOutput;

// only for Car
public class Engine {

  private Car car;

  public Engine(Car car) {
    this.car = car;
  }

  public void start() {
    System.out.println("charging level" + car.getChargeLevel());
    System.out.println("starting up" + car.getModel());
  }
}
