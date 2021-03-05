<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="login.bit" method="post">
		<div>
			<label>Id</label> <input type="text" name="sysId">
		</div>
		<div>
			<label>Password</label> <input type="password" name="sysPw">
		</div>
		<div>
			<button type="submit">입력</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>