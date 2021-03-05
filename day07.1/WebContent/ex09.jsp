<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*" %>    
<%
ArrayList<HashMap> list=new ArrayList<HashMap>();

String url="jdbc:oracle:thin:@localhost:1521:xe";
String user="scott";
String password="tiger";
Class.forName("oracle.jdbc.OracleDriver");
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

try{
	conn=DriverManager.getConnection(url,user,password);
	pstmt=conn.prepareStatement("select * from dept");
	rs=pstmt.executeQuery();
	while(rs.next()){
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("deptno", rs.getString("deptno"));
		map.put("dname", rs.getString("dname"));
		map.put("loc", rs.getString("loc"));
		list.add(map);
	}
}finally{
	if(conn!=null)conn.close();
}
%>
<dept>
	<%
	for(HashMap<String, String> hmap:list ){
	%>
	<row>
	<deptno><%=hmap.get("deptno") %></deptno>
	<dname><%=hmap.get("dname") %></dname>
	<loc><%=hmap.get("loc") %></loc>
	</row>
	<%
	}
	%>
</dept>





