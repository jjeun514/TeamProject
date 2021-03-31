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
import com.test.model.StuDetailDao;
import com.test.model.StuInfoDao;
import com.test.model.StuInfoDto;

@WebServlet("/stuMgmt/stuDetail.bit")
public class StuDetailController extends HttpServlet {

	private HttpSession session;
	
	public StuDetailController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * 수강생 상세정보와 CRUD : 영업, 행정
		 */
		System.out.println("----------stuDetailController-----------");
		
		int deptNo = 0;
		session=req.getSession();
		try {
			deptNo=(int) session.getAttribute("deptno");
			System.out.println("[NewLecController] deptNo: "+deptNo);
		} catch(NullPointerException e) {
			System.out.println("[NewLecController] 로그인없이 GET방식 접근");
		}
		
		if( deptNo==0 ) {
			System.out.println("[NewLecController] 로그인 안됨(deptNo: 0)");
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인을 해주세요.'); location.href='/demo/';</script>");
			out.flush();
		} else {
			
			if( deptNo==3 ) {
				System.out.println("[NewLecController] 영업/행정 계정임");
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('권한이 없습니다.\\n행정에 문의하세요.'); location.href='javascript:history.back()';</script>");
				out.flush();
				
			} else if( deptNo==1 || deptNo==2 ) {
				// 디테일 페이지에 사용할 수강생 번호를 파라미터로 받음
				int stuNo = Integer.parseInt(req.getParameter("stuNo"));
				System.out.println("상세 정보를 볼 수강생 번호 : " + stuNo);
				
				// 학생 정보 데이터 셋팅.
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

				// 수강생 목록 페이지로 돌아갔을 때 강의 선택 셀렉트 박스에 강의 리스트 셋.
				StuInfoDao lec = new StuInfoDao();
				req.setAttribute("allLecList", lec.lecInfoList());
				
				RequestDispatcher rd = req.getRequestDispatcher("./stuDetail.jsp");
				rd.forward(req, resp);
				
			} else {
				System.out.println("[NewLecController] 로그인 안됨(deptNo: 0)");
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('로그인을 해주세요.'); location.href='/demo/';</script>");
				out.flush();
			}
		}			

	}
	
}
