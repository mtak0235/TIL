package com.mtakworld.basic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtakworld.basic.common.MyLogger;

import jakarta.inject.Provider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	private final LogDemoService logoDemoService;
	// private final Provider<MyLogger> myLoggerProvider;
	private final MyLogger myLogger;
	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) throws InterruptedException {
		String url = request.getRequestURL().toString();
		// MyLogger myLogger = myLoggerProvider.get();
		myLogger.setRequestURL(url);
		myLogger.log("controller test");
		logoDemoService.logic(url);
		return "OK";
	}
}
