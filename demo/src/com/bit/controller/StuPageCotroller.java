package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuInfoDao;

@WebServlet("/stuMgmt/stuPage.bit")
public class StuPageCotroller extends HttpServlet {

	public StuPageCotroller() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("lecNo", dao.lecList());
		
		
	
		RequestDispatcher rd = req.getRequestDispatcher("./stuList.jsp");
		rd.forward(req, resp);
	}
	
}
