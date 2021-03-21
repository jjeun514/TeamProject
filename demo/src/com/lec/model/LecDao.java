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
import javax.servlet.http.HttpServletRequest;
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
		/*
		 * No ① 무조건 1번으로 시작해서 row 수 카운트
		 * 	  ② lecNo로 DB에서 뽑아오기
		 * 
		 * No, 강의명, 강사, 강의장, 교육기간, 수강생
		 * 
		 * 교육기간: '시작일' 혹은 '시작일 ~ 종료일'
		 * 
		 *  (lecture) lecNo, lecName, lecStartDate, lecFinishDate, lecRoom
		 *  (emp)     ename -> empNo로 lecture테이블에서 강사와 특정 강의 연결
		 *  (student) lecNo로 학생목록 뽑아와서 count -> 해당 강의의 수강생 총원
		 *  
		 *  String sql = "select lecName, ename, lecRoom, lecStartDate from lecture lec ";
		 *  sql += "left outer join emp emp on lec.empNo=emp.empNo";
		 *  
		 *  학생 수는 lecNo로 lecture와 student 테이블을 연결해서 count
		 *  select count(*) from student where lecNo=?;
		 *  
		 *  학생 수까지 해서 3개의 table을 join...
		 *  select lecName, ename, lecRoom, lecStartDate, count(*)
			from lecture lec inner join emp emp on lec.empNo=emp.empNo
			inner join student stu on lec.lecNo=stu.lecNo where stu.lecNo=1;
			여기에서...stu.lecNo=? 해당 강의명의 lecNo를 넣어줘야함
		 */
		/*
		String sql = "select lecNo, lecName, ename, lecRoom, lecStartDate, count(*) ";
			   sql += "from lecture left outer join emp on lecture.empNo=emp.empNo ";
			   sql += "right outer join student on lecture.lecNo=student.lecNo where stu.lecNo=?";
		이렇게 하면 안됨 student count하는 부분은 테이블 조인하지 말고 따로 빼자 일단
	    */
		
		/* 강의번호, 강의명, 강사, 강의장, 시작일, 종강일 (lecture, emp)
		String sql="select lecNo, lecName, ename, lecRoom, lecStartDate, lecFinishDate "
				+ "from lecture left outer join emp on lecture.empNo=emp.empNo";
		*/
		/*
		 * 강의번호 별 학생 수 카운트
		 * select lecture.lecNo, count(*) from lecture left outer join student on lecture.lecNo=student.lecNo group by lecNo;
		 */

		// 특정 강의 수강생 수 (student) - 이건 따로 빼자
		String CntSql="select count(*) from student where lecNo=?";
		
		/*
		String sql="select lecture.lecNo, lecName, ename, lecRoom, lecStartDate, lecFinishDate, count(*) "
				 + "from lecture left outer join emp on lecture.empNo=emp.empNo "
				 + "right outer join student on lecture.lecNo=student.lecNo group by lecNo";
		*/
		String sql="select lecture.lecNo, lecName, ename, lecRoom, lecStartDate, lecFinishDate, count(stuName) "
				+ "from lecture left outer join emp on lecture.empNo=emp.empNo "
				+ "left outer join student on lecture.lecNo=student.lecNo group by lecNo";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 물음표에 lecNo를 넣게 되면, count함수이기 때문에, 특정 lecNo에 해당하는
			// 학생수를 count하는 것이 아니라, 전체 학생수를 count 해버림
			// lecName에 해당하는 lecNo를 뽑아서 넣어줘야함
			rs = pstmt.executeQuery();
			
			/* 강의번호는 sequence로
			 * 
			 * create sequence project.sq_lecNo
			 * start with 1
			 * increment by 1
			 * cycle;
			 * 
			 * 다음값 출력
			 * select nextval(project.sq_lecNo);
			 * 
			 * 그런데.. sequence로 하면 정확성에 문제가 생김
			 * 오류로 값이 안 들어가서 insert 쿼리문이 제대로 작동안하는 경우
			 * seq값이 건너뛰게 되는 경우도 생겼음
			 * 
			 * 그러면, sq보다는 int count=1; 을 선언 후 (max를 구해서)
			 * count++하는 식으로 부여하는 것이 더 정확할 것
			 * 
			 * 리스트에 출력할 때, 지난 강의는 강의목록에 보이지 않기로 했는데,
			 * 이 경우에는?
			 * 그냥 화면에 보이는 강의 목록만 가지고 1로 시작해서 보여주자.
			 * 이렇게 되면, count한거는 db에 저장하면 안되고,
			 * 일회성으로 화면에 출력해주는식으로 가야함
			 * 
			 * 그런데, 지난 강의가 count를 갖고 있는채로...리스트에서 사라진다면?........
			 * 만약에 7개의 강의 중에서 3번 강의가 사라졌어.. 그러면
			 * 4번 강의부터는 -1되야되는데 아 복잡
			 * 그냥 cnt하지말고 그냥 row를 카운트하면 안되나??? 근데 어떻게???
			 * 근데 어차피 지난 강의 지운거는 지금 구현안해도 되잖아 일단 패스
			 */
			
			while(rs.next()) {
				LecDto bean = new LecDto();
				bean.setLecNo(rs.getInt("lecNo"));			// 강의번호
				bean.setLecName(rs.getString("lecName"));	// 강의명
				bean.setEname(rs.getString("ename"));		// 강사
				bean.setLecRoom(rs.getString("lecRoom"));	// 강의장
				bean.setLecStartDate(rs.getString("lecStartDate"));	// 수강 시작일
				bean.setLecFinishDate(rs.getString("lecFinishDate"));	// 수강 종료일
				bean.setTotalStu(rs.getInt("count(stuName)"));	// 수강생 수
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
	
	// 강의별 수강생 총원...어떡하지???
	public List<LecDto> totalStu() throws SQLException{
		List<LecDto> list=new ArrayList<LecDto>();
		// 특정 강의 수강생 수 (student)
		String sql="select lecNo from lecture ";
		String sql2="select count(*) from student where lecNo=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				LecDto bean = new LecDto();
				bean.setTotalStu(rs.getInt("totalStu"));	// 총 수강생 수
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
				bean.setEname(rs.getString("ename"));		// 강사
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
		System.out.println("instructor:"+instructor);
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
				empNoList=bean.setEmpNo(rs.getInt("empNo"));		// 강사
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
		System.out.println("empNoList:"+empNoList);
		return empNoList;
	}
		
	// 추가
	public void insertOne(String lecName, String lecStartDate, String lecFinishDate, String lecRoom, String lecturer, int empNo) {
		String sql="insert into lecture (lecName, lecStartDate, lecFinishDate, lecRoom, empNo) values (?,?,?,?,?)";
		// 강사는 emp테이블에서 select 해오는 것이고,
		// lecture와 선택된 강사를 연결 시키려면 해당 강사의 empNo를 뽑아와서
		// lecture 테이블에 empNo를 같이 insert 해주어야함
		// 강의명(lecName), 교육기간(lecStartDate,lecFinishDate), 강의장(lecRoom), 강사(empNo)
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, lecName);
			pstmt.setString(2, lecStartDate);
			pstmt.setString(3, lecFinishDate);
			pstmt.setString(4, lecRoom);
			pstmt.setInt(5, empNo);
			System.out.println(sql);
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
		// 수강생 수 어떡하지...?
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lecNo);
			System.out.println("lecNo?"+lecNo);
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
			String sql="select lecture.lecNo, count(*) "
					+ "from lecture left outer join student on lecture.lecNo=student.lecNo where lecture.lecNo=?";
			
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, lecNo);
				System.out.println("lecNo?"+lecNo);
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