<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>etc jstl</h1>
	<h2>반복</h2>
	<c:set var="msgs">java,db,html,servlet,spring</c:set>
	
	<%
	String msgs2="java,db,html,,servlet,spring";
	String[] msg3=msgs2.split(",");
	for(String msg:msg3)
		System.out.println(msg);
	System.out.println("--------------------------");
	StringTokenizer token=new StringTokenizer(msgs2,",");
	while(token.hasMoreTokens())
		System.out.println(token.nextToken());
	
	%>
	
	<ul>
		<c:forTokens items="${msgs }" delims="," var="msg">
		<li>${msg }</li>
		</c:forTokens>
	</ul>
</body>
</html>











