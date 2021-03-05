package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.DeptDao;

public class DeptAddController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//화면처리의 위임
		RequestDispatcher rd=null;
		
		rd=req.getRequestDispatcher("add.jsp");
		rd.forward(req, resp);
		
		req.setCharacterEncoding("utf-8");
		System.out.println("왓다");
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		System.out.println(req.getParameter("deptno"));
		String dname=req.getParameter("dname");
		System.out.println(req.getParameter("dname"));
		String loc=req.getParameter("loc");
		System.out.println(req.getParameter("loc"));
		
		DeptDao dao=new DeptDao();
		System.out.println("객체생성");
		dao.setList(deptno, dname, loc);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			
			int deptno=Integer.parseInt(req.getParameter("deptno"));
			String dname=req.getParameter("dname");
			String loc=req.getParameter("loc");
			
			DeptDao dao=new DeptDao();
			dao.setList(deptno, dname, loc);
	
			resp.sendRedirect("list.html");
	}
}
