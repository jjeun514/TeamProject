<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style rel="stylesheet" type="text/css">
*{
	margin: 0px auto auto auto;
	padding: 0px;
	background-color: #0083fe;
}
img{
	min-width: 300px;
	min-height: 500px;
	max-width: 100%;
	max-height: 570px;
	display: block;
}
#login{
}
#btn,#id>p,#pw>p{
	font-family: '가나초콜릿', cursive;
}
#id,#pw{
	text-align: center;
	font-weight: bold;
	color: white;
}
#idInput,#pwInput{
	border-color: lightblue;
	border-left-color: darkblue;
	border-top-color: darkblue;
	background-color: white;
	opacity: 0.3;
	border: 2px solid white;
  	border-radius: 5px;
}
#btn{
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
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<table>
<div id="main">
	<tr>
		<img src="imgs/main.jpg">
	</tr>
</div>

<form action="home.jsp" method="post">
<div id="login">
	<tr>
		<td id="id">
			<p>아이디</p>
		</td>
		
		<td><input type="text" name= "id" id="idInput"></td>
		
		<td rowspan="2">
			<input id="btn" type="submit" value="로그인" onclick="login">
		</td>
	</tr>

	<tr>
		<td id="pw">
			<p>패스워드</p>
		</td>

		<td><input type="password" name= "pw" id="pwInput"></td>
	</tr>
</div>
</form>
</table>
</body>
</html>