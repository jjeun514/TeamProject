package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuInfoDao;

@WebServlet("/stuMgmt/stuAtt.bit")
public class AttPageCotroller extends HttpServlet {

	public AttPageCotroller() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("----------stuAttController-----------");
		
		// 수강생목록 화면에서 강의 선택을 위한 강의 정보 추출
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("lecInfoList", dao.lecInfoList());
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuAtt.jsp");
		rd.forward(req, resp);
	}
	
}
