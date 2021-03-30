package com.bit.lec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lec.model.LecDao;

@WebServlet("/lecDel.bit")
public class LecDelController extends HttpServlet {
	private HttpSession session;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException, NumberFormatException, IllegalStateException {
		System.out.println("[LecDelController] 시작");
		LecDao dao=new LecDao();

		int deptNo = 0;
		session=req.getSession();
		try {
			deptNo=(int) session.getAttribute("deptno");
			System.out.println("[LecDelController] deptNo: "+deptNo);
		} catch(NullPointerException e) {
			System.out.println("[LecDelController] 로그인없이 GET방식 접근");
		}
		
		/*
			권한 체크
			강의 삭제: 행정만 권한 있음
			deptno: 영업 1, 행정 2, 강사 3
		*/
		if(deptNo==0) {
			System.out.println("[LecDelController] 로그인 안됨(deptNo: 0)");
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인을 해주세요.'); location.href='/demo/';</script>");
			out.flush();
		}
		
		int lecNo=0;
		try {
			lecNo=Integer.parseInt(req.getParameter("lecNo"));
			System.out.println("lecNo(del): "+lecNo);
			//dao.fkSetting01();
			dao.deleteOne(lecNo);
			//dao.fkSetting02();
		} catch(NullPointerException e) {
			System.out.println("[LecDelController] 로그인없이 GET방식 접근");
		} catch(NumberFormatException e) {
			System.out.println("[LecDelController] 로그인없이 GET방식 접근");
		}
		
		// 화면 처리
		try {
			RequestDispatcher rd=null;
			rd=req.getRequestDispatcher("lecList.bit");
			rd.forward(req, resp);
		} catch (IllegalStateException e) {
			System.out.println("[LecDelController] 로그인없이 GET방식 접근");
		}
	}
}