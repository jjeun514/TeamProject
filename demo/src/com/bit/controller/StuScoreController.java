package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuScoreDao;

@WebServlet("/stuMgmt/stuScore.bit")
public class StuScoreController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("강의명"+req.getParameter("scoreList"));
		int lecNo;
		if(req.getParameter("scoreList") == null) {
			lecNo=0;			
		}else {
			lecNo=Integer.parseInt(req.getParameter("scoreList"));
		}
		
		StuScoreDao scoreDao=new StuScoreDao();
		
		
		req.setAttribute("allList", scoreDao.selectAll(lecNo));
		
		
		RequestDispatcher rd;
		rd=req.getRequestDispatcher("/stuMgmt/stuScore.jsp");
		rd.forward(req,resp);
	}
	
	

}
