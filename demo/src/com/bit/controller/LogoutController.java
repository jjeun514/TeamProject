
package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.bit")
public class LogoutController extends HttpServlet {
	HttpSession session;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		System.out.println("logout get...");
		session=req.getSession();
		System.out.println(session.getAttribute("sysId"));
		session.removeAttribute("sysId");
		session.removeAttribute("sysPw");
		session.removeAttribute("empNo");
		session.removeAttribute("deptno");
		session.invalidate();
		System.out.println("여기를 타나");
		PrintWriter out=resp.getWriter();
		out.println("<script>alert('로그아웃 되었습니다'); location.href='/demo/login.jsp';</script>");
		
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("logout post...");


	}

}
