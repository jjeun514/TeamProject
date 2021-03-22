package com.bit.lec.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lec.model.LecDao;
import com.bit.lec.model.LecDto;

@WebServlet("/lecDetail.bit")
public class LecDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LecDetailController(doGet)] 시작");
		int lecNo=Integer.parseInt(req.getParameter("lecNo"));
		System.out.println("[LecDetailController(doGet)] lecNo: "+lecNo);
		LecDao dao=new LecDao();
		LecDto bean=dao.getOne(lecNo);
		req.setAttribute("bean", bean);
		try {
			req.setAttribute("name", dao.selectIns());
			System.out.println("[LecDetailController(doGet)] lecList(): "+dao.lecList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		LecDto totalStu=dao.cntStu(lecNo);
		req.setAttribute("totalStu", totalStu);
		int totalStu2=dao.stu(lecNo);
		req.setAttribute("totalStu2", totalStu2);
		try {
			req.setAttribute("lecturer", dao.lecturerList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 화면 처리
		RequestDispatcher rd=req.getRequestDispatcher("/lecMgmt/lecDetail.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LecEditController(doPost)] 시작");
		req.setCharacterEncoding("utf-8");
		int lecNo=Integer.parseInt(req.getParameter("lecNo"));
		System.out.println("[LecEditController(doPost)] 수정할 lecNo: "+lecNo);

		String lecName=req.getParameter("lecName");
		System.out.println("[LecEditController(doPost)] lecName: "+lecName);
		String lecStartDate=req.getParameter("lecStartDate");
		String lecFinishDate=req.getParameter("lecFinishDate");
		String lecRoom=req.getParameter("lecRoom");
		String lecturer=req.getParameter("lecturer");
		System.out.println("[LecEditController(doPost)] lecturer: "+lecturer);
		LecDao dao=new LecDao();
		int empNo=dao.selectEmpNo(lecturer);
		System.out.println("[LecEditController(doPost)] empNo: "+empNo);
		dao.updateOne(lecNo, lecName, lecturer, lecRoom, lecStartDate, lecFinishDate, empNo);

		LecDto bean=dao.getOne(lecNo);
		req.setAttribute("bean", bean);
		try {
			req.setAttribute("lecturer", dao.lecturerList());
			req.setAttribute("ins", lecturer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd=null;
		req.setAttribute("lecNo", lecNo);
		req.setAttribute("lecName", lecName);
		req.setAttribute("lecStartDate", lecStartDate);
		req.setAttribute("lecFinishDate", lecFinishDate);
		req.setAttribute("lecRoom", lecRoom);
		req.setAttribute("lecturer", lecturer);
		int totalStu=dao.stu(lecNo);
		req.setAttribute("totalStu", totalStu);
		
		rd=req.getRequestDispatcher("/lecMgmt/lecDetail.jsp");
		rd.forward(req, resp);
	}
}