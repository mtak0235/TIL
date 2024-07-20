package com.mtakworld.mvc.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;
import java.util.List;

import com.mtakworld.mvc.servlet.domain.member.Member;
import com.mtakworld.mvc.servlet.domain.member.MemberRepository;
import com.mtakworld.mvc.servlet.web.frontcontroller.MyView;
import com.mtakworld.mvc.servlet.web.frontcontroller.v2.ControllerV2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2 {
	private MemberRepository memberRepository = MemberRepository.getInstance();
	@Override
	public MyView process(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {
		List<Member> members = memberRepository.findAll();
		req.setAttribute("members", members);
		return new MyView("/WEB-INF/views/members.jsp");
	}
}
