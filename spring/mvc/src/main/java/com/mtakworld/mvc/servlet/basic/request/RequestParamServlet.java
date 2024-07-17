package com.mtakworld.mvc.servlet.basic.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("전체 파라미터 조회");
		req.getParameterNames()
			.asIterator()
			.forEachRemaining(name -> System.out.println(name + " = " + req.getParameter(name)));
		System.out.println("단일 파람 조회");
		String name = req.getParameter("name");
		System.out.println("name = " + name);

		String[] names = req.getParameterValues("name");
		Arrays.stream(names).forEach(System.out::println);
	}
}
