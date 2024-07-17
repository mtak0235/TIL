package com.mtakworld.mvc.servlet.basic.web.servlet;

import static com.mtakworld.mvc.servlet.basic.domain.member.MemberRepository.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.mtakworld.mvc.servlet.basic.domain.member.Member;
import com.mtakworld.mvc.servlet.basic.domain.member.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Member> all = memberRepository.findAll();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter w = resp.getWriter();
		w.write("<html>");
		w.write("<head>");
		w.write(" <meta charset=\"UTF-8\">");
		w.write(" <title>Title</title>");
		w.write("</head>");
		w.write("<body>");
		w.write("<a href=\"/index.html\">메인</a>");
		w.write("<table>");
		w.write(" <thead>");
		w.write(" <th>id</th>");
		w.write(" <th>username</th>");
		w.write(" <th>age</th>");
		w.write(" </thead>");
		w.write(" <tbody>");
/*
 w.write(" <tr>");
 w.write(" <td>1</td>");
 w.write(" <td>userA</td>");
 w.write(" <td>10</td>");
 w.write(" </tr>");
*/
		for (Member member : all) {
			w.write(" <tr>");
			w.write(" <td>" + member.getId() + "</td>");
			w.write(" <td>" + member.getUsername() + "</td>");
			w.write(" <td>" + member.getAge() + "</td>");
			w.write(" </tr>");
		}
		w.write(" </tbody>");
		w.write("</table>");
		w.write("</body>");
		w.write("</html>");
	}
}
