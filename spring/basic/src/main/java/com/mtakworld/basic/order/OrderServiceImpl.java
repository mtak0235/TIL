package com.mtakworld.basic.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mtakworld.basic.annotation.MainDiscountPolicy;
import com.mtakworld.basic.discount.DiscountPolicy;
import com.mtakworld.basic.member.Member;
import com.mtakworld.basic.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Component
public class OrderServiceImpl implements OrderService {

	// private MemberRepository memberRepository;
	// private DiscountPolicy discountPolicy;
	//
	// @Autowired
	// public void setDiscountPolicy(DiscountPolicy discountPolicy) {
	// 	this.discountPolicy = discountPolicy;
	// }
	//
	// @Autowired
	// public void setMemberRepository(MemberRepository memberRepository) {
	// 	this.memberRepository = memberRepository;
	// }
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, /*@Qualifier("mainDiscountP")*/@MainDiscountPolicy DiscountPolicy discountPolicy) {
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
