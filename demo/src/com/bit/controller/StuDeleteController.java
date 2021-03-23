package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuDeleteDao;
import com.test.model.StuDetailDao;
import com.test.model.StuInfoDto;

@WebServlet("/stuMgmt/stuDelete.bit")
public class StuDeleteController extends HttpServlet {

	public StuDeleteController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int stuNo = Integer.parseInt(req.getParameter("stuNo"));
		System.out.println("삭제할 수강생 번호 : " + stuNo);
		
		StuDeleteDao dao = new StuDeleteDao();
		
		dao.stuDelete(stuNo);
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuList.jsp"); // 삭제 후 해당 강의의 리스트로 돌아가야 함
		rd.forward(req, resp);
	}
	
}
