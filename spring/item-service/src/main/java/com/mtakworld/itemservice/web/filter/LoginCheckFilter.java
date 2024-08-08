package com.mtakworld.itemservice.web.filter;

import java.io.IOException;

import org.springframework.util.PatternMatchUtils;

import com.mtakworld.itemservice.web.SessionConst;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckFilter implements Filter {
	private static final String[] whitelist = {"/", "/members/add", "/login", "/logout", "/css/*"};

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
		IOException,
		ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		String uri = request.getRequestURI();
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		try {
			log.info("login check filter starts {}", uri);
			if (isLoginCheckPath(uri)) {
				log.info("login check filter logic {}", uri);
				HttpSession session = request.getSession(false);
				if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
					log.info("unauthorized request {}", uri);
					response.sendRedirect("/login?redirectURL=" + uri);
					return;
				}
			}
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			throw e;
		}
		finally {
			log.info("login check filter is terminated {}", uri);
		}
	}

	private boolean isLoginCheckPath(String requestUri) {
		return !PatternMatchUtils.simpleMatch(whitelist, requestUri);
	}

}
