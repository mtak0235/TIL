package com.mtakworld.basic.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtakworld.basic.AutoAppConfig;
import com.mtakworld.basic.member.MemberService;

public class AutoAppConfigTest {
	@Test
	void basicScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		MemberService service = ac.getBean(MemberService.class);
		Assertions.assertThat(service).isInstanceOf(MemberService.class);
	}

}
