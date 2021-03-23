package com.bit.controller;

import java.io.IOException;
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

@WebServlet("/accAdd.bit")
public class AccountController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이부분 없으면 ajax 한글 깨짐
		resp.setContentType("application/text; charset=UTF-8");

		System.out.println("get...");
		String sysId=req.getParameter("sysId");
		System.out.println("sysId 는 ? "+sysId);
		
//		Dao dao=new Dao();
//		int a=dao.accAddCheck(sysId);
//		//dao.accAddCheck(sysId)에서 중복값 있을시 1 return, 중복값 없을시 0 return
//		if(a==1){
//			String check="중복된 아이디가 있습니다.";
//			resp.getWriter().write(check);
//		}
//		else if(a==0){
//			String check="아이디를 생성할 수 있습니다.";
//			resp.getWriter().write(check);
//		}
		
		if(sysId=="") {
			String check="0";
			resp.getWriter().write(check);
		}else if(sysId.length()<4) {
			String check="1";
			resp.getWriter().write(check);
		}else if(sysId.length()>20) {
			String check="2";
			resp.getWriter().write(check);
		}else {
			Dao dao=new Dao();
			int a=dao.accAddCheck(sysId);
			//dao.accAddCheck(sysId)에서 중복값 있을시 1 return, 중복값 없을시 0 return
			if(a==1){
				String check="3";
				resp.getWriter().write(check);
			}
			else if(a==0){
				String check="4";
				resp.getWriter().write(check);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Dao dao=new Dao();
		String sysId=req.getParameter("sysId");
		String sysPw=req.getParameter("sysPw");
		String PwConform=req.getParameter("PwConform");
		int empNo=Integer.parseInt(req.getParameter("empNo"));

		dao.accAdd(sysId, sysPw, empNo);

		resp.sendRedirect("login.jsp");

	}


}