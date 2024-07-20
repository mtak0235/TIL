package com.mtakworld.mvc.servlet.web.frontcontroller.v1;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerV1 {
	void process(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException;
}
