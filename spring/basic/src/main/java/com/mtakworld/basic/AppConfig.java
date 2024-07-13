package com.mtakworld.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mtakworld.basic.discount.DiscountPolicy;
import com.mtakworld.basic.discount.FixedDiscountPolicy;
import com.mtakworld.basic.member.MemberRepository;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;
import com.mtakworld.basic.member.MemoryMemberRepository;
import com.mtakworld.basic.order.OrderService;
import com.mtakworld.basic.order.OrderServiceImpl;

@Configuration
public class AppConfig {
	private MemberService memberService;
	private OrderService orderService;
	private MemberRepository memberRepository;

	@Bean
	public MemberRepository memberRepository() {
		if (memberRepository == null) {
			this.memberRepository = new MemoryMemberRepository();
		}
		return memberRepository;
	}

	@Bean
	public MemberService memberService() {
		if (memberService == null) {
			memberService = new MemberServiceImpl(memberRepository());
		}
		return memberService;
	}

	@Bean
	public OrderService orderService() {
		if (orderService == null) {
			this.orderService = new OrderServiceImpl(memberService(), new FixedDiscountPolicy());
		}
		return orderService;
	}
}
