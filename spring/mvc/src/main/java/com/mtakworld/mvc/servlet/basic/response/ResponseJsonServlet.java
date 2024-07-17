package com.mtakworld.mvc.servlet.basic.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtakworld.mvc.servlet.basic.HelloData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/reponse-json")
public class ResponseJsonServlet extends HttpServlet {
	ObjectMapper mapper = new ObjectMapper();
	@Override

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		HelloData helloData = new HelloData();
		helloData.setAge(20);
		helloData.setUsername("mtak");
		String result = mapper.writeValueAsString(helloData);
		resp.getWriter().write(result);

	}
}
