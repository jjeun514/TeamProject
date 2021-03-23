package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuDetailDao;
import com.test.model.StuInfoDao;
import com.test.model.StuInfoDto;

@WebServlet("/stuMgmt/stuDetail.bit")
public class StuDetailController extends HttpServlet {

	public StuDetailController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int stuNo = Integer.parseInt(req.getParameter("stuNo"));
		System.out.println("디테일 페이지에 사용할 수강생 번호 : " + stuNo);
		
		StuDetailDao dao = new StuDetailDao();
		
		StuInfoDto detail = dao.stuDetailInfo(stuNo);
		req.setAttribute("detail", detail);
		
		StuInfoDao lec = new StuInfoDao();
		req.setAttribute("lec", lec.lecList());
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuDetail.jsp");
		rd.forward(req, resp);
	}
	
}
