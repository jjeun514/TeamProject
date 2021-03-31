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
		
		String query = "select stu.stuNo, stu.stuName, stu.stuPhone, lec.lecNo, lec.lecName, score.java, score.web, score.framework";
		query += " from student stu left outer join lecture lec on stu.lecNo = lec.lecNo";
		query += " left outer join score score on stu.stuNo = score.stuNo";
		query += " where stu.stuNo = ?";
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
				stuInfo.setLecNo(rs.getInt("lecNo"));
				stuInfo.setLecName(rs.getString("lecName"));
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
	
	public StuInfoDto stuAttStatusList(int stuNo) {
		StuInfoDto stuAtt = new StuInfoDto();
		
		String query = "select stu.stuNo, stu.stuName, stu.stuPhone, sum(ifnull(att.stuAtt,0)) as stuAtt, sum(ifnull(att.stuLate,0)) as stuLate,";
		query       += " sum(ifnull(att.stuAbsent,0)) as stuAbsent, sum(ifnull(att.attTotal,0)) as attTotal, lec.lecNo,";
		query       += " lec.lecDays from student stu left outer join attendance att on stu.stuNo=att.stuNo";
		query       += " left outer join lecture lec on stu.lecNo=lec.lecNo where stu.stuNo = ?";
		System.out.println(query);
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, stuNo);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				stuAtt.setStuNo(rs.getInt("stuNo"));
				stuAtt.setStuName(rs.getString("stuName"));
				stuAtt.setStuPhone(rs.getString("stuPhone"));
				stuAtt.setStuAtt(rs.getInt("stuAtt"));
				stuAtt.setStuLate(rs.getInt("stuLate"));
				stuAtt.setStuAbsent(rs.getInt("stuAbsent"));
				stuAtt.setAttTotal(rs.getInt("attTotal"));
				stuAtt.setLecNo(rs.getInt("lecNo"));
				stuAtt.setLecDays(rs.getString("lecDays"));
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
		
		return stuAtt;
	}
}