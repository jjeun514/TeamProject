<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="template/menu.jspf" %>
<h2>입력페이지</h2>
<form method="post">
	<div>
		<label>deptno</label>
		<input type="text" name="deptno">
	</div>
	<div>
		<label>dname</label>
		<input type="text" name="dname">
	</div>
	<div>
		<label>loc</label>
		<input type="text" name="loc">
	</div>
	<div>
		<button>입력</button>
	</div>
</form>
<%@ include file="template/footer.jspf" %>
</body>
</html>