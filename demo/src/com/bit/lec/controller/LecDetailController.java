package com.bit.lec.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lec.model.LecDao;
import com.bit.lec.model.LecDto;

@WebServlet("/lecDetail.bit")
public class LecDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LecDetailController(doGet)] 시작");
		int lecNo=Integer.parseInt(req.getParameter("lecNo"));
		System.out.println("[LecDetailController(doGet)] lecNo: "+lecNo);
		LecDao dao=new LecDao();
		LecDto bean=dao.getOne(lecNo);
		req.setAttribute("bean", bean);
		LecDto totalStu=dao.cntStu(lecNo);
		req.setAttribute("cnt", totalStu);
		
		// 화면 처리
		RequestDispatcher rd=req.getRequestDispatcher("/lecMgmt/lecDetail.jsp");
		rd.forward(req, resp);
	}
}