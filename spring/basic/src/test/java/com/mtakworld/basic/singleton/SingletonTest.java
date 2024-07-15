package com.mtakworld.basic.singleton;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtakworld.basic.AppConfig;
import com.mtakworld.basic.member.MemberService;

public class SingletonTest {
	@Test
	@DisplayName("di container without spring")
	void containerWithoutSpring() {
		AppConfig appConfig = new AppConfig();
		MemberService service = appConfig.memberService();
		MemberService service1 = appConfig.memberService();
		System.out.println("service = " + service);
		System.out.println("service1 = " + service1);
		assertThat(service1).isNotSameAs(service);
	}

	@Test
	@DisplayName("spring container and singleton")
	void springContainerAndSingleton() {
		ApplicationContext appConfig = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService service1 = appConfig.getBean(MemberService.class);
		MemberService service2 = appConfig.getBean(MemberService.class);
		System.out.println("service1 = " + service1);
		System.out.println("service2 = " + service2);
		assertThat(service1).isSameAs(service2);

	}
}
