package com.mtakworld.mvc.servlet.web.frontcontroller.v1.controller;

import java.io.IOException;
import java.util.List;

import com.mtakworld.mvc.servlet.domain.member.Member;
import com.mtakworld.mvc.servlet.domain.member.MemberRepository;
import com.mtakworld.mvc.servlet.web.frontcontroller.v1.ControllerV1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV1 implements ControllerV1 {
	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();
		request.setAttribute("members", members);
		String viewPath = "/WEB-INF/views/members.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}