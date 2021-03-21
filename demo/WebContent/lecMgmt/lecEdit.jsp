<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.bit.lec.model.LecDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style rel="stylesheet" type="text/css">
#contents{
	text-align: center;
	line-height: 50px;
}
#sub12{
	background-color: white;
	border-right: solid 3px darkblue;
	color: #103163;
}
#subject{
	line-height: 100px;
}
#conTable{
	min-width: 60%;
	width: 100px;
	border: solid 1px lightgray;
	min-height: 80%;
	height: 500px;
}
#conTable tr{
	min-width: 200px;
	width: 200px;
}
#conTable th{
	margin-left: 10px;
	min-width: 90px;
	width: 90px;
	display: inline-block;
	box-shadow: inset 0 -40px 0 #e6eefa;
}
#contents td{
	min-width: 350px;
	width: 350px;
	margin-left: -60px;
	width: 500px;
}
#max{
	text-align: center;
	width: 50px;
}
button{
	width: 100px;
	border-radius: 10px;
	margin-right: 20px;
	margin-left: 20px;
}
#L1,#L2,#L3{
	margin-right: 20px;
	margin-left: 20px;
}
a,a:active,a:visited{
	text-decoration: none;
	color: black;
}
a:hover,button:hover{
	color: blue;
	cursor: pointer;
}
input{
	text-align: center;
}
#lecNo{
	border: none;
}
#lecStartDate,#lecFinishDate{
	width: 80px;
}
</style>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<%
	LecDto bean=(LecDto)request.getAttribute("bean");
	request.setCharacterEncoding("utf-8");
%>
<form action="lecEdit.bit" method="post">
<table id="conTable">
<tr><td colspan="2" id="subject"><h1>강의 정보</h1></td></tr>
	<tr>
		<th>No</th>
		<td><input type="text" value="${bean.lecNo }" name="lecNo" id="lecNo" readonly="readonly"></td>
	</tr>
	<tr>
		<th>강의명</th>
		<td><input type="text" value="${bean.lecName }"name="lecName" id="lecName"></td>
	</tr>
	<tr>
		<th>강사</th>
		<td><select type="selectBox" name="lecturer" id="lecturer">
		<c:forEach items="${lecturer }" var="name">
			<option selected="${bean.ename}">${name.ename}</option>
		</c:forEach></select></td>
	</tr>
	<tr>
		<th>강의장</th>
		<td>
		<div>
  			<p><input type="text" value="${bean.lecRoom }"name="lecRoom" id="lecRoom"></p>
		</div>
		</td>
	</tr>
	<tr>
		<th>교육기간</th>
		<td><input type="text" value="${bean.lecStartDate }"name="lecStartDate" id="lecStartDate"> ~ <input type="text" value="${bean.lecFinishDate }"name="lecFinishDate" id="lecFinishDate"></td>
	</tr>
	<tr>
		<th>수강생</th>
		<td>명</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="submit" onclick="location='lecEdit.bit?lecNo=${bean.lecNo}'">수정</button>
			<button type="button" onclick="location='lecDetail.bit'">취소</button>
		</td>
	</tr>
</table>
</form>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>