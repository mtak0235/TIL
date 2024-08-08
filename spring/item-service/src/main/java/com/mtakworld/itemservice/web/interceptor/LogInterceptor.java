package com.mtakworld.itemservice.web.interceptor;

import java.util.UUID;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

	public static final String LOG_ID = "logId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {
		String uri = request.getRequestURI();
		String uuid = UUID.randomUUID()
						  .toString();
		request.setAttribute(LOG_ID, uuid);
		if (handler instanceof HandlerMethod hm) {
		}
		log.info("REQUEST {} {} {]", uuid, uri, handler);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		log.info("postHandler {}", modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) throws Exception {
		String uri = request.getRequestURI();
		String logId = (String)request.getAttribute(LOG_ID);
		log.info("RESPONSE {} {} {}", logId, uri, handler);
		if (ex != null) {
			log.error("afterCompletion error", ex);
		}
	}
}
