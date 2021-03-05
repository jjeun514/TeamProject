package com.bit.day09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Ex03 extends Ex02{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service()...");
		PrintWriter out=res.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>hello world</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
