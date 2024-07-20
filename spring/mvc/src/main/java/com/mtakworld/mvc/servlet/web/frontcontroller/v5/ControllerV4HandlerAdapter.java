package com.mtakworld.mvc.servlet.web.frontcontroller.v5;

import java.util.HashMap;
import java.util.Map;

import com.mtakworld.mvc.servlet.web.frontcontroller.ModelView;
import com.mtakworld.mvc.servlet.web.frontcontroller.v4.ControllerV4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		return handler instanceof ControllerV4;
	}

	@Override
	public ModelView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		ControllerV4 controller = (ControllerV4)handler;
		Map<String, String> paramMap = createParamMap(req);
		HashMap<String, Object> model = new HashMap<>();
		String viewName = controller.process(paramMap, model);
		ModelView modelView = new ModelView(viewName);
		modelView.setModel(model);
		return modelView;
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames()
			.asIterator()
			.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
}
