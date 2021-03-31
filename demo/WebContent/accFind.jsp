<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>아이디 찾기</h2>
	<form action="accIdFind.bit" method="post">
		<table>
			<tr>
				<td><label>이름</label></td>
				<td><input type="text" id="ename" name="ename"></td>
			</tr>
			<tr>
				<td><label>사번</label></td>
				<td><input type="text" id="empNo" name="empNo" />
			</tr>
			<tr>
				<td><button type="submit" id="IdFind">확인</button></td>
				<td><button type="reset">취소</button></td>
			</tr>
		</table>
	</form>
	<h2>비밀번호 찾기</h2>
	<form action="accPwFind.bit" method="post">
		<table>
			<tr>
				<td><label>ID</label></td>
				<td><input type="text" id="sysId" name="sysId"></td>
			</tr>
			<tr>
				<td><label>사번</label></td>
				<td><input type="text" id="empNo" name="empNo" />
			</tr>
			<tr>
				<td><button type="submit">확인</button></td>
				<td><button type="reset">취소</button></td>
			</tr>
		</table>
	</form>
	<a href="/demo/login.jsp">로그인하러 가기</a>
</body>
</html>