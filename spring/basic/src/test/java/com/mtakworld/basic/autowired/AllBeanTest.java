package com.mtakworld.basic.autowired;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.mtakworld.basic.AutoAppConfig;
import com.mtakworld.basic.discount.DiscountPolicy;
import com.mtakworld.basic.member.Grade;
import com.mtakworld.basic.member.Member;

public class AllBeanTest {
	@Test
	void findAllBean() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,
			DiscountService.class);
		DiscountService service = ac.getBean(DiscountService.class);
		Member member = new Member(1L, "mtak", Grade.VIP);
		int discountPrice = service.discount(member, 10000, "fixedDiscountPolicy");
		assertThat(service).isInstanceOf(DiscountService.class);
		assertThat(discountPrice).isEqualTo(1000);
		discountPrice = service.discount(member, 10000, "rateDiscountPolicy");
		assertThat(discountPrice).isEqualTo(1000);
	}

	@Configuration
	static class DiscountService {
		private final Map<String, DiscountPolicy> policyMap;
		private final List<DiscountPolicy> policyList;

		@Autowired
		public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
			this.policyMap = policyMap;
			this.policyList = policyList;
			System.out.println("policyMap = " + policyMap);
			System.out.println("policyList = " + policyList);
		}

		public int discount(Member member, int i, String discountPolicy) {
			DiscountPolicy policy = policyMap.get(discountPolicy);
			return policy.discount(member, i);
		}
	}
}
