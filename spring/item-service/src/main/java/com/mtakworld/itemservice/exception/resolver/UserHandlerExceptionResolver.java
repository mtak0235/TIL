package com.mtakworld.itemservice.exception.resolver;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtakworld.itemservice.exception.exception.UserException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserHandlerExceptionResolver implements HandlerExceptionResolver {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) {
		try {
			if (ex instanceof UserException) {
				log.info("UserExceptionresolver to 400");
				String accept = request.getHeader("accept");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				if ("application/json".equals(accept)) {
					HashMap<String, Object> errorResult = new HashMap<>();
					errorResult.put("ex", ex.getClass());
					errorResult.put("message", ex.getMessage());
					String result = objectMapper.writeValueAsString(errorResult);
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter()
							.write(result);
					return new ModelAndView();
				} else {
					return new ModelAndView("error/500");
				}
			}
		} catch (IOException e) {
			log.error("resolve ex", ex);
		}
		return null;
	}
}
