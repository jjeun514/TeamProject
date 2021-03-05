package com.bit.dept.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {
	String driver;//"org.mariadb.jdbc.Driver";
	String url;//"jdbc:mysql://localhost:3306/xe";
	String user="scott";
	String password="tiger";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DeptDao(String driver,String url) {
		this.driver=driver;
		this.url=url;
	}
	
	public void insertOne(int deptno,String dname,String loc) {
		String sql="insert into dept values (?,?,?)";

		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
	
	
	public List<DeptDto> selectAll(){
		String sql="select * from dept";
		List<DeptDto> list;
		list=new ArrayList<DeptDto>();

		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DeptDto bean=new DeptDto();
				bean.setDeptno(rs.getInt("deptno"));
				bean.setDname(rs.getString("dname"));
				bean.setLoc(rs.getString("loc"));
				list.add(bean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}