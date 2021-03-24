package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuInfoDao;

@WebServlet("/stuMgmt/stuList.bit")
public class StuInfoCotroller extends HttpServlet {

	public StuInfoCotroller() {}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String param = req.getParameter("selectLec");
		int lecNo = Integer.parseInt(param);
		System.out.println(lecNo);
		
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("selectLec", dao.stuList(lecNo));
		req.setAttribute("lecInfoList", dao.lecInfoList()); // 페이지 이동했을 때 강의 선택 셀렉트 박스에 강의 리스트 셋.
	
		RequestDispatcher rd = req.getRequestDispatcher("./stuList.jsp");
		rd.forward(req, resp);
	}
	
}
