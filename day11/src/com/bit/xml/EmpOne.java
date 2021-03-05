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

public class EmpOne extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("empno"));
		String sql="select * from emp where empno=?";
		
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
			pstmt.setInt(1, empno);
			rs=pstmt.executeQuery();
			
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("application/xml;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out.println("<emps>");
			if(rs.next()) {
				out.println("<emp>");
				out.println("	<empno>"+rs.getInt(1)+"</empno>");
				out.println("	<ename>"+rs.getString(2)+"</ename>");
				out.println("	<job>"+rs.getString(3)+"</job>");
				out.println("	<mgr>"+rs.getInt(4)+"</mgr>");
				out.println("	<hiredate>"+rs.getDate(5)+"</hiredate>");
				out.println("	<sal>"+rs.getInt(6)+"</sal>");
				out.println("	<comm>"+(rs.getObject(7)==null?"":rs.getObject(7))+"</comm>");
				out.println("	<deptno>"+rs.getInt(8)+"</deptno>");
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
