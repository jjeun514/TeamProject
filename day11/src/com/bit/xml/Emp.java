package com.bit.xml;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Emp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sql="select empno,ename,job,sal from emp";
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("application/xml;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out.println("<emps>");
			while(rs.next()) {
				out.println("<emp>");
				out.println("	<empno>"+rs.getInt(1)+"</empno>");
				out.println("	<ename>"+rs.getString(2)+"</ename>");
				out.println("	<job>"+rs.getString(3)+"</job>");
				out.println("	<sal>"+rs.getInt(4)+"</sal>");
				out.println("</emp>");
			}
			out.println("</emps>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
