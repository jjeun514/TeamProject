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

public class StuAttDao {
	javax.sql.DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public StuAttDao() {
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup("java:/comp/env/jdbc/maria");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 수강생 목록
	public List<StuInfoDto> stuAttList(int lecNo) {
		List<StuInfoDto> list=new ArrayList<StuInfoDto>();
		
		String query = "select stu.stuNo, stu.stuName, stu.stuPhone, att.stuAtt, att.stuLate, att.stuAbsent, att.attTotal,";
		query += " lec.lecNo from student stu left outer join attendance att";
		query += " on stu.stuNo=att.stuNo left outer join lecture lec on stu.lecNo=lec.lecNo";
		query += " where stu.lecNo =? order by stu.lecNo,stu.stuNo;";
		System.out.println(query);
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, lecNo);
			rs = pstmt.executeQuery();
			
			StuInfoDto stuList = null;
			
			while(rs.next()) {
				stuList = new StuInfoDto();
				stuList.setStuNo(rs.getInt("stuNo"));
				stuList.setStuName(rs.getString("stuName"));
				stuList.setStuPhone(rs.getString("stuPhone"));
				stuList.setStuAtt(rs.getInt("stuAtt"));
				stuList.setStuLate(rs.getInt("stuLate"));
				stuList.setStuAbsent(rs.getInt("stuAbsent"));
				stuList.setAttTotal(rs.getInt("attTotal"));
				stuList.setLecNo(rs.getInt("lecNo"));
				list.add(stuList);
			}
			System.out.println("출석 리스트 add 후"+list.size());
			
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

		String query = "select lecNo, lecName from lecture order by lecNo";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			StuInfoDto lecList = null;
			
			while(rs.next()) {
				lecList = new StuInfoDto();
				lecList.setLecNo(rs.getInt("lecNo"));
				lecList.setLecName(rs.getString("lecName"));
				list.add(lecList);
			}
			System.out.println("강의 리스트 add 후 : "+list.size());
			
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