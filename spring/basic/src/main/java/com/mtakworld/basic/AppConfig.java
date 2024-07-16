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

// @Configuration
public class AppConfig {
	private MemberService memberService;
	private OrderService orderService;
	private MemberRepository memberRepository;
	private static DiscountPolicy discountPolicy;

	@Bean
	public MemberRepository memberRepository() {
		System.out.println("AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}

	@Bean
	public MemberService memberService() {
		System.out.println("AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		System.out.println("AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		System.out.println("AppConfig.discountPolicy");
		return new FixedDiscountPolicy();
	}
}
