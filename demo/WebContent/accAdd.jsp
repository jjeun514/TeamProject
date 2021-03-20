<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function() {

		$("button").click(function() {
			alert();
		});

	});
</script>
</head>
<body>
	<h2>회원가입</h2>
	<!-- 일단 emp테이블에 입력되어있고, empno를 알려준 후 회원가입을 해야 하는지 -->
	<form action="accAdd.bit" method="post">
		<table>
			<tr>
				<td><label>id</label></td>
				<td><input type="text" id="sysId" name="sysId"></td>
				<td><button type="button">중복체크</button></td>
			</tr>
			<tr>
				<td><label>pw</label></td>
				<td><input type="text" id="sysPw" name="sysPw"/></td>
			</tr>
			<tr>
				<td><label>pw확인</label></td>
				<td><input type="text" id="sysPw" name="PwConform"/></td>
			</tr>
			<tr>
				<td><label>empNo</label></td>
				<td><input type="text" id="empNo" name="empNo"></td>
			</tr>
			<tr>
				<td><button type="submit">가입</button></td>
				<td><button type="reset">취소</button></td>
			</tr>
		</table>
	</form>
</body>
</html>