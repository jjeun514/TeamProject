package com.bit.emp.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.MariaDb;

public class EmpDao {
	
	public EmpDto2 selectOne(int empno) {
		String sql="select * from emp where empno=?";
		EmpDto2 bean=new EmpDto2();
		
		try {
			PreparedStatement pstmt=MariaDb
					.getConnection().prepareStatement(sql);
			pstmt.setInt(1, empno);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				bean.setDeptno(rs.getInt("deptno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(MariaDb.getConnection()!=null)
					MariaDb.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return bean;
	}
	
	public List<EmpDto2> selectAll(){
		String sql="select * from emp";
		List<EmpDto2> list=new ArrayList<EmpDto2>();
		
		try {
			PreparedStatement pstmt=MariaDb
						.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				EmpDto2 bean=new EmpDto2();
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				bean.setDeptno(rs.getInt("deptno"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(MariaDb.getConnection()!=null)
					MariaDb.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
