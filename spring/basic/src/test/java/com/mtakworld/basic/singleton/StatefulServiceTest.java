package com.mtakworld.basic.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService service = ac.getBean(StatefulService.class);
		StatefulService service1 = ac.getBean(StatefulService.class);
		service.order("mtak", 10000);
		service1.order("yeji", 20000);
		Assertions.assertThat(service.getPrice()).isEqualTo(10000);
	}

	@Configuration
	static class TestConfig {
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}