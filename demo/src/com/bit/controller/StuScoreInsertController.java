package com.bit.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuScoreDao;

@WebServlet("/stuMgmt/stuScoreInsert.bit")
public class StuScoreInsertController extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String[] a=req.getParameterValues("stuNo");
//		String arr=Arrays.toString(a);
//		String a1=a[0];
//		System.out.println("학생번호 배열 :" + arr);
//		System.out.println("해당 index: "+ a1);
//		
//		String[] b=req.getParameterValues("java");
//		String arr1=Arrays.toString(b);
//		System.out.println("java점수 배열 :" + arr1);
//		
//		String[] c=req.getParameterValues("web");
//		String arr2=Arrays.toString(c);
//		System.out.println("web점수 배열 :" + arr2);
//		
//		String[] d=req.getParameterValues("framework");
//		String arr3=Arrays.toString(d);
//		System.out.println("학생번호 배열 :" + arr3);
		
		
		int stuNo=Integer.parseInt(req.getParameter("stuNo"));
		System.out.println(stuNo);
		System.out.println(req.getParameter("scoreList"));
		
		int java=Integer.parseInt(req.getParameter("java"));
		int web=Integer.parseInt(req.getParameter("web"));
		int framework=Integer.parseInt(req.getParameter("framework"));
		
		StuScoreDao dao=new StuScoreDao();
		
		dao.updateScore(stuNo, java, web, framework);
		
		resp.sendRedirect("./stuScore.bit");
	}
	
}
