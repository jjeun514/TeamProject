	<%@ page import="com.test.model.Dto"%>
<%@page import="java.util.List"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<!--
 CSS: id/class명 변경 금지
  -->
	<style rel="stylesheet" type="text/css">
	#contents{
		text-align: center;
		line-height: 50px;
	}
	</style>
	
	</head>
	<body>
	<%@ include file="templates/menu.jspf" %>
	<%@ page import="java.util.ArrayList" %>
	<% 
	 List<Dto> a=(List<Dto>)request.getAttribute("list");
	session.setAttribute("list", a);
	Dto dto=a.get(0);
	
	%>
	<h2>환영합니다!</h2>
	<p><%="'"+dto.getSysId()+"' " %>님으로 로그인되었습니다.</p>
	<%@ include file="templates/footer.jspf" %>
	</body>
	</html>