package com.bit.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex08 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// xml 학생성적관리프로그램
		System.out.println("call xml...");
		resp.setContentType("application/xml;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<students>");
		
		out.println("<student>");
		out.println("<num>"+1+"</num>");
		out.println("<name>"+"user1"+"</name>");
		out.println("<kor>"+90+"</kor>");
		out.println("<eng>"+95+"</eng>");
		out.println("<math>"+92+"</math>");
		out.println("</student>");

		out.println("<student>");
		out.println("<num>"+2+"</num>");
		out.println("<name>"+"user2"+"</name>");
		out.println("<kor>"+80+"</kor>");
		out.println("<eng>"+88+"</eng>");
		out.println("<math>"+77+"</math>");
		out.println("</student>");

		out.println("<student>");
		out.println("<num>"+3+"</num>");
		out.println("<name>"+"user3"+"</name>");
		out.println("<kor>"+76+"</kor>");
		out.println("<eng>"+80+"</eng>");
		out.println("<math>"+94+"</math>");
		out.println("</student>");

		out.println("<student>");
		out.println("<num>"+4+"</num>");
		out.println("<name>"+"user4"+"</name>");
		out.println("<kor>"+25+"</kor>");
		out.println("<eng>"+100+"</eng>");
		out.println("<math>"+100+"</math>");
		out.println("</student>");
		
		out.println("</students>");
	}
}
