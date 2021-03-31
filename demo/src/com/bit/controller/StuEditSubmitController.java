package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuDetailDao;
import com.test.model.StuEditDao;
import com.test.model.StuInfoDto;

@WebServlet("/stuMgmt/stuEditSubmit.bit")
public class StuEditSubmitController extends HttpServlet {

	public StuEditSubmitController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("----------stuEditSubmitController-----------");
		
		req.setCharacterEncoding("utf-8");
		String stuName = req.getParameter("stuName");
		String stuPhone = req.getParameter("stuPhone");
		int stuNo = Integer.parseInt(req.getParameter("stuNo"));
		System.out.println("수정 요청한 수강생 번호 : " + stuNo);
		
		StuEditDao dao = new StuEditDao();
		
		dao.stuEdit(stuName, stuPhone, stuNo);
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuDetail.bit?stuNo="+stuNo);
		rd.forward(req, resp);
	}
	
}
