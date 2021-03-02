package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home.com")
public class LoginController extends HttpServlet {
       
    public LoginController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		String id=request.getParameter("id");
		System.out.println("id="+id);
		String pw=request.getParameter("pw");
		System.out.println("pw="+pw);
		System.out.println("run...");
	}
}
