package com.mtakworld.basic.order;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mtakworld.basic.AppConfig;
import com.mtakworld.basic.member.Grade;
import com.mtakworld.basic.member.Member;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;

class OrderServiceTest {

	MemberService memberService;
	OrderService orderService;
	AppConfig appConfig;

	@BeforeEach
	public void setUp() {
		appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}

	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "mtak", Grade.VIP);
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "bucket", 10000);
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}

}