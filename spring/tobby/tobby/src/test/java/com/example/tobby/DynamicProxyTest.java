package com.example.tobby;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicProxyTest {

  @Test
  public void pointcutAdvisor() {
    ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
    proxyFactoryBean.setTarget(new HelloTarget());
    NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
    pointcut.setMappedName("sayH*");
    proxyFactoryBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
    Helloo proxiedHello = (Helloo) proxyFactoryBean.getObject();
    assertThat(proxiedHello.sayHello("mtak")).isEqualTo("HELLO MTAK");
    assertThat(proxiedHello.sayHi("mtak")).isEqualTo("HI MTAK");
    assertThat(proxiedHello.sayThankYou("mtak")).isEqualTo("Thank You mtak");
  }

  @Test
  public void simpleProxy() {
    Helloo proxiedHello = (Helloo) Proxy.newProxyInstance(getClass().getClassLoader(),
        new Class[]{Helloo.class}, new UppercaseHandler(new
            HelloTarget()));
  }

  @Test
  public void proxyFactoryBean() {
    ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
    proxyFactoryBean.setTarget(new HelloTarget());
    proxyFactoryBean.addAdvice(new UppercaseAdvice());
    Helloo proxiedHello = (Helloo) proxyFactoryBean.getObject();
    assertThat(proxiedHello.sayHello("mtak")).isEqualTo("HELLO MTAK");
    assertThat(proxiedHello.sayHi("mtak")).isEqualTo("HI MTAK");
    assertThat(proxiedHello.sayThankYou("mtak")).isEqualTo("THANK YOU MTAK");

  }

  interface Helloo {

    String sayHello(String name);

    String sayHi(String name);

    String sayThankYou(String name);
  }

  static class UppercaseAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
      String ret = (String) invocation.proceed();
      return ret.toUpperCase();
    }
  }

  static class HelloTarget implements Helloo {

    @Override
    public String sayHello(String name) {
      return "Hello " + name;
    }

    @Override
    public String sayHi(String name) {
      return "Hi " + name;
    }

    @Override
    public String sayThankYou(String name) {
      return "Thank You " + name;
    }
  }

  @Test
  public void classNamePointcut() {
    //포인트컷 준비
    NameMatchMethodPointcut classMethodPointcut = new NameMatchMethodPointcut() {
      public ClassFilter getClassFilter() {
        return new ClassFilter() {
          public boolean matches(Class<?> clas) {
            return clas.getSimpleName()
                       .startsWith("HelloT");
          }
        };
      }
    };
    classMethodPointcut.setMappedName("sayH*");

    //test
    checkAdviced(new HelloTarget(), classMethodPointcut, true);
    class HelloWorld extends HelloTarget {

    }
    ;
    checkAdviced(new HelloWorld(), classMethodPointcut, false);

    class HelloTonight extends HelloTarget {

    }
    ;
    checkAdviced(new HelloTonight(), classMethodPointcut, true);
  }

  private void checkAdviced(Object target, Pointcut pointcut, boolean adviced) {
    ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
    proxyFactoryBean.setTarget(target);
    proxyFactoryBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
    Helloo proxiedHello = (Helloo) proxyFactoryBean.getObject();

    if (adviced) {
      assertThat(proxiedHello.sayHello("mtak")).isEqualTo("HELLO MTAK");
      assertThat(proxiedHello.sayHi("mtak")).isEqualTo("HI MTAK");
      assertThat(proxiedHello.sayThankYou("mtak")).isEqualTo("Thank You mtak");
    } else {
      assertThat(proxiedHello.sayHello("mtak")).isEqualTo("Hello mtak");
      assertThat(proxiedHello.sayHi("mtak")).isEqualTo("Hi mtak");
      assertThat(proxiedHello.sayThankYou("mtak")).isEqualTo("Thank You mtak");
    }
  }

}
