package com.mtakworld.basic.web;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import com.mtakworld.basic.common.MyLogger;

import jakarta.inject.Provider;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LogDemoService {
	// private final ObjectProvider<MyLogger> myLoggerProvider;
	private final MyLogger myLogger;


	public void logic(String id) throws InterruptedException {
		// MyLogger myLogger = myLoggerProvider.getObject();
		Thread.sleep(100);
		myLogger.log("service id = " + id);
	}
}
