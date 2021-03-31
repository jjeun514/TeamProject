package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuDetailDao;
import com.test.model.StuInfoDao;
import com.test.model.StuInfoDto;

@WebServlet("/stuMgmt/selectLecForNew.bit")
public class SelectLecController extends HttpServlet {

	public SelectLecController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("----------selectLecForNewController-----------");
		
		int lecNo = Integer.parseInt(req.getParameter("selectLec"));
		System.out.println("수강생 등록 페이지에서 선택한 강의 번호 : " + lecNo);

		// 수강생 목록 페이지로 돌아갔을 때 강의 선택 셀렉트 박스에 강의 리스트 셋.
		StuInfoDao lec = new StuInfoDao();
		req.setAttribute("allLecList", lec.lecInfoList());
		req.setAttribute("selectOneLec", lec.selectLecInfo(lecNo));
		req.setAttribute("maxStuNo", lec.maxStuNo()); // 등록될 수강생의 학번
		
		RequestDispatcher rd = req.getRequestDispatcher("./newStu.jsp");
		rd.forward(req, resp);
	}
	
}
