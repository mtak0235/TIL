package com.mtakworld.mvc.servlet.web.springmvc.v1;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mtakworld.mvc.servlet.domain.member.Member;
import com.mtakworld.mvc.servlet.domain.member.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SpringMemberListControllerV1 {
	private MemberRepository memberRepository = MemberRepository.getInstance();
	@RequestMapping("/springmvc/v1/members")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		List<Member> members = memberRepository.findAll();
		ModelAndView mv = new ModelAndView("members");
		mv.addObject("members", members);
		return mv;
	}
}
