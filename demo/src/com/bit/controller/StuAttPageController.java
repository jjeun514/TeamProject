package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.NewStuDao;
import com.test.model.StuInfoDao;

@WebServlet("/stuMgmt/stuAttStatusPage.bit")
public class StuAttPageController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("lecNo", dao.lecInfoList());
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuAttList.jsp");
		rd.forward(req, resp);
		
	}
	
}
