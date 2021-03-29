package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.AdDao;

@WebServlet("/adDelete.bit")
public class AdDeleteController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int adLecNo=Integer.parseInt(req.getParameter("adLecNo"));
		
		AdDao dao=new AdDao();
		
		dao.deleteOne(adLecNo);
		
		resp.sendRedirect("./Bbs.bit");
	
	}
}
