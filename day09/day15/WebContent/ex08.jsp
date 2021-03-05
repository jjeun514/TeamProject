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
	<h1>JSTL 제어문</h1>
	<h2>조건문</h2>
	<h3>if문</h3>
	<c:set var="su1" value="10"></c:set>
	<c:set var="su2" value="2"></c:set>
	
	<p>
		<c:out value="${su1 }"></c:out>
		>
		<c:out value="${su2 }"></c:out>
		=
		<c:if test="${su1 ge su2 }">
			<c:if test="${su1 eq su2 }">
				같거나
			</c:if>
			크다
		</c:if>
		<c:if test="${su1 lt su2 }">
			작다
		</c:if>
	</p>
	<h3>choose문</h3>
	<p>
		<c:choose>
			<c:when test="${su1 eq 0 }">su1=0</c:when>
			<c:when test="${su1 eq 1 }">su1=1</c:when>
			<c:when test="${su1 eq 2 }">su1=2</c:when>
			<c:when test="${su1 eq 3 }">su1=3</c:when>
			<c:otherwise>
				몰라
			</c:otherwise>
		</c:choose>
	</p>
</body>
</html>






