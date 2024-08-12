package com.mtakworld.itemservice.typeconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mtakworld.itemservice.typeconverter.type.IpPort;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	@GetMapping("/hello-v1")
	public String helloV1(HttpServletRequest request) {
		String data = request.getParameter("data");
		Integer integer = Integer.valueOf(data);
		System.out.println("integer = " + integer);
		return "ok";
	}

	@GetMapping("/hello-v2")
	public String helloV2(@RequestParam Integer data) {
		System.out.println("data = " + data);
		return "ok";
	}
	@GetMapping("/ip-port")
	public String ipPort(@RequestParam IpPort ipPort) {
		System.out.println("ipPort IP = " + ipPort.getIp());
		System.out.println("ipPort PORT = " + ipPort.getPort());
		return "ok";
	}

}
