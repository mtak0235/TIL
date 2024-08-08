package com.mtakworld.itemservice.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.mtakworld.itemservice.web.SessionConst;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {
		String uri = request.getRequestURI();
		log.info("인증 체크 인터셉터 실행 {}", uri);
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
			log.info("미인증 사용자 요청");
			return false;
		}
		return true;
	}
}
