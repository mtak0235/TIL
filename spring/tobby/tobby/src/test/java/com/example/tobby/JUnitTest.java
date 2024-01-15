package com.example.tobby;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class JUnitTest {

  @Autowired
  ApplicationContext context;
  static ApplicationContext contextObject = null;
  static Set<JUnitTest> tests = new HashSet<>();

  @Test
  public void test1() {
    assertThat(tests).doesNotContain(this);
    tests.add(this);
    assertThat(contextObject).satisfiesAnyOf(real -> assertThat(real).isEqualTo(null),
        real -> assertThat(real).isEqualTo(this.context));
    contextObject = this.context;
  }

  @Test
  public void test2() {
    assertThat(tests).doesNotContain(this);
    tests.add(this);
    assertThat(contextObject).satisfiesAnyOf(real -> assertThat(real).isEqualTo(null),
        real -> assertThat(real).isEqualTo(this.context));
    contextObject = this.context;
  }

  @Test
  public void test3() {
    assertThat(tests).doesNotContain(this);
    tests.add(this);
    assertThat(contextObject).satisfiesAnyOf(real -> assertThat(real).isEqualTo(null),
        real -> assertThat(real).isEqualTo(this.context));
    contextObject = this.context;
  }
}
