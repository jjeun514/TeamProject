package com.bit.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Ex04  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest) req;
		String method=request.getMethod();
		if("GET".equals(method)) {
		doGet(req,res);
		}else if("POST".equals(method)) {
		doPost(req,res);
		}
	}
	public void doPost(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	}
	public void doGet(ServletRequest req, ServletResponse res) throws ServletException, IOException {


		res.setCharacterEncoding("utf-8");
		PrintWriter out=res.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>GenericServlet</h1>");
		out.println("<form action=\"ex08.bit\" method=\"post\">");
		out.println("id<input type='text' name='id'/>");
		out.println("<button>전송</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("<!html>");
	}
}
