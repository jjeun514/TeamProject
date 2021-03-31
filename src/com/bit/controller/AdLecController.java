package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.AdDao;

@WebServlet("/Bbs.bit")
public class AdLecController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		AdDao dao=new AdDao();
		req.setAttribute("list",dao.selectAll());
		
		RequestDispatcher rd;
		rd=req.getRequestDispatcher("./Bbs.jsp");
		rd.forward(req,resp);
	}

}
