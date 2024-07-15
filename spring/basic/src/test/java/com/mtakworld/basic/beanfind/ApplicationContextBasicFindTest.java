package com.mtakworld.basic.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtakworld.basic.AppConfig;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("find by name")
	void findBeanByName() {
		MemberService service = ac.getBean("memberService", MemberService.class);
		assertThat(service).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("find by type")
	void findBeanByType() {
		MemberService service = ac.getBean(MemberService.class);
		assertThat(service).isInstanceOf(MemberServiceImpl.class);
	}
	@Test
	@DisplayName("find by concrete type")
	void findBeanByType2() {
		MemberService service = ac.getBean(MemberServiceImpl.class);
		assertThat(service).isInstanceOf(MemberServiceImpl.class);
	}
	@Test
	@DisplayName("fail to find by name")
	void findBeanByNameX() {
		assertThrows(NoSuchBeanDefinitionException.class, ()->ac.getBean("x", MemberService.class));
	}


}
