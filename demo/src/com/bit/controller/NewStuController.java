package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.NewStuDao;
import com.test.model.StuInfoDao;

@WebServlet("/stuMgmt/newStu.bit")
public class NewStuController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("----------newStuController-----------");
		
		req.setCharacterEncoding("utf-8");
		int stuNo = Integer.parseInt(req.getParameter("stuNo"));
		String stuName = req.getParameter("stuName");
		String stuPhone = req.getParameter("stuPhone");
		System.out.println(req.getParameter("lecNo"));
		int lecNo = Integer.parseInt(req.getParameter("lecNo"));

		System.out.println("등록할 학생 번호 : "+stuNo);
		System.out.println("등록할 학생 이름 : "+stuName);
		System.out.println("등록할 학생 전화 : "+stuPhone);
		System.out.println("등록할 학생 강의 : "+lecNo);
		
		NewStuDao dao = new NewStuDao();
		
		dao.insertStu(stuNo, stuName, stuPhone, lecNo);
		
		RequestDispatcher rd = req.getRequestDispatcher("/stuMgmt/stuPage.bit");
		rd.forward(req, resp);
		
	}
	
}
