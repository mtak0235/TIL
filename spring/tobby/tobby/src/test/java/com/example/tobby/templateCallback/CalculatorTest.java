package com.example.tobby.templateCallback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  Calculator calculator;
  String numFilePath;

  @BeforeEach
  public void setUp() {
    this.calculator = new Calculator();
    this.numFilePath = "C:\\Users\\192293\\TIL\\spring\\tobby\\tobby\\src\\test\\java\\com\\example\\tobby\\numbers.txt";
  }

  @Test
  void calcSum() throws IOException {
    assertThat(this.calculator.calcSum(this.numFilePath)).isEqualTo(10);
  }

  @Test
  void calcMultiply() throws IOException {
    assertThat(this.calculator.calcMultiply(this.numFilePath)).isEqualTo(24);
  }

  @Test
  public void concatenate() {
    assertThat(this.calculator.concatenate(this.numFilePath)).isEqualTo("1234");
  }
}