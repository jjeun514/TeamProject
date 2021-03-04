package com.bit.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.Dao;

@WebServlet("/home.com")
public class LoginController extends HttpServlet {
 
	
    public LoginController() {
    }
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sysId=request.getParameter("id2");
		System.out.println("id="+sysId);
		String sysPw=request.getParameter("pw2");
		System.out.println("pw="+sysPw);
		System.out.println("run...");
		
		Dao dao=new Dao();
		//dao.login(sysId, sysPw);
		request.setAttribute("list", dao.login(sysId, sysPw));
		
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
	}
}