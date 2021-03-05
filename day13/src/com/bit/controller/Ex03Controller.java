package com.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.DeptDao;
import com.bit.model.DeptDto;

public class Ex03Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// /ex03.html 서비스 페이지
		// controller model&view
		
		//model
		DeptDao dao=new DeptDao();
		List<DeptDto> list = dao.getList();
		req.setAttribute("alist", list);
		
		// view
		RequestDispatcher rd = null;
		rd=req.getRequestDispatcher("Ex03.jsp");
	
		rd.forward(req, resp);
	}
}
