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

@WebServlet("/stuMgmt/stuAttList.bit")
public class AttListCotroller extends HttpServlet {

	public AttListCotroller() {}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("stuAttList 컨트롤러 도착");
		
		int lecNo = Integer.parseInt(req.getParameter("selectLec"));
		
		StuAttDao dao = new StuAttDao();
		req.setAttribute("stuAttList", dao.stuAttList(lecNo));		
		req.setAttribute("lecInfoList", dao.lecInfoList());
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuAtt.jsp");
		rd.forward(req, resp);
	}
	
}
