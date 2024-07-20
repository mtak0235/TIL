package com.mtakworld.mvc.servlet.web.frontcontroller.v4.controller;

import java.util.Map;

import com.mtakworld.mvc.servlet.domain.member.Member;
import com.mtakworld.mvc.servlet.domain.member.MemberRepository;
import com.mtakworld.mvc.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberSaveControllerV4 implements ControllerV4 {
	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public String process(Map<String, String> map, Map<String, Object> model) {
		String username = map.get("username");
		int age = Integer.parseInt(map.get("age"));
		Member member = new Member(username, age);
		memberRepository.save(member);
		model.put("member", member);
		return "save-result";
	}
}
