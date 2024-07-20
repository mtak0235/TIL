package com.mtakworld.mvc.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import com.mtakworld.mvc.servlet.web.frontcontroller.MyView;
import com.mtakworld.mvc.servlet.web.frontcontroller.v2.ControllerV2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2 {
	@Override
	public MyView process(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {
		return new MyView("WEB-INF/views/new-form.jsp");
	}
}
