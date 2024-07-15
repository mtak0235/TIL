package com.mtakworld.basic.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mtakworld.basic.AppConfig;
import com.mtakworld.basic.member.MemberRepository;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;
import com.mtakworld.basic.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

	@Configuration
	static class SameBeanConfig {
		@Bean
		public MemberRepository memberRepository() {
			return new MemoryMemberRepository();
		}

		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}

	}

	@Test
	@DisplayName("if you have same type more than two, duplication error occurs when searching")
	void findBeanByTypeDuplicated() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
	}

	@Test
	@DisplayName("then find by name to avoid diplicated types")
	void findBeanByNameForTypeDuplicated() {
		assertThat(ac.getBean("memberRepository2", MemberRepository.class)).isInstanceOf(MemberRepository.class);
	}

	@Test
	@DisplayName("just find all instance with same type")
	void findAllBeansByType() {
		Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
		System.out.println(beansOfType);
		for (Map.Entry<String, MemberRepository> entry : beansOfType.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().toString());
		}
		assertThat(beansOfType.size()).isEqualTo(2);
	}
}
