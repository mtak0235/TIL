package com.mtakworld.basic.member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mtakworld.basic.AppConfig;

class MemberServiceTest {

	AppConfig appConfig;
	MemberService memberService;

	@BeforeEach
	public void setUp() {
		appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}
	@Test
	void join() {
		//given
		Member member = new Member(1L, "mtak", Grade.VIP);
		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		//then
		assertThat(member).isEqualTo(findMember);
	}

	@Test
	void findMember() {
		Member member = new Member(1L, "mtak", Grade.VIP);
	}
}