package com.bit.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuScoreDao;

@WebServlet("/stuMgmt/stuScoreDelete.bit")
public class StuScoreDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int stuNo= Integer.parseInt(req.getParameter("stuNo"));
		StuScoreDao dao=new StuScoreDao();
		
		dao.updateScore(stuNo, 0, 0, 0);
		
		resp.sendRedirect("./stuScoreDetail.bit?stuNo="+stuNo);
	}
}
