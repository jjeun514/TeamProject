package com.test.model;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StuScoreDao {

	javax.sql.DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public StuScoreDao() {
		
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup(
									"java:/comp/env/jdbc/maria");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Integer> selectLecNo() {
		String sql="select lecNo from lecture order by lecNo";
		
		List<Integer> listA=new ArrayList<>();
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				listA.add(rs.getInt("lecNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(listA);
		return listA;
	}

	public List<StuScoreDto> selectAll(int lecNo) {
		String sql="select student.stuNo,stuName,java,web,framework "
				+ "from student left outer join score "
				+ "on student.stuNo=score.stuNo where lecNo=? order by student.stuNo";
		List<StuScoreDto> list=new ArrayList<StuScoreDto>();
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, lecNo);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				StuScoreDto bean=new StuScoreDto();
				bean.setStuNo(rs.getInt("stuNo"));
				bean.setStuName(rs.getString("stuName"));
				bean.setJava(rs.getInt("java"));
				bean.setWeb(rs.getInt("web"));
				bean.setFramework(rs.getInt("framework"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public StuScoreDto selectOne(int stuNo) {
		String sql="select student.stuNo,stuName,java,web,framework "
				+ "from student left outer join score "
				+ "on student.stuNo=score.stuNo where student.stuNo=?";
		
		StuScoreDto bean=new StuScoreDto();
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, stuNo);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean.setStuNo(rs.getInt("stuNo"));
				bean.setStuName(rs.getString("stuName"));
				bean.setJava(rs.getInt("java"));
				bean.setWeb(rs.getInt("web"));
				bean.setFramework(rs.getInt("framework"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return bean;
	}
	
	
	public void insertScore(int stuNo,int java,int web,int framework) {
		
		String sql="insert into score values(?,?,?,?)";
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, stuNo);
			pstmt.setInt(2, java);
			pstmt.setInt(3, web);
			pstmt.setInt(4, framework);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateScore(int stuNo,int java,int web,int framework) {
		
		String sql="update score set java=?,web=?,framework=? where stuNo=?";
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, java);
			pstmt.setInt(2, web);
			pstmt.setInt(3, framework);
			pstmt.setInt(4, stuNo);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
