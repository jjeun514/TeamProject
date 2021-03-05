package com.bit.step02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex06  extends GenericServlet{
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
		HttpServletResponse resp=(HttpServletResponse) res;
		resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);;
	}
}
