package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//배열로 담겨서 보냄
@WebServlet(value="/ex04.bit", initParams= {
	@WebInitParam(name="id", value="guest2"),	
	@WebInitParam(name="pw", value="1234")	
})
public class Ex04Controller extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ex04 param id = "+getInitParameter("id")+"	ex04 param pw = "+getInitParameter("pw"));
	}
}
