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
		
		String query = "select stu.stuNo, stu.stuName, stu.stuPhone, score.java, score.web, score.framework, lec.lecDays";
		query       += " from student stu left outer join score score on stu.stuNo = score.stuNo";
		query       += " left outer join lecture lec on stu.lecNo = lec.lecNo where stu.lecNo = ? order by stu.stuNo, stu.lecNo;";
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
				stuInfo.setLecDays(rs.getString("lecDays"));
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
	
	public List<StuInfoDto> lecInfoList() {
		List<StuInfoDto> list=new ArrayList<StuInfoDto>();

		String query = "select lecNo, lecName, lecRoom, lecStartDate, lecFinishDate from lecture order by lecNo";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			StuInfoDto lecList = null;
			
			while(rs.next()) {
				lecList = new StuInfoDto();
				lecList.setLecNo(rs.getInt("lecNo"));
				lecList.setLecName(rs.getString("lecName"));
				lecList.setLecRoom(rs.getString("lecRoom"));
				lecList.setLecStartDate(rs.getString("lecStartDate"));
				lecList.setLecFinishDate(rs.getString("lecFinishDate"));
				list.add(lecList);
			}
			System.out.println("리스트에 추가된 강의 개수 : "+list.size());
			
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
	
	public List<StuInfoDto> selectLecInfo(int lecNo) {
		List<StuInfoDto> list=new ArrayList<StuInfoDto>();

		String query = "select lecNo, lecName, lecRoom, lecStartDate, lecFinishDate from lecture where lecNo=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, lecNo);
			rs = pstmt.executeQuery();
			
			StuInfoDto lecList = null;
			
			while(rs.next()) {
				lecList = new StuInfoDto();
				lecList.setLecNo(rs.getInt("lecNo"));
				lecList.setLecName(rs.getString("lecName"));
				lecList.setLecRoom(rs.getString("lecRoom"));
				lecList.setLecStartDate(rs.getString("lecStartDate"));
				lecList.setLecFinishDate(rs.getString("lecFinishDate"));
				list.add(lecList);
			}
			System.out.println("리스트에 추가된 강의 개수 : "+list.size());
			
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
	
	public List<StuInfoDto> maxStuNo() {
		List<StuInfoDto> list=new ArrayList<StuInfoDto>();

		String query = "select max(stuNo)+1 as maxStuNo from student";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			StuInfoDto lecList = null;
			
			while(rs.next()) {
				lecList = new StuInfoDto();
				lecList.setStuNo(rs.getInt("maxStuNo"));
				list.add(lecList);
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
		
		return list;
	}
}