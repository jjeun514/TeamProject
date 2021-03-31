package com.bit.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.AdDao;

@WebServlet("/adInsert.bit")
public class AdInsertController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String lecName=req.getParameter("lecName");
		String lecStartDate=req.getParameter("lecStartDate");
		String lecFinishDate=req.getParameter("lecFinishDate");
		
		AdDao dao=new AdDao();
		dao.insertOne(lecName, lecStartDate, lecFinishDate);

		resp.sendRedirect("./Bbs.bit");
	}

}
