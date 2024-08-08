package com.mtakworld.itemservice.web.filter;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("log filter init");
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
		IOException,
		ServletException {
		log.info("log filter doFilter");
		HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
		String requestURI = httpRequest.getRequestURI();
		String uuid = UUID.randomUUID()
						  .toString();
		try {
			MDC.put("request_id", uuid);
			log.info("REQUEST {} {} {}", uuid, requestURI, servletRequest.getDispatcherType());
			filterChain.doFilter(servletRequest, servletResponse);
		} catch (Exception e) {
			throw e;
		} finally {
			log.info("RESPONSE {} {}", uuid, requestURI);
			MDC.clear();
		}
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
		log.info("log filter destroy");
	}
}
