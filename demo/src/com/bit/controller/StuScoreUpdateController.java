package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.test.model.StuScoreDao;
import com.test.model.StuScoreDto;

@WebServlet("/stuMgmt/stuScoreUpdate.bit")
public class StuScoreUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int stuNo=Integer.parseInt(req.getParameter("stuNo"));
		int java=Integer.parseInt(req.getParameter("java"));
		int web=Integer.parseInt(req.getParameter("web"));
		int framework=Integer.parseInt(req.getParameter("framework"));
		
		
		StuScoreDao dao=new StuScoreDao();
		
		dao.updateScore(stuNo, java, web, framework);
		
//		req.getSession().setAttribute("stuNo", stuNo);
		resp.sendRedirect("./stuScoreDetail.bit?stuNo="+stuNo);
		
	}
}
