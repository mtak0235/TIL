package com.mtakworld.itemservice.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mtakworld.itemservice.domain.login.LoginService;
import com.mtakworld.itemservice.domain.member.Member;
import com.mtakworld.itemservice.web.SessionConst;
import com.mtakworld.itemservice.web.session.SessionManager;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
	private final LoginService loginService;
	private final SessionManager sessionManager;

	private static void setCookieExpired(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	@GetMapping("/login")
	public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
		return "/login/loginForm";
	}

	// @PostMapping("/login")
	public String login(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult,
		HttpServletResponse response) {
		if (bindingResult.hasErrors()) {
			return "login/loginForm";
		}
		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
		if (loginMember == null) {
			bindingResult.reject("loginFail", "wrong id or password");
			return "login/loginForm";
		}
		Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getId()));
		response.addCookie(idCookie);
		return "redirect:/";
	}

	// @PostMapping("/login")
	public String loginv2(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult,
		HttpServletResponse response) {
		if (bindingResult.hasErrors()) {
			return "login/loginForm";
		}
		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
		if (loginMember == null) {
			bindingResult.reject("loginFail", "wrong id or password");
			return "login/loginForm";
		}
		sessionManager.createSession(loginMember, response);
		return "redirect:/";
	}

	// @PostMapping("/login")
	public String loginv3(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "login/loginForm";
		}
		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
		if (loginMember == null) {
			bindingResult.reject("loginFail", "wrong id or password");
			return "login/loginForm";
		}
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

		return "redirect:/";
	}

	@PostMapping("/login")
	public String loginv4(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request, @RequestParam(defaultValue = "/") String redirectURL) {
		if (bindingResult.hasErrors()) {
			return "login/loginForm";
		}
		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
		if (loginMember == null) {
			bindingResult.reject("loginFail", "wrong id or password");
			return "login/loginForm";
		}
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

		return "redirect:" + redirectURL;
	}

	// @PostMapping("/logout")
	public String logout(HttpServletResponse response) {
		setCookieExpired(response, "memberId");
		return "redirect:/";
	}

	// @PostMapping("/logout")
	public String logoutV2(HttpServletRequest request) {
		sessionManager.expire(request);
		return "redirect:/";
	}

	@PostMapping("/logout")
	public String logoutV3(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}
