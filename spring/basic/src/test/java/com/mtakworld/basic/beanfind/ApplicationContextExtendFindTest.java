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
import com.mtakworld.basic.discount.DiscountPolicy;
import com.mtakworld.basic.discount.FixedDiscountPolicy;
import com.mtakworld.basic.discount.RateDiscountPolicy;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;

public class ApplicationContextExtendFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ExtendTestConfig.class);

	@Configuration
	static class ExtendTestConfig {
		@Bean
		public DiscountPolicy rateDiscountPolicy() {
			return new RateDiscountPolicy();
		}

		@Bean
		public DiscountPolicy discountPolicy() {
			return new FixedDiscountPolicy();
		}
	}

	@Test
	@DisplayName("finding by parent type, if there are two children, duplication error occurs")
	void findBeanByParentType() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
	}

	@Test
	@DisplayName("finding by parent type, if there are two children, just find by name idiot")
	void findBeanByParentTypeWithNameForTwins() {
		assertThat(ac.getBean("rateDiscountPolicy", DiscountPolicy.class)).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	@DisplayName("finding by parent type, if there are two children, just find by specific type idiot")
	void findBeanBySpecificTypeForTwins() {
		assertThat(ac.getBean(RateDiscountPolicy.class)).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	@DisplayName("find all by parent type")
	void findAllBeansByParentType() {
		assertThat(ac.getBeansOfType(DiscountPolicy.class)).hasSize(2);
	}

	@Test
	@DisplayName("find all by object type")
	void findAllBeansByObjectType() {
		Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
		for (Map.Entry<String, Object> entry : beansOfType.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
