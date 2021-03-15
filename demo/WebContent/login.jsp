
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--
 CSS: id/class명 변경 금지
  -->
<style rel="stylesheet" type="text/css">
/* 전체 */
* {
	margin: 0px auto auto auto;
	padding: 0px;
	background-color: #0083fe;
}
/* 배경 이미지 */
img {
	min-width: 300px;
	min-height: 500px;
	max-width: 100%;
	max-height: 570px;
	display: block;
}
/* 로그인, 아이디, 패스워드 font */
#btn, #id, #pw {
	font-family: '가나초콜릿', cursive;
}
/* 아이디, 패스워드 */
#id, #pw {
	text-align: center;
	font-weight: bold;
	color: white;
}
/* id, pw 입력창 */
#idInput, #pwInput {
	border-color: lightblue;
	border-left-color: darkblue;
	border-top-color: darkblue;
	background-color: white;
	opacity: 0.3;
	border: 2px solid white;
	border-radius: 5px;
}
/* 로그인 버튼 */
#btn {
	background-color: darkblue;
	border: 2px solid lightblue;
	border-radius: 10px 10px 10px 10px;
	color: white;
	font-weight: bold;
	padding: 15px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 18px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
<!--
 JS
  -->
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body>
	<form action="home.bit" method="post">
		<table>
			<!-- 배경 이미지 -->
			<tr>
				<img src="imgs/main.jpg" />
			</tr>
			<tr>
				<td id="id">아이디</td>
				<td><input type="text" name="idInput" id="idInput"></td>

				<td rowspan="2">
					<!-- 보통 button의 default type은 submit인데, 브라우저마다 다를 수 있어서 명시하는게 좋음 -->
					<button id="btn" type="submit">로그인</button>
				</td>
			</tr>
			<tr>
				<td id="pw">패스워드</td>
				<td><input type="password" name="pwInput" id="pwInput"></td>
			</tr>
			<tr>
				<td><a href="accFind.jsp">id/pw 찾기</a></td>
				<td><a href="accAdd.jsp">회원가입</a></td>
			</tr>
		</table>
	</form>
</body>
</html>