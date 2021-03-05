package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//annotation 방식임
//주석과 같으며 대표적으로는 오버라이드가 있었음
//배열로 담김

@WebServlet(value= {"/ex02.bit","/ex02.do"})
public class Ex02Controller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ex02.run...");
	
	}
}
