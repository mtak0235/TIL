package com.example.tobby;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.assertThat;

interface Hello {
    String sayHello(String name);

    String sayHi(String name);

    String sayThankYou(String name);
}

class HelloTarget implements Hello {

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

class HelloUppercase implements Hello {
    Hello hello;

    public HelloUppercase(Hello hello) {
        this.hello = hello;
    }

    @Override
    public String sayHello(String name) {
        return hello.sayHello(name).toUpperCase();
    }

    @Override
    public String sayHi(String name) {
        return hello.sayHi(name).toUpperCase();
    }

    @Override
    public String sayThankYou(String name) {
        return hello.sayThankYou(name).toUpperCase();
    }
}

class UppercaseHandler implements InvocationHandler {
    Object target;

    public UppercaseHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(target, args);
        if (ret instanceof String && method.getName().startsWith("say")) {
            return ((String) ret).toUpperCase();
        }
        return ret;
    }
}
public class ReflectionTest {

    @Test
    public void simpleProxy() {
        Hello hello = new HelloTarget();
        assertThat(hello.sayHello("mtak")).isEqualTo("Hello mtak");
        assertThat(hello.sayHi("mtak")).isEqualTo("Hi mtak");
        assertThat(hello.sayThankYou("mtak")).isEqualTo("Thank You mtak");

        Hello hello1 = new HelloUppercase(new HelloTarget());
        assertThat(hello1.sayHello("mtak")).isEqualTo("HELLO MTAK");
        assertThat(hello1.sayHi("mtak")).isEqualTo("HI MTAK");
        assertThat(hello1.sayThankYou("mtak")).isEqualTo("THANK YOU MTAK");

        Hello proxyHello = (Hello) Proxy.newProxyInstance(getClass().getClassLoader(),//동적으로 생성되는 dynamic proxy class에 쓸 class loader
                new Class[]{Hello.class},//구현할 interface
                new UppercaseHandler(new HelloTarget())//부가 기능과 위임 코드를 담은 InvocationHandler
        );
        assertThat(proxyHello.sayHello("mtak")).isEqualTo("HELLO MTAK");
        assertThat(proxyHello.sayHi("mtak")).isEqualTo("HI MTAK");
        assertThat(proxyHello.sayThankYou("mtak")).isEqualTo("THANK YOU MTAK");
    }


    @Test
    public void invokeMethod() throws Exception {
        String name = "Spring";
        // length()
        assertThat(name.length()).isEqualTo(6);

        Method lengthMethod = String.class.getMethod("length");
        assertThat((Integer) lengthMethod.invoke(name)).isEqualTo(6);

        // charAt()
        assertThat(name.charAt(0)).isEqualTo('S');

        Method charAtMethod = String.class.getMethod("charAt", int.class);
        assertThat((Character) charAtMethod.invoke(name, 0)).isEqualTo('S');
    }
}
