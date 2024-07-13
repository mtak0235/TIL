package com.mtakworld.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtakworld.basic.member.Grade;
import com.mtakworld.basic.member.Member;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;
import com.mtakworld.basic.order.Order;
import com.mtakworld.basic.order.OrderService;
import com.mtakworld.basic.order.OrderServiceImpl;

public class OrderApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = context.getBean("memberService", MemberService.class);
		OrderService orderService = context.getBean("orderService", OrderService.class);
		Long memberId = 1L;
		Member member = new Member(memberId, "mtak", Grade.VIP);
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "bucket", 10000);
		System.out.println("order = " + order);
	}
}
