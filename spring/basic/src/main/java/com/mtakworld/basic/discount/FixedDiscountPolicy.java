package com.mtakworld.basic.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mtakworld.basic.member.Grade;
import com.mtakworld.basic.member.Member;

@Component
// @Qualifier("subDiscountP")
public class FixedDiscountPolicy implements DiscountPolicy {
	private int discountFixAmount = 1000;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		}
		return 0;
	}
}
