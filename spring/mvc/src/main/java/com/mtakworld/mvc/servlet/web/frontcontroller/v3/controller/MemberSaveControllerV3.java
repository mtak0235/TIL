package com.mtakworld.mvc.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import com.mtakworld.mvc.servlet.domain.member.Member;
import com.mtakworld.mvc.servlet.domain.member.MemberRepository;
import com.mtakworld.mvc.servlet.web.frontcontroller.ModelView;
import com.mtakworld.mvc.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberSaveControllerV3 implements ControllerV3 {
	private MemberRepository memberRepository = MemberRepository.getInstance();
	@Override
	public ModelView process(Map<String, String> map) {
		String username = map.get("username");
		int age = Integer.parseInt(map.get("age"));
		Member member = new Member(username, age);
		memberRepository.save(member);
		ModelView modelView = new ModelView("save-result");
		modelView.getModel().put("member", member);
		return modelView;
	}
}
