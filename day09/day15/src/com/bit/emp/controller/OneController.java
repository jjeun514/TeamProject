package com.bit.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;

public class OneController extends HttpServlet {
	// /detail.bit
	// /detail.bit?idx=1

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("idx");
		int empno=Integer.parseInt(param);
		EmpDao dao=new EmpDao();
		req.setAttribute("bean", dao.selectOne(empno));
		
		RequestDispatcher rd;
		rd=req.getRequestDispatcher("emp/detail.jsp");
		rd.forward(req, resp);
	}
}









