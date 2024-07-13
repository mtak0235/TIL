package com.mtakworld.basic.discount;

import com.mtakworld.basic.member.Member;

public interface DiscountPolicy {
	int discount(Member member, int price);
}
