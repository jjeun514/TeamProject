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
	
	// 강사 중복 제거 강의정보 불러오기(lecNo,ename
	public List<LecDto> selectIns() throws SQLException{
		List<LecDto> list=new ArrayList<LecDto>();
		// 강사 이름 중복 제거
		String sql="select lecture.lecNo, ename from lecture "
				+ "right outer join emp on lecture.empNo=emp.empNo "
				+ "where deptNo=3 group by ename";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LecDto bean = new LecDto();
				bean.setLecNo(rs.getInt("lecNo"));					// 강의번호
				bean.setEname(rs.getString("ename"));				// 강사
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
		System.out.println("[LecDao(selectIns)] list: "+list);
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


		//String sql="insert into lecture (lecName, lecStartDate, lecFinishDate, lecRoom, empNo) values (?,?,?,?,?)";
		String sql = "insert into lecture (lecName, lecStartDate, lecFinishDate, lecRoom, empNo, lecDays)";
		sql += " values (?,?,?,?,?,lecDays(str_to_date(?,'%Y-%m-%d'),str_to_date(?,'%Y-%m-%d')));";
		
		
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
			pstmt.setString(6, lecStartDate);
			pstmt.setString(7, lecFinishDate);
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
					+ "from lecture left outer join student on lecture.lecNo=student.lecNo "
					+ "where lecture.lecNo=?";
			
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, lecNo);
				System.out.println("[LecDao(cntStu)] lecNo: "+lecNo);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					bean.setLecNo(rs.getInt("lecNo"));
					bean.setTotalStu(rs.getInt("count(stuName)"));
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
		
		// 강의번호로 수강생 수 구하기
		public int stu(int lecNo) throws UnsupportedEncodingException {
			String sql="select count(stuName) from student where lecNo=?";
			int cnt=0;
			
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, lecNo);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					LecDto bean = new LecDto();
					cnt=bean.setEmpNo(rs.getInt("count(stuName)"));	// 수강생 수
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
			System.out.println("[LecDao(stu)] cnt: "+cnt);
			return cnt;
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
	
	// FK 삭제 가능하게 했다가 삭제 후, 다시 안되게 설정
	// 문제점: lecture는 삭제되지만, student는 fk인 lecNo를
	//		   그대로 갖고 있게 된다.
	public void fkSetting01() {
		String sql="SET foreign_key_checks = 0";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
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
		System.out.println("삭제 가능하도록!");
	}
	public void fkSetting02() {
		String sql="SET foreign_key_checks = 1";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
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
		System.out.println("삭제 불가능하도록!");
	}
/*	
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
*/
	// 삭제
	public void deleteOne(int lecNo) {
		/* 
		 * 일단 student의 모든 데이터가 나와야 하고,
		 * score와 attendance에서 없는 데이터는 null로 나오도록 select
		 * select * from student stu left outer join score sco on stu.stuNo=sco.stuNo left outer join attendance att on stu.stuNo=att.stuNo;
		 * 
		 * 여기서부터 순차적으로 쿼리 날리면 됨
		 * lecNo=? 인 하위 score, attendance의 데이터를 먼저 지우고
		 * delete sco, att from student stu left outer join score sco on stu.stuNo=sco.stuNo left outer join attendance att on stu.stuNo=att.stuNo where lecNo=?;
		 * 
		 * lecNo=? 인 student의 데이터를 지우고
		 * delete from student where lecNo=?
		 * 
		 * lecNo=? 인 lecture의 데이터를 지운다
		 * delete from lecture where lecNo=?
		 */
		String joinSql = "delete sco, att from student stu left outer join score sco on stu.stuNo=sco.stuNo left outer join attendance att on stu.stuNo=att.stuNo where lecNo=?";
		String student = "delete from student where lecNo=?";
		String lecture= "delete from lecture where lecNo=?";
				
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(joinSql);
			pstmt.setInt(1, lecNo);
			pstmt.executeUpdate();
				
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(student);
			pstmt.setInt(1, lecNo);
			pstmt.executeUpdate();
				
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(lecture);
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
