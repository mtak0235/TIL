package com.mtakworld.basic.discount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mtakworld.basic.member.Grade;
import com.mtakworld.basic.member.Member;

class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();



	@Test
	@DisplayName("discount if vip")
	void discount() {
		Member member = new Member(1L, "mtak", Grade.VIP);
		int discount = discountPolicy.discount(member, 10000);
		assertThat(discount).isEqualTo(1000);
	}

	@Test
	@DisplayName("no discount if not vip")
	void discount_novip() {
		Member member = new Member(1L, "mtak", Grade.BASIC);
		int discount = discountPolicy.discount(member, 10000);
		assertThat(discount).isEqualTo(0);
	}
}