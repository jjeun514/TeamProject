package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.Dao;
import com.test.model.Dto;

@WebServlet("/accPwFind.bit")
public class AccountPwFindController extends HttpServlet{


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Dao dao=new Dao();
		String sysId=req.getParameter("sysId");
		int empNo=Integer.parseInt(req.getParameter("empNo"));

		List<Dto> dto=dao.PwFind(sysId, empNo);

		if(dto.isEmpty()) {
			//java 에서 alert 창
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>alert('회원정보를 확인하세요.'); location.href='/demo/accFind.jsp';</script>");
			out.flush();
			//resp.sendRedirect("login.jsp");
		}else {
			System.out.println("회원정보가 왔슴");
			Dto sysPw=dto.get(0);
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>alert('계정 Pw :"+sysPw.getSysPw()+" '); location.href='/demo/accFind.jsp';</script>");
			out.flush();
		}


	}

}
