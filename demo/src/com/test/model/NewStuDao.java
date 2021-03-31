package com.test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class NewStuDao {
	javax.sql.DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public NewStuDao() {
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup("java:/comp/env/jdbc/maria");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 수강생 목록
	public void insertStu(int stuNo, String stuName, String stuPhone, int lecNo) {

		StuInfoDto stuInfo = new StuInfoDto();
		
		String stuQuery = "insert into student(stuName, stuPhone, lecNo) values(?,?,?)";
		String scoreQuery = "insert into score(stuNo) values (?)";
		String attQeury = "insert into attendance(stuNo) values (?)";
		System.out.println(stuNo+" 학생 정보 레코드 삽입 쿼리 : "+stuQuery);
		System.out.println(stuNo+" 학생 성적 레코드 삽입 쿼리 : "+scoreQuery);
		System.out.println(stuNo+" 학생 출석 레코드 삽입 쿼리 : "+attQeury);
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(stuQuery);
			pstmt.setString(1, stuName);
			pstmt.setString(2, stuPhone);
			pstmt.setInt(3, lecNo);
			pstmt.executeQuery();
						
			pstmt = conn.prepareStatement(scoreQuery);
			pstmt.setInt(1, stuNo);
			pstmt.executeQuery();
			
			pstmt = conn.prepareStatement(attQeury);
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