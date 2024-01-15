package com.example.tobby.dip;

interface Bulb {

  void lightOn();

  void lightOff();
}

public class SwitchService {

  boolean isOn = false;
  Bulb bulb;

  public SwitchService(Bulb bulb) {
    this.bulb = bulb;
  }

  public void toggle() {
    isOn = !isOn;
    if (isOn) {
      bulb.lightOn();
    } else {
      bulb.lightOff();
    }
  }
}

class BulbFactory {

  public Bulb bulb() {
    return new Lamp();
  }

  public SwitchService switchService() {
    return new SwitchService(bulb());
  }
}

class Lamp implements Bulb {

  public void lightOn() {
    System.out.println("lamp on");
  }

  public void lightOff() {
    System.out.println("lamp off");
  }
}
