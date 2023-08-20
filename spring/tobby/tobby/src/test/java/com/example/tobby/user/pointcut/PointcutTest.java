package com.example.tobby.user.pointcut;

import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class PointcutTest {
    @Test
    public void test() throws NoSuchMethodException {
        System.out.println(Target.class.getMethod("minus", int.class, int.class));
    }


    @Test
    public void methodSignaturePointcut() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

        pointcut.setExpression("execution(public int com.example.tobby.user.pointcut.Target.minus(..))");

        assertThat(pointcut.getClassFilter().matches(Target.class)).isEqualTo(true);
        Method minus = Target.class.getMethod("minus", int.class, int.class);
        assertThat(pointcut.getMethodMatcher().matches(minus, null)).isEqualTo(true);
//        System.out.println("시발롬아 " + (int) minus.invoke(new Target(),1, 2));
        assertThat(pointcut.getMethodMatcher().matches(Target.class.getMethod("plus", int.class, int.class), null)).isEqualTo(false);
    }
    @Test
    public void pointcut() throws Exception {
        tagetClassPointcutMatches("execution(* *(..))", true, true, true, true, true, true);
    }
    public void tagetClassPointcutMatches(String expression, boolean... expected)
            throws Exception {
        pointcutMatches(expression, expected[0], Target.class, "hello");
        pointcutMatches(expression, expected[1], Target.class, "hello", String.class);
        pointcutMatches(expression, expected[2], Target.class, "plus", int.class, int.class);
        pointcutMatches(expression, expected[3], Target.class, "minus", int.class, int.class);
        pointcutMatches(expression, expected[4], Target.class, "method");
        pointcutMatches(expression, expected[5], Bean.class, "method");
    }

    public void pointcutMatches(String expression, Boolean expected, Class<?> clazz,
                                String methodName, Class<?>... args) throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        assertThat(pointcut.getClassFilter().matches(clazz)
                && pointcut.getMethodMatcher().matches(clazz.getMethod(methodName,
                args), null)).isEqualTo(expected);
    }
}