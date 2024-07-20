package com.mtakworld.mvc.servlet.web.frontcontroller.v3.controller;

import java.util.List;
import java.util.Map;

import com.mtakworld.mvc.servlet.domain.member.Member;
import com.mtakworld.mvc.servlet.domain.member.MemberRepository;
import com.mtakworld.mvc.servlet.web.frontcontroller.ModelView;
import com.mtakworld.mvc.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberListControllerV3 implements ControllerV3 {
	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> map) {
		List<Member> members = memberRepository.findAll();
		ModelView modelView = new ModelView("members");
		modelView.getModel().put("members", members);
		return modelView;
	}

}
