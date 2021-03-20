package com.test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StuEditDao {
	javax.sql.DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	public StuEditDao() {
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup("java:/comp/env/jdbc/maria");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 수강생 목록
	public void stuEdit(String stuName, String stuPhone, int stuNo) {
		
		StuInfoDto stuInfo = new StuInfoDto();
		
		String query = "update student set stuName=?, stuPhone=? where stuNo=?";
		System.out.println(query);
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, stuName);
			pstmt.setString(2, stuPhone);
			pstmt.setInt(3, stuNo);
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
