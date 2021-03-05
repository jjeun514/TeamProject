package com.bit.dept.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dept.model.DeptDao;
//이야오
@WebServlet("/dept/list.bit")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDao dao=new DeptDao();
		try {
			request.setAttribute("list", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("../list.jsp");
		rd.forward(request, response);
		
		
	}

}
