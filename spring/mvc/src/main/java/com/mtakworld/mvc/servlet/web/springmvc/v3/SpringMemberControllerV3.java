package com.mtakworld.mvc.servlet.web.springmvc.v3;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mtakworld.mvc.servlet.domain.member.Member;
import com.mtakworld.mvc.servlet.domain.member.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
	private final MemberRepository memberRepository = MemberRepository.getInstance();

	// @RequestMapping(value = "/new-form", method = RequestMethod.GET)
	@GetMapping("/new-form")
	public String newForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "new-form";
	}

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String members(Model model) {
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);
		return "members";
	}

	@PostMapping("/save")
	public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model) {
		Member member = new Member(username, age);
		memberRepository.save(member);
		model.addAttribute("member", member);
		return "save-result";
	}

}
