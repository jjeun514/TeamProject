<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test page</h1>
	<% java.util.List list=(java.util.List)request.getAttribute("alist"); %>
	
	<%for(int i=0; i<list.size(); i++){ %>
	<p>bean </p>
	<%} %>
</body>
</html>