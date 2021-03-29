package com.bit.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class AdDao {

	javax.sql.DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public AdDao() {
		
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup(
									"java:/comp/env/jdbc/maria");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<AdDto> selectAll(){
		String sql="select * from adlecture order by lecStartDate desc";
		
		List<AdDto> list=new ArrayList<>();
		
		
			try {
				conn=dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					AdDto bean =new AdDto();
					bean.setLecNo(rs.getInt("adLecNo"));
					bean.setLecName(rs.getString("lecName"));
					bean.setLecStartDate(rs.getDate("lecStartDate"));
					bean.setLecFinishDate(rs.getDate("lecFinishDate"));
					list.add(bean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		return list;
	}
	
	public AdDto selectOne(int lecNo) {
		String sql="select * from adlecture where adLecNo=?";
		
		AdDto bean=new AdDto();
		
		try {
			
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, lecNo);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean.setLecNo(rs.getInt("adLecNo"));
				bean.setLecName(rs.getString("lecName"));
				bean.setLecStartDate(rs.getDate("lecStartDate"));
				bean.setLecFinishDate(rs.getDate("lecFinishDate"));
			}
			
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
		
		
		return bean;
	}
	
	public void insertOne(String lecName,String lecStartDate,String lecFinishDate) {
		String sql="insert into adlecture (lecName,lecStartDate,lecFinishDate) values(?,?,?)";
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lecName);
			pstmt.setString(2, lecStartDate);
			pstmt.setString(3, lecFinishDate);
			pstmt.executeQuery();
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
	
	public void deleteOne(int adLecNo) {
		String sql="delete from adlecture where adLecNo=?";
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, adLecNo);
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
