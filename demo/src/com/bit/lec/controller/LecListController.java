package com.bit.lec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lec.model.LecDao;

@WebServlet("/lecList.bit")
public class LecListController extends HttpServlet {
	private HttpSession session;
	public LecListController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException, NumberFormatException, IllegalStateException {
		System.out.println("[LecListController] 시작");
		
		int deptNo = 0;
		session=req.getSession();
		try {
			deptNo=(int) session.getAttribute("deptno");
			System.out.println("[LecListController] deptNo: "+deptNo);
		} catch(NullPointerException e) {
			System.out.println("[LecListController] 로그인없이 GET방식 접근");
		}
		
		/*
			권한 체크
			강의 열람: 모두 권한 있음
			deptno: 영업 1, 행정 2, 강사 3
		*/
		
		LecDao dao=new LecDao();
		try {
			req.setAttribute("list", dao.lecList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 화면 처리
		try {
			RequestDispatcher rd=req.getRequestDispatcher("/lecMgmt/lecList.jsp");
			rd.forward(req, resp);
		} catch (IllegalStateException e) {
			System.out.println("[LecListController] 로그인없이 GET방식 접근");
		}
	}
}