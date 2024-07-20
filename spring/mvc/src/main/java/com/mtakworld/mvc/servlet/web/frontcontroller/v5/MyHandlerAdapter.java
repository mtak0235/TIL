package com.mtakworld.mvc.servlet.web.frontcontroller.v5;

import com.mtakworld.mvc.servlet.web.frontcontroller.ModelView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {
	boolean supports(Object handler);

	ModelView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception;

}
