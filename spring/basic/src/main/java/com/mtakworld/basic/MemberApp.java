package com.mtakworld.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtakworld.basic.member.Grade;
import com.mtakworld.basic.member.Member;
import com.mtakworld.basic.member.MemberService;
import com.mtakworld.basic.member.MemberServiceImpl;

public class MemberApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
			AppConfig.class);
		MemberService memberService = context.getBean("memberService"/*method name*/, MemberService.class);

		Member member = new Member(1L, "mtak", Grade.VIP);
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		System.out.println("findMember = " + findMember);
		System.out.println("member = " + member);
	}
}
