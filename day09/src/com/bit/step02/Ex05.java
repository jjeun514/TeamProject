package com.bit.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05 extends GenericServlet{

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
	public void doGet(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpServletResponse resp=(HttpServletResponse) res;
		resp.setStatus(404);;
	}
	
	
	public void doPost(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		
		res.setCharacterEncoding("utf-8");
		PrintWriter out=res.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>결과</h1>");
		out.println("<p>id : "+id+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
