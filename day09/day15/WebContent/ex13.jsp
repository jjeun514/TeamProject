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
	<h1>etc jdtl</h1>
	<c:if test="${true }">
	<c:redirect url="ex12.jsp">
		<c:param name="id" value="admin"></c:param>
	</c:redirect>
	</c:if>
</body>
</html>