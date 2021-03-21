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

public class StuDetailDao {
	javax.sql.DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public StuDetailDao() {
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup("java:/comp/env/jdbc/maria");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 수강생 목록
	public StuInfoDto stuDetailInfo(int stuNo) {
		
		StuInfoDto stuInfo = new StuInfoDto();
		
		String query = "select stu.stuNo, stu.stuName, stu.stuPhone, score.java, score.web, score.framework";
		query += " from student stu left outer join score score";
		query += " on stu.stuNo = score.stuNo where stu.stuNo = ?";
		System.out.println(query);
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, stuNo);
			rs = pstmt.executeQuery();
						
			if(rs.next()) {
				stuInfo.setStuNo(rs.getInt("stuNo"));
				stuInfo.setStuName(rs.getString("stuName"));
				stuInfo.setStuPhone(rs.getString("stuPhone"));
				stuInfo.setJava(rs.getInt("java"));
				stuInfo.setWeb(rs.getInt("web"));
				stuInfo.setFramework(rs.getInt("framework"));
			}
			
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
		
		return stuInfo;
	}
}
