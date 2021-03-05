package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dept.model.DeptDao;

public class Ex01Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view=getInitParameter("viewName");
		System.out.println(view);
		RequestDispatcher rd;
		rd=req.getRequestDispatcher(view+".jsp");
		rd.forward(req, resp);
	}
}
