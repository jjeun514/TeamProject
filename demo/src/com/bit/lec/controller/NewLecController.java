package com.bit.lec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lec.model.LecDao;

@WebServlet("/newLec.bit")
public class NewLecController extends HttpServlet {
	private HttpSession session;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
		LecDao dao=new LecDao();
		int deptNo = 0;
		session=req.getSession();
		try {
			deptNo=(int) session.getAttribute("deptno");
			System.out.println("[NewLecController] deptNo: "+deptNo);
		} catch(NullPointerException e) {
			System.out.println("[NewLecController] 로그인없이 GET방식 접근");
		}
		
		/*
			권한 체크
			강의 개설: 행정만 권한 있음
			deptno: 영업 1, 행정 2, 강사 3
		*/
		if(deptNo==0) {
			System.out.println("[NewLecController] 로그인 안됨(deptNo: 0)");
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인을 해주세요.'); location.href='/demo/';</script>");
			out.flush();
		} else {
			if(deptNo==2) {
				try {
					req.setAttribute("instructor", dao.lecturerList());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				RequestDispatcher rd=null;
				rd=req.getRequestDispatcher("/lecMgmt/newLec.jsp");
				rd.forward(req, resp);
			} else if(deptNo==1 | deptNo==3) {
				System.out.println("[NewLecController] 영업/강사 계정임");
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('권한이 없습니다.\\n행정에 문의하세요.'); location.href='javascript:history.back()';</script>");
				out.flush();
			} else {	// 혹시 모르니 한 번 더 잡아주는 코드
				System.out.println("[NewLecController] 로그인 안됨(deptNo: 0)");
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('로그인을 해주세요.'); location.href='/demo/';</script>");
				out.flush();
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// lecNo는 백단에서 처리
		String lecName=req.getParameter("lecture");
		/* SimpleDateFormat을 통해서 String > Date 변환
		 *  String sDate1="31/12/1998";  
    	 *	Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
    	 * 
    	 * MariaDB에서 Date을 String으로 바꾸려면
    	 * DATE_FORMAT(now(), '%Y-%m-%d') -> 2021-03-16
		 */
		String lecStartDate=req.getParameter("startDate");
		String lecFinishDate=req.getParameter("endDate");
		String lecRoom=req.getParameter("classroom");
		String lecturer=req.getParameter("instructor");
		System.out.println("lecturer: "+lecturer);
		LecDao dao=new LecDao();
		int empNo=dao.selectEmpNo(lecturer);
		System.out.println("empNo= "+empNo);
		dao.insertOne(lecName, lecStartDate, lecFinishDate, lecRoom, lecturer, empNo);
		
		resp.sendRedirect("/demo/lecList.bit");
	}
}