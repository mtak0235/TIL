package nested.inner.ex1;

public class Car {

  private String model;
  private int chargeLevel;
  private Engine engine;

  public Car(String model, int chargeLevel) {
    this.model = model;
    this.chargeLevel = chargeLevel;
    this.engine = new Engine(this);
  }
  //only for engine
  public int getChargeLevel() {
    return chargeLevel;
  }
//only for engine
  public String getModel() {
      return model;
  }

  public void start() {
    engine.start();
    System.out.println(model +" starts");
  }
}
