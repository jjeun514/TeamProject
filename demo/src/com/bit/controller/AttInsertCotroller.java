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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int stuNo;
		int stuAtt;
		int stuLate;
		int stuAbsent;
		
		System.out.println("stuAttInsert 컨트롤러 도착");
		
		stuNo = Integer.parseInt(req.getParameter("stuNo"));
		if(req.getParameter("stuAtt")==null) { stuAtt=0; } else { stuAtt = Integer.parseInt(req.getParameter("stuAtt")); }
		if(req.getParameter("stuLate")==null) { stuLate=0; } else { stuLate = Integer.parseInt(req.getParameter("stuLate")); }
		if(req.getParameter("stuAbsent")==null) { stuAbsent=0; } else { stuAbsent = Integer.parseInt(req.getParameter("stuAbsent")); }
		// int lecNo = Integer.parseInt(req.getParameter("selectLec"));
		
		
		StuAttDao attInsert = new StuAttDao();
		attInsert.stuAttInsert(stuNo, stuAtt, stuLate, stuAbsent);
		
		// 수강생목록 화면에서 강의 선택을 위한 강의 정보 추출
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("lecInfoList", dao.lecInfoList()); // 만약에 여기서 값을 전달해주고 bit url로 포워드한다면?
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuAtt.jsp"); // 어떻게 하면 다시 돌아갈 수 있을까?
		rd.forward(req, resp);
	}
	
}
