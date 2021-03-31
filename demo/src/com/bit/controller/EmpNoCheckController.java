package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;


import com.test.model.Dao;

@WebServlet("/empCheck.bit")
public class EmpNoCheckController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이부분 없으면 ajax 한글 깨짐
		resp.setContentType("application/text; charset=UTF-8");

		System.out.println("empcheck get...");
		String empNo=req.getParameter("empNo");
		System.out.println("empCheck 에서 empNo 는 ? "+empNo);
	
		
		if(empNo=="") {
			String check="0";
			resp.getWriter().write(check);
		}else {
			Dao dao=new Dao();
			int a=dao.empNoCheck(empNo);
			//dao.accAddCheck(sysId)에서 중복값 있을시 1 return, 중복값 없을시 0 return
			if(a==1){
				String check="1";
				resp.getWriter().write(check);
			}
			else if(a==0){
				int b=dao.empNoCheck2(empNo);
				if(b==0) {
					String check="2";
					resp.getWriter().write(check);
				}else {
					String check="3";
					resp.getWriter().write(check);
				}
				
				
			}
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}


}