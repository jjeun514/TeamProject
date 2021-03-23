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

@WebServlet("/lecDel.bit")
public class LecDelController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LecDelController");
		LecDao dao=new LecDao();

		int lecNo=Integer.parseInt(req.getParameter("lecNo"));
		System.out.println("lecNo(del): "+lecNo);
		dao.fkSetting01();
		dao.deleteOne(lecNo);
		dao.fkSetting02();
		
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("lecList.bit");
		rd.forward(req, resp);
	}
}