package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.model.StuScoreDao;

@WebServlet("/stuMgmt/stuScore.bit")
public class StuScoreController extends HttpServlet {
	private HttpSession session;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StuScoreDao scoreDao=new StuScoreDao();
		req.setAttribute("lecName", scoreDao.selectLecName());
		
		int deptno=0;
		session=req.getSession();
		try {
			deptno=(int) session.getAttribute("deptno");
			System.out.println("부서번호"+deptno);
		}catch (NullPointerException e) {
			System.out.println("부서번호가 없습니다.");
		}
		
		if(deptno==3) {
		
			System.out.println("강의명"+req.getParameter("scoreList"));
			int lecNo;
			if(req.getParameter("scoreList") == null) {
				lecNo=0;			
			}else {
				lecNo=Integer.parseInt(req.getParameter("scoreList"));
			}
			
			
			req.setAttribute("allList", scoreDao.selectAll(lecNo));
			
			
			RequestDispatcher rd;
			rd=req.getRequestDispatcher("/stuMgmt/stuScore.jsp");
			rd.forward(req,resp);
		}else {
			System.out.println("권한이 없습니다.");
			RequestDispatcher rd;
			rd=req.getRequestDispatcher("/error/reject.jsp");
			rd.forward(req,resp);
		}
	}
	
	

}
