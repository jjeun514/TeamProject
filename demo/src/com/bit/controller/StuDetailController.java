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

@WebServlet("/stuMgmt/stuDetail.bit")
public class StuDetailController extends HttpServlet {

	public StuDetailController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 디테일 페이지에 사용할 수강생 번호를 파라미터로 받음
		int stuNo = Integer.parseInt(req.getParameter("stuNo"));
		System.out.println("디테일 페이지에 사용할 수강생 번호 : " + stuNo);
		
		// 디테일에 사용할 dao 객체 생성
		StuDetailDao dao = new StuDetailDao();
		
		// 수강생의 상세 정보 추출하여 셋
		StuInfoDto detail = dao.stuDetailInfo(stuNo);
		req.setAttribute("detail", detail);

		// 수강생 목록 페이지로 돌아갔을 때 강의 선택 셀렉트 박스에 강의 리스트 셋.
		StuInfoDao lec = new StuInfoDao();
		req.setAttribute("lec", lec.lecInfoList());
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuDetail.jsp");
		rd.forward(req, resp);
	}
	
}
