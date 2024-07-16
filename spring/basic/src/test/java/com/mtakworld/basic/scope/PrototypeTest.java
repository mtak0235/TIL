package com.mtakworld.basic.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class PrototypeTest {
	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			PrototypeBean.class);
		System.out.println("find prototype1");
		PrototypeBean bean = ac.getBean(PrototypeBean.class);
		System.out.println("find prototype2");
		PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
		System.out.println("bean = " + bean);
		System.out.println("bean2 = " + bean2);
		Assertions.assertThat(bean).isNotSameAs(bean2);
		ac.close();
	}

	@Scope("prototype")
	static class PrototypeBean {
		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy 실행이 안되네?");
		}
	}
}
