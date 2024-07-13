package com.mtakworld.basic.discount;

import com.mtakworld.basic.member.Grade;
import com.mtakworld.basic.member.Member;

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
