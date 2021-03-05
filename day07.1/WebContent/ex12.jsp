<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*, java.sql.*" %>    
	<%
	int deptno=Integer.parseInt(request.getParameter("deptno"));
	String dname=request.getParameter("dname");
	String loc=request.getParameter("loc");
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	String sql="insert into dept values (?,?,?)";
	System.out.println("deptno="+deptno);
	System.out.println("dname="+dname);
	System.out.println("loc="+loc);
	Class.forName(driver);
	Connection conn=null;
	PreparedStatement pstmt=null;
	try{
		conn=DriverManager.getConnection(url, user, password);
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, deptno);
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);
		pstmt.executeUpdate();
	}finally{
		if(conn!=null	)conn.close();
	}
	response.sendRedirect("ex10.html");
	
	%>
</body>
</html>