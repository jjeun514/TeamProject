package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.DeptDao;

public class DeptController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			DeptDao dao=new DeptDao();
			req.setAttribute("alist", dao.getList());
			
			RequestDispatcher rd=null;
			rd=req.getRequestDispatcher("./list.jsp");
			rd.forward(req, resp);
	}
}
