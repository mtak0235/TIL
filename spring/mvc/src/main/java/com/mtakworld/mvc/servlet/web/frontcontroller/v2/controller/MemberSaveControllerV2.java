package com.mtakworld.mvc.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import com.mtakworld.mvc.servlet.domain.member.Member;
import com.mtakworld.mvc.servlet.domain.member.MemberRepository;
import com.mtakworld.mvc.servlet.web.frontcontroller.MyView;
import com.mtakworld.mvc.servlet.web.frontcontroller.v2.ControllerV2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSaveControllerV2 implements ControllerV2 {
	private MemberRepository memberRepository = MemberRepository.getInstance();
	@Override
	public MyView process(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {
		String username = req.getParameter("username");
		int age = Integer.parseInt(req.getParameter("age"));
		Member member = new Member(username, age);
		memberRepository.save(member);
		req.setAttribute("member", member);
		return new MyView("/WEB-INF/views/save-result.jsp");
	}
}
