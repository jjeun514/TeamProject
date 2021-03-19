package com.bit.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.model.Dao;
import com.test.model.Dto;

@WebServlet("/home.bit")
public class LoginController extends HttpServlet{
	HttpSession session;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
			String sysId=req.getParameter("idInput");
			String sysPw=req.getParameter("pwInput");
			Dao dao=new Dao();
			
			List<Dto> dto=dao.login(sysId, sysPw);
			if(dto==null) {
				resp.sendRedirect("login.jsp");
				System.out.println("dao is null");
			}else {
				req.setAttribute("list", dto);
				System.out.println("dao is not null");
				
				RequestDispatcher rd;
				rd=req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);	
		}
	}
	
}