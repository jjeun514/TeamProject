<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMAT JSTL</h1>
	<jsp:useBean id="nalja" class="java.util.Date"></jsp:useBean>
	
	<p><fmt:formatDate value="${nalja }" pattern="yyyy/MM/dd hh:mm:ss"/> </p>
	
	<c:set value="12000000" var="my"></c:set>
	<p><fmt:formatNumber value="${my }" pattern="###,###,###.00"></fmt:formatNumber></p>
	
</body>
</html>











