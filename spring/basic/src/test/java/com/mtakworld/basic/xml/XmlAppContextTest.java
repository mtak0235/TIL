package com.mtakworld.basic.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;

public class XmlAppContextTest {
	@Test
	void xmlAppContext() {
		GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
		MemberService service = ac.getBean("memberService", MemberService.class);
		Assertions.assertThat(service).isInstanceOf(MemberServiceImpl.class);
	}
}
