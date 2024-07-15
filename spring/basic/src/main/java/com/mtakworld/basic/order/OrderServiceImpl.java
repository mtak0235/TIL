package com.mtakworld.basic.order;

import com.mtakworld.basic.discount.DiscountPolicy;
import com.mtakworld.basic.discount.FixedDiscountPolicy;
import com.mtakworld.basic.discount.RateDiscountPolicy;
import com.mtakworld.basic.member.Member;
import com.mtakworld.basic.member.MemberRepository;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		Order order = new Order(memberId, itemName, itemPrice, discountPrice);
		return order;
	}

	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
