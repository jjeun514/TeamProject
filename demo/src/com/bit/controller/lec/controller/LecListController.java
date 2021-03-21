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

@WebServlet("/lecList.bit")
public class LecListController extends HttpServlet {
	public LecListController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LecDao dao=new LecDao();
		try {
			req.setAttribute("list", dao.lecList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 화면 처리
		RequestDispatcher rd=req.getRequestDispatcher("/lecMgmt/lecList.jsp");
		rd.forward(req, resp);
	}
}