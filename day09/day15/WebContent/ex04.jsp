<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg1="ex04 page";
	request.setAttribute("msg1", msg1);
	%>
	<jsp:forward page="ex03.jsp"></jsp:forward>
</body>
</html>