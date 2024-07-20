package com.mtakworld.mvc.servlet.web.frontcontroller.v5.adapter;

import java.util.HashMap;
import java.util.Map;

import com.mtakworld.mvc.servlet.web.frontcontroller.ModelView;
import com.mtakworld.mvc.servlet.web.frontcontroller.v3.ControllerV3;
import com.mtakworld.mvc.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV3);
	}

	@Override
	public ModelView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		ControllerV3 controller = (ControllerV3)handler;
		Map<String, String> paramMap = createParamMap(req);
		return controller.process(paramMap);
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames()
			.asIterator()
			.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
}
