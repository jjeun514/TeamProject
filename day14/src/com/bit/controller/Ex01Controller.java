package com.bit.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01Controller extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("run Ex01Controller...");
	ServletContext cntxt=req.getServletContext();
	String val1=cntxt.getInitParameter("param1");
	System.out.println("context init param1 - "+val1);
	
	System.out.println("-----------------------------");
	Enumeration<String>emu=null;
	emu= this.getInitParameterNames();
	while(emu.hasMoreElements()) {
		String paramName=emu.nextElement();
		System.out.println(paramName+"="+this.getInitParameter(paramName));
	}
	}
}
