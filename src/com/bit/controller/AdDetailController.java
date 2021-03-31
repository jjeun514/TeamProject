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

@WebServlet("/adBbsDetail.bit")
public class AdDetailController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int lecNo=Integer.parseInt(req.getParameter("lecNo"));
		
		AdDao dao=new AdDao();
		
		req.setAttribute("detail", dao.selectOne(lecNo));
		
		RequestDispatcher rd;
		rd=req.getRequestDispatcher("./BbsDetail.jsp");
		rd.forward(req,resp);
	}
}
