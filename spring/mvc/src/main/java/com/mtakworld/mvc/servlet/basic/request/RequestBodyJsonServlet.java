package com.mtakworld.mvc.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtakworld.mvc.servlet.basic.HelloData;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
	private ObjectMapper mapper = new ObjectMapper();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletInputStream inputStream = req.getInputStream();
		String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		System.out.println("body = " + body);
		HelloData helloData = mapper.readValue(body, HelloData.class);
		System.out.println("helloData = " + helloData);
		System.out.println("helloData.getUsername() = " + helloData.getUsername());
		System.out.println("helloData.getAge() = " + helloData.getAge());
	}
}
