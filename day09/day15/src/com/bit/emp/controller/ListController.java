package com.bit.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;

public class ListController extends HttpServlet {
	// /list.bit

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		req.setAttribute("list", dao.selectAll());
		
		RequestDispatcher rd;
		rd=req.getRequestDispatcher("emp/list.jsp");
		rd.forward(req, resp);
	}
}









