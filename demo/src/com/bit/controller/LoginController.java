package com.bit.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.model.Dao;

@WebServlet("/home.bit")
public class LoginController extends HttpServlet{
	HttpSession session;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
			String sysId=req.getParameter("idInput");
			String sysPw=req.getParameter("pwInput");
			Dao dao=new Dao();

			if(dao.login(sysId, sysPw)==null) {
				resp.sendRedirect("login.jsp");
				System.out.println("dao is null");
			}else {
				session.setAttribute("list", dao.login(sysId, sysPw));
				System.out.println("dao is not null");
				resp.sendRedirect("home.jsp");		
		}
	}
	
}