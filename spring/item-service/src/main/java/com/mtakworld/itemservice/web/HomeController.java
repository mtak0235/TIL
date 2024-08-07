package com.mtakworld.itemservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mtakworld.itemservice.domain.member.Member;
import com.mtakworld.itemservice.domain.member.MemberRepository;
import com.mtakworld.itemservice.web.argumentResolver.Login;
import com.mtakworld.itemservice.web.session.SessionManager;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	private final MemberRepository memberRepository;
	private final SessionManager sessionManager;

	// @GetMapping("/")
	public String home() {
		return "home";
	}

	// @GetMapping("/")
	public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
		if (memberId == null) {
			return "home";
		}
		Member byId = memberRepository.findById(memberId);
		if (byId == null) {
			return "home";
		}
		model.addAttribute("member", byId);
		return "loginHome";
	}

	// @GetMapping("/")
	public String homeLoginV2(HttpServletRequest request, Model model) {
		Member member = (Member)sessionManager.getSession(request);
		if (member == null) {
			return "home";
		}
		model.addAttribute("member", member);
		return "loginHome";
	}

	// @GetMapping("/")
	public String homeLoginV3(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "home";
		}
		Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginMember == null) {
			return "home";
		}
		model.addAttribute("member", loginMember);
		return "loginHome";
	}
	// @GetMapping("/")
	public String homeLoginV3Spring(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
		if (loginMember == null) {
			return "home";
		}
		model.addAttribute("member", loginMember);
		return "loginHome";
	}
	@GetMapping("/")
	public String homeLoginV3ArgumentResolver(@Login Member loginMember, Model model) {
		if (loginMember == null) {
			return "home";
		}
		model.addAttribute("member", loginMember);
		return "loginHome";
	}
}