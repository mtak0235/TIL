package nested.inner.ex2;

public class Car {

  private String model;
  private int chargeLevel;
  private Engine engine;

  public Car(String model, int chargeLevel) {
    this.model = model;
    this.chargeLevel = chargeLevel;
    this.engine = new Engine();
  }
  //only for engine
  private int getChargeLevel() {
    return chargeLevel;
  }
//only for engine
private String getModel() {
  return model;
}

  public void start() {
    engine.start();
    System.out.println(model +" starts");
  }

  private class Engine {

    public void start() {
      System.out.println("charging level" + chargeLevel);
      System.out.println("starting up" + model);
    }
  }

}
