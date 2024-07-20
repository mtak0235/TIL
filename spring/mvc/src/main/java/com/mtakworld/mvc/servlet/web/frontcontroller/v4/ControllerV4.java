package com.mtakworld.mvc.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
	/**
	 * @param map
	 * @param model
	 * @return
	 */
	String process(Map<String, String> map, Map<String, Object> model);
}
