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

@WebServlet("/newLec.bit")
public class NewLecController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LecDao dao=new LecDao();
		try {
			req.setAttribute("instructor", dao.lecturerList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("/lecMgmt/newLec.jsp");
		rd.forward(req, resp);
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