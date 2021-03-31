package com.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuAttDao;
import com.test.model.StuDetailDao;
import com.test.model.StuEditDao;
import com.test.model.StuInfoDao;
import com.test.model.StuInfoDto;

@WebServlet("/stuMgmt/stuEdit.bit")
public class StuEditPageController extends HttpServlet {

	public StuEditPageController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("----------stuEditController-----------");
		
		int stuNo = Integer.parseInt(req.getParameter("stuNo"));
		System.out.println("수정 페이지에 사용할 수강생 번호 : " + stuNo);
		
		StuDetailDao dao = new StuDetailDao();
		StuInfoDto detail = dao.stuDetailInfo(stuNo);
		
		// 출결 정보 데이터 셋팅.
		StuAttDao attRate = new StuAttDao();
		StuInfoDto rateList = dao.stuAttStatusList(stuNo);
		
		int attStuNo, rateStuNo, stuAtt, stuLate, stuAbsent, lecDays, stuAttTotal, stuAttSum=0;

		stuAtt = rateList.getStuAtt();
		stuLate = rateList.getStuLate();
		stuAbsent = rateList.getStuAbsent();
		lecDays = Integer.parseInt(rateList.getLecDays());
					
		if (stuLate>0) {
			int lateCal = Math.floorDiv(stuLate, 3);
			stuAttSum = stuAtt + lateCal;
		} else {
			stuLate = stuLate;
		}
		
		stuAttTotal = (int)Math.round((double)(stuAttSum-stuAbsent)/lecDays*100);
					
		detail.setAttTotal(stuAttTotal);
				
		req.setAttribute("stuDatail", detail);		
		
		RequestDispatcher rd = req.getRequestDispatcher("./stuEdit.jsp");
		rd.forward(req, resp);
	}
	
}
