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
	<table>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>nalja</th>
			<th>pay</th>
			<th>deptno</th>
		</tr>
		<c:forEach items="${list }" var="bean">
			<c:url var="detail" value="/detail.bit">
				<c:param name="idx" value="${bean.empno }"></c:param>
			</c:url>
		<tr>
			<td><a href="${detail }">${bean.empno }</a></td>
			<td><a href="${detail }">${bean.ename }</a></td>
			<td><a href="${detail }">${bean.nalja }</a></td>
			<td><a href="${detail }">${bean.pay }</a></td>
			<td><a href="${detail }">${bean.deptno }</a></td>
		</tr>
		</c:forEach>		
	</table>
</body>
</html>