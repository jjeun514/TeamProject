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
import com.test.model.StuInfoDao;
import com.test.model.StuInfoDto;

@WebServlet("/stuMgmt/stuAttStatus.bit")
public class StuAttStatusCotroller extends HttpServlet {

	public StuAttStatusCotroller() {}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String param = req.getParameter("selectLec");
		int lecNo = Integer.parseInt(param);
		System.out.println(lecNo);
		
		// 학생 정보 데이터 셋팅.
		StuAttDao stuAttList = new StuAttDao();
		List<StuInfoDto> infoList = stuAttList.stuAttStatusList(lecNo);
		
		// 출결 정보 데이터 셋팅.
		StuAttDao attRate = new StuAttDao();
		List<StuInfoDto> rateList = attRate.stuAttStatusList(lecNo);
		
		int stuNo, rateStuNo;
		
		for (int i = 0; i < infoList.size(); i++ ) {
			StuInfoDto stuInfoDto = infoList.get(i);
			stuNo = stuInfoDto.getStuNo();
			
			for (int j = 0; j < rateList.size(); j++ ) {
				int stuAtt, stuLate, stuAbsent, lecDays, stuAttTotal, stuAttSum=0;
				StuInfoDto rateInfo = rateList.get(j);
				rateStuNo = rateInfo.getStuNo();
				if (stuNo == rateStuNo) {
					
					stuAtt = rateInfo.getStuAtt();
					stuLate = rateInfo.getStuLate();
					stuAbsent = rateInfo.getStuAbsent();
					lecDays = Integer.parseInt(rateInfo.getLecDays());

					if (stuLate>0) {
						int lateCal = Math.floorDiv(stuLate, 3);
						stuAttSum = stuAbsent + lateCal;
					}
					
					stuAttTotal = (int)Math.round((double)(stuAtt-stuAttSum)/lecDays*100);
					
					stuInfoDto.setAttTotal(stuAttTotal);//계산된 출석률 
					break;
				}
			}
			
		}
		
		req.setAttribute("stuAttList", infoList);
		
		StuInfoDao dao = new StuInfoDao();
		req.setAttribute("lecInfoList", dao.lecInfoList()); // 페이지 이동했을 때 강의 선택 셀렉트 박스에 강의 리스트 셋.
	
		RequestDispatcher rd = req.getRequestDispatcher("./stuAttStatus.jsp");
		rd.forward(req, resp);
	}
	
}
