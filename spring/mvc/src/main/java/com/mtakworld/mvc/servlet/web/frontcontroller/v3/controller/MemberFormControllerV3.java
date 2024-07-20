package com.mtakworld.mvc.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import com.mtakworld.mvc.servlet.web.frontcontroller.ModelView;
import com.mtakworld.mvc.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberFormControllerV3 implements ControllerV3 {

	@Override
	public ModelView process(Map<String, String> map) {
		return new ModelView("new-form.vm");
	}
}
