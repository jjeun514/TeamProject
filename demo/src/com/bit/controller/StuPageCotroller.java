package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuInfoDao;

@WebServlet("/stuMgmt/stuPage.bit")
public class StuPageCotroller extends HttpServlet {

	public StuPageCotroller() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("----------stuPageController-----------");
		
		// 수강생목록 화면에서 강의 선택을 위한 강의 정보 추출
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("allLecList", dao.lecInfoList());
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuList.jsp");
		rd.forward(req, resp);
	}
	
}
