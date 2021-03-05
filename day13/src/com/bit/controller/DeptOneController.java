package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.DeptDao;
import com.bit.model.DeptDto;

public class DeptOneController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int deptno=Integer.parseInt(req.getParameter("deptno"));

		DeptDao dao=new DeptDao();
		DeptDto bean=dao.getOne(deptno);
		req.setAttribute("bean", bean);
		
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("detail.jsp");
		rd.forward(req, resp);
	}
}
