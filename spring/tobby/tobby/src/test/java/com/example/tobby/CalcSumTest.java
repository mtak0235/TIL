package com.example.tobby;

import com.example.tobby.templateCallback.Calculator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcSumTest {

  @Test
  public void sumOfNumbers() throws IOException {
    Calculator calculator = new Calculator();
    Integer sum = calculator.calcSum(
        "C:\\Users\\192293\\TIL\\spring\\tobby\\tobby\\src\\test\\java\\com\\example\\tobby\\numbers.txt");
    assertThat(sum).isEqualTo(10);

  }
}
