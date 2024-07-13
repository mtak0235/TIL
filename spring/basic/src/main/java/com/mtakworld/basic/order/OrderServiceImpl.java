package com.mtakworld.basic.order;

import com.mtakworld.basic.discount.DiscountPolicy;
import com.mtakworld.basic.discount.FixedDiscountPolicy;
import com.mtakworld.basic.discount.RateDiscountPolicy;
import com.mtakworld.basic.member.Member;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService {
	private final MemberService memberService;
	private final DiscountPolicy discountPolicy;

	public OrderServiceImpl(MemberService memberService, DiscountPolicy discountPolicy) {
		this.memberService = memberService;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberService.findMember(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		Order order = new Order(memberId, itemName, itemPrice, discountPrice);
		return order;
	}
}
