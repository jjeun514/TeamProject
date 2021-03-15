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
	<h2>환영합니다!</h2>
	<p><%//="'"+session.getAttribute("signedUser")+"' " %>님으로 로그인되었습니다.</p>
	<%@ include file="templates/footer.jspf" %>
	</body>
	</html>