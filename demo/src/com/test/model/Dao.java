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

public class Dao {
	javax.sql.DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public Dao() {
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup(
									"java:/comp/env/jdbc/maria");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Dto> login(String sysId, String sysPw) {
		String sql="select * from account where sysId=? and sysPw=?";
		List<Dto> list=new ArrayList<Dto>();
		
		System.out.println("param:"+sysId);
		System.out.println("param:"+sysPw);
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,sysId);
			pstmt.setString(2,sysPw);
			rs=pstmt.executeQuery();
			System.out.println(sql);

			if(rs.next()) {
				Dto bean=new Dto();
				String a=rs.getString("sysId");
				String b=rs.getString("sysPw");
				System.out.println("a:"+a);
				System.out.println("b:"+b);
				bean.setSysId(a);
				bean.setSysPw(b);
				bean.setEmpNo(rs.getInt("empNo"));
				list.add(bean);
			}
			System.out.println(list);
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
	
	// 로그인 시 아이디, 비밀번호 체크 메서드
	public int loginCheck(String id, String pw) {
		String dbPw="";	// DB에서 꺼낸 비밀번호 담고
		int x=-1;
		
		// 사용자가 입력한 아이디로 DB에서 비밀번호 조회
		StringBuffer query=new StringBuffer();
		query.append("select sysPw from account where sysId=?");
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			// 사용자가 입력한 아이디의 비밀번호가 있을 경우
			if(rs.next()) {
				dbPw=rs.getString("pwInput");
				if(dbPw.equals(pw)) {
					x=1;	// db와 같을 때
				}else {
					x=0;	// 다를 때
				}
			}else {
				x=-1;	// 해당 아이디가 없을 때
			}
			return x;
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
		return x;
	}
	
}