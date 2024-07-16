package com.mtakworld.basic.singleton;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtakworld.basic.AppConfig;
import com.mtakworld.basic.member.MemberRepository;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;
import com.mtakworld.basic.order.OrderService;
import com.mtakworld.basic.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
	@Test
	void configurationTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository repository = ac.getBean("memberRepository", MemberRepository.class);
		MemberRepository memberRepository = memberService.getMemberRepository();
		MemberRepository memberRepository1 = orderService.getMemberRepository();
		// assertThat(repository).isEqualTo(memberRepository1);
		// assertThat(repository).isEqualTo(memberRepository);
	}

	@Test
	void configurationTest2() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig bean = ac.getBean(AppConfig.class);
		System.out.println("bean = " + bean);
	}
}
