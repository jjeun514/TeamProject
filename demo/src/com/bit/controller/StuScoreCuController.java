package com.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.StuScoreDao;
import com.test.model.StuScoreDto;

@WebServlet("/stuMgmt/stuScoreList.bit")
public class StuScoreCuController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StuScoreDao stuScoreDao=new StuScoreDao();
		List<Integer> listA =stuScoreDao.selectLecNo();
//		System.out.println(listA.toString());
//		System.out.println("강의명1 : "+listA.get(0));
//		System.out.println("강의명2 : "+listA.get(1));
//		System.out.println("강의명3 : "+listA.get(2));
		req.setAttribute("lecture", listA);
		
		StuScoreDao scoreDao=new StuScoreDao();
		
		for(int i=0;i<listA.size();i++) {
			req.setAttribute("lecList"+i, scoreDao.selectAll(listA.get(i)));
		}
		
		
		RequestDispatcher rd;
		rd=req.getRequestDispatcher("/stuMgmt/stuScoreList.jsp");
		rd.forward(req,resp);
	}
	
}
