package com.example.tobby;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class Parent {

  private final String str1 = "1";
  public String str2 = "2";

  public Parent() {
  }

  private void method1() {
    System.out.println("method1");
  }

  public void method2() {
    System.out.println("method2");
  }

  private void method3() {
    System.out.println("method3");
  }
}

class Child extends Parent {

  private final String cstr2 = "2";
  public String cstr1 = "1";

  public Child() {
  }

  private Child(String str) {
    this.cstr1 = str;
  }

  public int method4(int n) {
    System.out.println("method4 :" + n);
    return n;
  }

  private int method5(int n, String s) {
    System.out.println("method5 :" + n);
    return n;
  }
}

public class ReflectionTest2 {

  @Test
  @DisplayName("Class 정보 중 이름 찾기")
  public void getClassName() throws ClassNotFoundException {
    // 가져오고 싶은 class type 알아?
    Class clazz = Child.class;
    assertThat("com.example.tobby.Child").isEqualTo(clazz.getName());

    //가져오고 싶은 class type 몰라?
    Class<?> clazz2 = Class.forName("com.example.tobby.Child");
    assertThat("com.example.tobby.Child").isEqualTo(clazz2.getName());
  }

  @Test
  @DisplayName("Class 정보 중 Constructor 찾기")
  public void getConstructor() throws ClassNotFoundException, NoSuchMethodException {
    Class<?> c = Class.forName("com.example.tobby.Child");

    // 인자 없는 constructor 가져오려면?
    Constructor<?> constructor1 = c.getDeclaredConstructor();
    assertThat("com.example.tobby.Child").isEqualTo(constructor1.getName());

    //인자 있는 constructor 가져오려면?
    Constructor constructor2 = c.getDeclaredConstructor(String.class);
    assertThat("com.example.tobby.Child").isEqualTo(constructor2.getName());

    //모든 생성자를 가져오려면?
    ArrayList<Constructor> expectedConstructors = new ArrayList<>();
    expectedConstructors.add(constructor1);
    expectedConstructors.add(constructor2);

    Constructor<?>[] constructors = c.getDeclaredConstructors();
    for (Constructor cons : constructors
    ) {
      expectedConstructors.remove(cons);
    }
    assertThat(expectedConstructors.isEmpty()).isEqualTo(true);

    //public 생성자만 가져오고 싶은걸?
    ArrayList publicConstructorsOfParentNChild = new ArrayList();
    constructors = c.getConstructors();
    Collections.addAll(publicConstructorsOfParentNChild, constructors);
    assertThat(publicConstructorsOfParentNChild.stream()
                                               .filter(x -> !(x.toString()
                                                               .contains("public")))
                                               .count()).isEqualTo(0);
  }

  @Test
  @DisplayName("Class 정보 중 Method 찾기")
  public void getMethod() throws ClassNotFoundException, NoSuchMethodException {
    Class<?> clazz = Class.forName("com.example.tobby.Child");

    // 인자가 한개인 경우?
    Method method4 = clazz.getDeclaredMethod("method4", int.class);
    assertThat(method4.toString()).isEqualTo("public int com.example.tobby.Child.method4(int)");

    //인자가 없는 경우
    Method method1 = Parent.class.getDeclaredMethod("method1");
    assertThat(method1.toString()).isEqualTo("private void com.example.tobby.Parent.method1()");

    // 인자가 여러개인 경우
    Class[] classes = {int.class, String.class};
    Method method5 = clazz.getDeclaredMethod("method5", classes);
    assertThat(method5.toString()).isEqualTo(
        "private int com.example.tobby.Child.method5(int,java.lang.String)");
  }

  @Test
  @DisplayName("Class 정보 중 Field 변경")
  public void getField()
      throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
    Class<?> clazz = Class.forName("com.example.tobby.Child");
    Field cstr1 = clazz.getDeclaredField("cstr1");
    assertThat(cstr1.toString()).isEqualTo("public java.lang.String com.example.tobby.Child.cstr1");

    //public field만 보고 싶다면?
    Field[] fields = clazz.getFields();
    assertThat(Arrays.stream(fields)
                     .filter(x -> !x.toString()
                                    .contains("public"))
                     .count() > 0).isEqualTo(false);

    //필드 변경하고 싶다면?
    Child instance = (Child) clazz.newInstance();
    cstr1.set(instance, "뽀로로");
    assertThat(instance.cstr1).isEqualTo(
        "뽀로로"
    );
  }
}



