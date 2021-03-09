package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuInfoDao;

@WebServlet("/stuList.bit")
public class StuInfoCotroller extends HttpServlet {

	public StuInfoCotroller() {}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("selectLec");
		int lecNo = Integer.parseInt(param);
		//int lecNo = 1; //Integer.parseInt(req.getParameter("selectLec"));
		System.out.println(lecNo);
		
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("selectLec", dao.stuList(lecNo));
	
		RequestDispatcher rd = req.getRequestDispatcher("stuMgmt/stuList.jsp");
		rd.forward(req, resp);
	}
	
}
