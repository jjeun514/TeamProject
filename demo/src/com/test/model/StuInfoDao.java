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

public class StuInfoDao {
	javax.sql.DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public StuInfoDao() {
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup("java:/comp/env/jdbc/maria");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 수강생 목록
	public List<StuInfoDto> stuList(int lecNo) {
		List<StuInfoDto> list=new ArrayList<StuInfoDto>();
		
		String query = "select stu.stuNo, stu.stuName, stu.stuPhone, score.java, score.web, score.framework";
		query += " from student stu left outer join score score";
		query += " on stu.stuNo = score.stuNo where stu.lecNo = ?";
		query += " order by stu.stuNo, stu.lecNo";
		System.out.println(query);
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, lecNo);
			rs = pstmt.executeQuery();
			
			StuInfoDto stuInfo = null;
			
			while(rs.next()) {
				stuInfo = new StuInfoDto();
				stuInfo.setStuNo(rs.getInt("stuNo"));
				stuInfo.setStuName(rs.getString("stuName"));
				stuInfo.setStuPhone(rs.getString("stuPhone"));
				stuInfo.setJava(rs.getInt("java"));
				stuInfo.setWeb(rs.getInt("web"));
				stuInfo.setFramework(rs.getInt("framework"));
				list.add(stuInfo);
			}
			System.out.println("리스트 add 후"+list.size());
			
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
		
		return list;
	}
	
	public List<StuInfoDto> lecList() {
		List<StuInfoDto> list=new ArrayList<StuInfoDto>();

		String query = "select lecNo from lecture order by lecNo";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			StuInfoDto lecList = null;
			
			while(rs.next()) {
				lecList = new StuInfoDto();
				lecList.setLecNo(rs.getInt("lecNo"));
				list.add(lecList);
			}
			System.out.println("강의 리스트 add 후"+list.size());
			
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
		
		return list;
	}
}