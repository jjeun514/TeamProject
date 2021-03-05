package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/intro.bit",initParams= {
		@WebInitParam(name="viewName",value="intro")
})
public class IntroController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view=getInitParameter("viewName");
		System.out.println(view);
		RequestDispatcher rd;
		rd=req.getRequestDispatcher(view+".jsp");
		rd.forward(req, resp);
	}
	
}
