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

@WebServlet("/stuMgmt/newStuPage.bit")
public class NewStuPageController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("lecNo", dao.lecInfoList());
		req.setAttribute("maxStuNo", dao.maxStuNo());
		
		RequestDispatcher rd = req.getRequestDispatcher("./newStu.jsp");
		rd.forward(req, resp);
		
	}
	
}