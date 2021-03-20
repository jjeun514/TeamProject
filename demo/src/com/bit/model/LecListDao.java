package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LecListDao {
	// DB 연결 ① - dataSource 
	DataSource dataSource;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public LecListDao() {
		try {
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource)initCon.lookup("java:/comp/env/jdbc/maria");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// DB 연결 ② - driver
	String driver;
	String url="jdbc:mariadb://localhost:3306/xe";
	String user="scott";
	String password="tiger";
	
	public LecListDao(String driver, String url) {
		this.driver = driver;
		this.url = url;
	}


	// 강의 목록
	public List<LecListDto> lecList(int lecNo) {
		List<LecListDto> list=new ArrayList<LecListDto>();
		/*
		 * 첫 번째 no 컬럼은 1부터 순서대로
		 * 강의명, 강사, 강의장, 교육기간, 수강생
		 * 교육기간은 '시작일' 혹은 '시작일 ~ 종료일'로
		 * 
		 *  (lecture) lecName, lecStartDate, lecFinishDate, lecRoom,
		 *  (emp)     ename -> empNo로 lecture테이블에서 강사와 특정 강의 연결
		 *  (student) lecNo로 학생목록 뽑아와서 count -> 해당 강의의 수강생 총원
		 *  
		String query = "select lecName, ename, lecRoom, lecStartDate from lecture lec ";
		query += "left outer join emp emp on lec.empNo=emp.empNo";
		
		 *  학생 수는 lecNo로 lecture와 student 테이블을 연결해서 count
		 *  select count(*) from student where lecNo=?;
		 *  
		 *  학생 수까지 해서 3개의 table을 join...
		 *  select lecName, ename, lecRoom, lecStartDate, count(*)
			from lecture lec inner join emp emp on lec.empNo=emp.empNo
			inner join student stu on lec.lecNo=stu.lecNo where stu.lecNo=1;
			여기에서...stu.lecNo=? 해당 강의명의 lecNo를 넣어줘야함
		 */
		
		String query = "select lecName, ename, lecRoom, lecStartDate, count(*) ";
		query += "from lecture lec inner join emp emp on lec.empNo=emp.empNo";
		query += "inner join student stu on lec.lecNo=stu.lecNo where stu.lecNo=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			// 물음표에 lecNo를 넣게 되면, count함수이기 때문에, 특정 lecNo에 해당하는
			// 학생수를 count하는 것이 아니라, 전체 학생수를 count 해버림
			// lecName에 해당하는 lecNo를 뽑아서 넣어줘야함
			pstmt.setInt(1, lecNo);
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
			
			LecListDto LecList = null;
			while(rs.next()) {
				LecList = new LecListDto();
				// Count의 경우 DB에서 꺼내오는게 아니니까 여기 포함 안되겠지?
				// 출력페이지에서 따로 작성해주면 될 듯
				LecList.setLecName(rs.getString("lecName"));	// 강의명
				LecList.setEname(rs.getString("ename"));		// 강사
				LecList.setLecRoom(rs.getString("lecRoom"));	// 강의장
				LecList.setLecStartDate(rs.getDate("lecStartDate"));	// 수강 시작일
				LecList.setLecFinishDate(rs.getDate("lecFinishDate"));	// 수강 종료일
				// 수강생 수는... 여기서 뭘 어떻게 해야할지 모르겠다...
				list.add(LecList);
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
		return list;
	}

	// 추가
	public void insertOne(String lecStartDate, String lecRoom, String lecturer) {
		String sql="insert into lecture values (?,?,?)";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lecStartDate);
			pstmt.setString(2, lecRoom);
			pstmt.setString(3, lecturer);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	
	public List<LecListDto> selectAll() {
		String query = "select lecName, ename, lecRoom, lecStartDate, count(*) ";
			   query += "from lecture left outer join emp on lecture.empNo=emp.empNo ";
			   query += "right outer join student on lecture.lecNo=student.lecNo where stu.lecNo=?";
		List<LecListDto> list=new ArrayList<LecListDto>();
		return list;
	}
}