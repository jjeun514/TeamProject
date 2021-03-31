package com.test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StuDeleteDao {
	javax.sql.DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	public StuDeleteDao() {
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup("java:/comp/env/jdbc/maria");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 수강생 목록
	public void stuDelete(int stuNo) {
		
		StuInfoDto stuInfo = new StuInfoDto();
		
		String stuQuery = "delete from student where stuNo=?";
		String scoreQuery = "delete from score where stuNo=?";
		String attQeury = "delete from attendance where stuNo=?";
		
		
		System.out.println(stuQuery);
		System.out.println(scoreQuery);
		System.out.println(attQeury);
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(scoreQuery);
			pstmt.setInt(1, stuNo);
			pstmt.executeQuery();
			
			pstmt = conn.prepareStatement(attQeury);
			pstmt.setInt(1, stuNo);
			pstmt.executeQuery();
			
			pstmt = conn.prepareStatement(stuQuery);
			pstmt.setInt(1, stuNo);
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
