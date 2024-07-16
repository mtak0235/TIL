package com.mtakworld.basic.scope;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import lombok.RequiredArgsConstructor;

public class SingletonWithPrototypeTest {
	@Test
	void prototypeFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			PrototypeBean.class);
		PrototypeBean bean = ac.getBean(PrototypeBean.class);
		bean.addCount();
		assertThat(bean.getCount()).isEqualTo(1);
		PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
		bean1.addCount();
		assertThat(bean1.getCount()).isEqualTo(1);

	}

	@Scope("prototype")
	static class PrototypeBean {
		private int count = 0;

		public void addCount() {
			count++;
		}

		public int getCount() {
			return count;
		}

		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy");
		}
	}

	@Test
	void singletonClientUserPrototype() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			ClientBean.class, PrototypeBean.class);
		ClientBean client = ac.getBean(ClientBean.class);
		int count = client.logic();
		assertThat(count).isEqualTo(1);
		ClientBean client2 = ac.getBean(ClientBean.class);
		int count2 = client2.logic();
		assertThat(count2).isEqualTo(1);

	}

	@Scope("singleton")
	static class ClientBean {
		@Autowired
		private Provider<PrototypeBean> prototypeBeanObjectProvider;

		public int logic() {
			PrototypeBean prototypeBean = prototypeBeanObjectProvider.get();
			prototypeBean.addCount();
			return prototypeBean.getCount();
		}
	}
}
