package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.model.StuAttDao;
import com.test.model.StuInfoDao;
import com.test.model.StuInfoDto;

@WebServlet("/stuMgmt/stuList.bit")
public class StuListCotroller extends HttpServlet {

	private HttpSession session;
	
	public StuListCotroller() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * 수강생 목록 : 영업, 행정, 강사
		 */		
		System.out.println("----------stuListController-----------");
		
		int deptNo = 0;
		session=req.getSession();
		try {
			deptNo=(int) session.getAttribute("deptno");
			System.out.println("[NewLecController] deptNo: "+deptNo);
		} catch(NullPointerException e) {
			System.out.println("[NewLecController] 로그인없이 GET방식 접근");

			if( deptNo==0 ) {
				System.out.println("[NewLecController] 로그인 안됨(deptNo: 0)");
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('로그인을 해주세요.'); location.href='/demo/';</script>");
				out.flush();
				
			} else if ( deptNo==1 || deptNo == 2 || deptNo==3 ) {
				int lecNo = Integer.parseInt(req.getParameter("selectLec"));
				System.out.println("stuPage에서 선택한 강의 번호 : " + lecNo);
				
				// 학생 정보 데이터 셋팅.
				StuInfoDao info = new StuInfoDao();
				List<StuInfoDto> infoList = info.stuList(lecNo);
				
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
				
				req.setAttribute("selectStu", infoList);
				
				// 페이지 이동했을 때 강의 선택 셀렉트 박스에 강의 리스트 셋.
				req.setAttribute("allLecList", info.lecInfoList()); 
			
				RequestDispatcher rd = req.getRequestDispatcher("./stuList.jsp");
				rd.forward(req, resp);
			}			
		}
	}
}
