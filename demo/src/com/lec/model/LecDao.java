package com.bit.lec.model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LecDao {
	// DB 연결 
	DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	// 서버 context에 서버 정보 있음	
	public LecDao() {
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup("java:/comp/env/jdbc/maria");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 강의 목록
	public List<LecDto> lecList() throws SQLException{
		List<LecDto> list=new ArrayList<LecDto>();
		String sql="select lecture.lecNo, lecName, ename, lecRoom, lecStartDate, lecFinishDate, count(stuName) "
				+ "from lecture left outer join emp on lecture.empNo=emp.empNo "
				+ "left outer join student on lecture.lecNo=student.lecNo group by lecNo";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LecDto bean = new LecDto();
				bean.setLecNo(rs.getInt("lecNo"));					// 강의번호
				bean.setLecName(rs.getString("lecName"));			// 강의명
				bean.setEname(rs.getString("ename"));				// 강사
				bean.setLecRoom(rs.getString("lecRoom"));			// 강의장
				bean.setLecStartDate(rs.getString("lecStartDate"));	// 수강 시작일
				bean.setLecFinishDate(rs.getString("lecFinishDate"));	// 수강 종료일
				bean.setTotalStu(rs.getInt("count(stuName)"));		// 수강생 수
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("list:"+list);
		return list;
	}
	
	// 강사 목록
	public List<LecDto> lecturerList() throws SQLException{
		List<LecDto> instructor=new ArrayList<LecDto>();
		// emp직원 테이블에서 강사(deptNo=3) 이름만 빼오기
		String sql="select ename from emp where deptNo=3";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LecDto bean = new LecDto();
				bean.setEname(rs.getString("ename"));	// 강사
				instructor.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[LecDato(lecturerList)] instructor: "+instructor);
		return instructor;
	}

	// 강의개설 시 선택된 lecturer(강사명)를 통해서 empNo를 뽑아내야함 
	public int selectEmpNo(String lecturer) throws UnsupportedEncodingException {
		String empNoSql="select empNo from emp where ename=?";
		int empNoList=0;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(empNoSql);
			pstmt.setString(1, lecturer);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LecDto bean = new LecDto();
				empNoList=bean.setEmpNo(rs.getInt("empNo"));	// 강사
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[LecDao(selectEmpNo)] empNoList: "+empNoList);
		return empNoList;
	}
		
	// 추가
	public void insertOne(String lecName, String lecStartDate, String lecFinishDate, String lecRoom, String lecturer, int empNo) {
		String sql="insert into lecture (lecName, lecStartDate, lecFinishDate, lecRoom, empNo) values (?,?,?,?,?)";
		/* 강사는 emp테이블에서 select 해오는 것이고,
		   lecture와 선택된 강사를 연결 시키려면 해당 강사의 empNo를 뽑아와서
		   lecture 테이블에 empNo를 같이 insert 해주어야함
		   강의명(lecName), 교육기간(lecStartDate,lecFinishDate), 강의장(lecRoom), 강사(empNo) */
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, lecName);
			pstmt.setString(2, lecStartDate);
			pstmt.setString(3, lecFinishDate);
			pstmt.setString(4, lecRoom);
			pstmt.setInt(5, empNo);
			pstmt.executeQuery();
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
	}
	
	// Detail 페이지 (특정 lecNo 선택)
	public LecDto getOne(int lecNo) {
		LecDto bean=new LecDto();
		String sql="select lecNo, lecName, ename, lecRoom, lecStartDate, lecFinishDate "
				+ "from lecture left outer join emp on lecture.empNo=emp.empNo where lecture.lecNo=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lecNo);
			System.out.println("[LecDao(getOne)] lecNo: "+lecNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bean.setLecNo(rs.getInt("lecNo"));
				bean.setLecName(rs.getString("lecName"));
				bean.setEname(rs.getString("ename"));
				bean.setLecRoom(rs.getString("lecRoom"));
				bean.setLecStartDate(rs.getString("lecStartDate"));
				bean.setLecFinishDate(rs.getString("lecFinishDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	// Detail 페이지 (특정 lecNo 선택하면 그 강의 수강생 카운트)
		public LecDto cntStu(int lecNo) {
			LecDto bean=new LecDto();
			String sql="select lecture.lecNo, count(stuName) "
					+ "from lecture left outer join student on lecture.lecNo=student.lecNo group by lecNo "
					+ "where lecture.lecNo=?";
			
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, lecNo);
				System.out.println("[LecDao(cntStu)] lecNo: "+lecNo);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					bean.setLecNo(rs.getInt("lecNo"));
					bean.setTotalStu(rs.getInt("count(*)"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bean;
		}
	
	// 수정
	public int updateOne(int lecNo, String lecName, String lecturer, String lecRoom, String lecStartDate, String lecFinishDate, int empNo) {
		String sql="update lecture set lecName=?, lecRoom=?, lecStartDate=?, lecFinishDate=?, empNo=? where lecNo=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lecName);
			pstmt.setString(2, lecRoom);
			pstmt.setString(3, lecStartDate);
			pstmt.setString(4, lecFinishDate);
			pstmt.setInt(5, empNo);
			pstmt.setInt(6, lecNo);

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	// 삭제
	public void deleteOne(int lecNo) {
		String sql="delete from lecture where lecNo=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lecNo);
			pstmt.executeUpdate();
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
	}
}