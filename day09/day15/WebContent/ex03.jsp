<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 활용</h1>
	<%
	//el의 scope 우선순위
	// page	> request > session > application 
	String msg1="ex03 page";
	pageContext.setAttribute("msg1", msg1);
	%>
	<p>page:<%=pageContext.getAttribute("msg1") %></p>
	<p>request:<%=request.getAttribute("msg1") %></p>
	<p>session:<%=session.getAttribute("msg1") %></p>
	<p>application:<%=application.getAttribute("msg1") %></p>
	<p>el:${msg1 }</p>
	<p>el:${pageScope.msg1 }</p>
	<p>el:${requestScope.msg1 }</p>
	<p>el:${sessionScope.msg1 }</p>
	<p>el:${applicationScope.msg1 }</p>
	<p></p>
	<p></p>
</body>
</html>








