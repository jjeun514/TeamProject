package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.LecListDao;

@WebServlet("/newLec.bit")
public class NewLecController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("/newLec.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String lecName=req.getParameter("lecName");
		/* SimpleDateFormat을 통해서 String > Date 변환
		 *  String sDate1="31/12/1998";  
    	 *	Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
    	 * 근데 굳이 Date로 받을 필요가 있을까?
    	 * 일단 String으로 받고, 나중에 필요하면 바꾸자.
    	 * 
    	 * MariaDB에서 Date을 String으로 바꾸려면
    	 * DATE_FORMAT(now(), '%Y-%m-%d') -> 2021-03-16
		 */
		String lecStartDate=req.getParameter("lecStartDate");
		String lecRoom=req.getParameter("lecRoom");
		String lecturer=req.getParameter("lecturer");
		
		String driver=getInitParameter("driver");
		String url=getInitParameter("url");
		LecListDao dao=new LecListDao(driver,url);
		dao.insertOne(lecStartDate, lecRoom, lecturer);
		
		resp.sendRedirect("lecList.bit");
	}
}