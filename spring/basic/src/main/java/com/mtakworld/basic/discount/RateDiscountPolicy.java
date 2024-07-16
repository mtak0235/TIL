package com.mtakworld.basic.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.mtakworld.basic.annotation.MainDiscountPolicy;
import com.mtakworld.basic.member.Grade;
import com.mtakworld.basic.member.Member;

@Component
// @Qualifier("mainDiscountP")
// @Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
	private int discountRate = 10;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountRate / 100;
		}
		return 0;
	}
}
