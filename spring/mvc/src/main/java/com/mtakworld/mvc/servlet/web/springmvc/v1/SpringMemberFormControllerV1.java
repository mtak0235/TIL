package com.mtakworld.mvc.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SpringMemberFormControllerV1 {
	@RequestMapping("/springmvc/v1/members/new-form")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("SpringMemberFormControllerV1.handleRequest");
		return new ModelAndView("new-form");
	}

}
