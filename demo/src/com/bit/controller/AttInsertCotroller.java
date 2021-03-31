package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuAttDao;
import com.test.model.StuInfoDao;

@WebServlet("/stuMgmt/stuAttInsert.bit")
public class AttInsertCotroller extends HttpServlet {

	public AttInsertCotroller() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getParameterNames()
		//int checkNo = Integer.parseInt(req.getParameter("checkNo"));
		
		int stuNo = Integer.parseInt(req.getParameter("stuNo"));
		int lecNo = Integer.parseInt(req.getParameter("lecNo"));
		int stuAtt;
		int stuLate;
		int stuAbsent;
		
		System.out.println("----------stuAttInsertController-----------");
				
		stuNo = Integer.parseInt(req.getParameter("stuNo"));
		lecNo = Integer.parseInt(req.getParameter("lecNo"));
		System.out.println("출석 입력한 학생 번호 : " + stuNo);
		if(req.getParameter("stuAtt")==null || req.getParameter("stuAtt") == "")       { stuAtt=0; } else { stuAtt = Integer.parseInt(req.getParameter("stuAtt")); }
		System.out.println("출석 입력한 학생 출석 : " + stuAtt);
		if(req.getParameter("stuLate")==null || req.getParameter("stuLate") == "")     { stuLate=0; } else { stuLate = Integer.parseInt(req.getParameter("stuLate")); }
		System.out.println("출석 입력한 학생 지각 : " + stuLate);
		if(req.getParameter("stuAbsent")==null || req.getParameter("stuAbsent") == "") { stuAbsent=0; } else { stuAbsent = Integer.parseInt(req.getParameter("stuAbsent")); }
		System.out.println("출석 입력한 학생 결석 : " + stuAbsent);
		// int lecNo = Integer.parseInt(req.getParameter("selectLec"));
		
		
		StuAttDao attInsert = new StuAttDao();
		attInsert.stuAttInsert(stuNo, stuAtt, stuLate, stuAbsent);
		
		// 수강생목록 화면에서 강의 선택을 위한 강의 정보 추출
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("lecInfoList", dao.lecInfoList());
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuAttList.bit?selectLec="+lecNo);
		rd.forward(req, resp);
	}
	
}
