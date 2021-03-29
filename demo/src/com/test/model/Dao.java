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
	PreparedStatement pstmt,pstmt1=null;
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
		String sql2="select deptno from emp where empno=?";
		List<Dto> list=new ArrayList<Dto>();

		System.out.println("param id : "+sysId);
		System.out.println("param pw : "+sysPw);

		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,sysId);
			pstmt.setString(2,sysPw);
			rs=pstmt.executeQuery();
			System.out.println("쿼리문을 확인하세요   "+sql);
			Dto bean=new Dto();

			if(rs.next()) {
				bean.setSysId(rs.getString("sysId"));
				bean.setSysPw(rs.getString("sysPw"));
				bean.setEmpNo(rs.getInt("empNo"));
				System.out.println("empNo 는??"+rs.getInt("empNo"));
				list.add(bean);
			}else {
				System.out.println("null을 리턴합니다");
				return null;
			}
			Dto a=list.get(0);
			
			pstmt1=conn.prepareStatement(sql2);
			pstmt1.setInt(1, a.getEmpNo());
			rs=pstmt1.executeQuery();
			
			if(rs.next()) {
				bean.setDeptno(rs.getInt("deptno"));
				System.out.println("로그인 시 deptno 담기 위해 "+bean);
				list.add(bean);
			}
			
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("list를 리턴합니다");
		return list;
	}

	// 로그인 시 아이디, 비밀번호 체크 메서드
	public int loginCheck(String id, String pw) {
		String dbPw="";   // DB에서 꺼낸 비밀번호 담고
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
					x=1;   // db와 같을 때
				}else {
					x=0;   // 다를 때
				}
			}else {
				x=-1;   // 해당 아이디가 없을 때
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

	public List<Dto> accAdd(String sysId, String sysPw, int empNo) {
		String sql="insert into account value(?,?,?)";
		List<Dto> list=new ArrayList<Dto>();
		List<Dto> error=new ArrayList<Dto>();

		System.out.println("param:"+sysId);
		System.out.println("param:"+sysPw);
		System.out.println("param"+empNo);

		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sysId);
			pstmt.setString(2, sysPw);
			pstmt.setInt(3, empNo);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				Dto bean=new Dto();
				bean.setSysId(rs.getString(1));
				bean.setSysPw(rs.getString(2));
				bean.setEmpNo(rs.getInt(3));

				list.add(bean);
			}


		} catch (SQLException e) {
			e.printStackTrace();
			
			//System.out.println("sql 익셉션이 일어날 경우");
			//return error;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}
	
	public int accAddCheck(String sysId) {
		String sql="select * from account where sysID=?";

		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,sysId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}else {
				return 0;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int empNoCheck(String empNo) {
		String sql="select * from account where empNo=?";

		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,empNo);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}else {
				return 0;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int empNoCheck2(String empNo) {
		String sql="select * from emp where empNo=?";

		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,empNo);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}else {
				return 0;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}