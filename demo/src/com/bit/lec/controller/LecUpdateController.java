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

@WebServlet("/lecEdited.bit")
public class LecUpdateController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("수정Controller...ㅠㅠ");
		int lecNo=Integer.parseInt(req.getParameter("lecNo"));
		System.out.println("수정할 lecNo: "+lecNo);

		req.setCharacterEncoding("utf-8");
		String lecName=req.getParameter("lecName");
		System.out.println("lecName: "+lecName);
		String lecStartDate=req.getParameter("lecStartDate");
		String lecFinishDate=req.getParameter("lecFinishDate");
		String lecRoom=req.getParameter("lecRoom");
		req.setCharacterEncoding("utf-8");
		String lecturer=req.getParameter("lecturer");
		System.out.println("lecturer: "+lecturer);
		LecDao dao=new LecDao();
		int empNo=dao.selectEmpNo(lecturer);
		System.out.println("empNo= "+empNo);
		dao.updateOne(lecNo, lecName, lecturer, lecRoom, lecStartDate, lecFinishDate, empNo);

		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("lecDetail.bit?lecNo="+lecNo);
		rd.forward(req, resp);
	}
}