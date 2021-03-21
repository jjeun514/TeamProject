<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.bit.lec.model.LecDto"%>
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
</style>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<%
	LecDto bean=(LecDto)request.getAttribute("bean");
%>
<form action="lecEdit.bit" method="post">
<table id="conTable">
<tr><td colspan="2" id="subject"><h1>강의 정보</h1></td></tr>
	<tr>
		<th>No</th>
		<td><%=bean.getLecNo() %></td>
	</tr>
	<tr>
		<th>강의명</th>
		<td><%=bean.getLecName() %></td>
	</tr>
	<tr>
		<th>강사</th>
		<td><%=bean.getEname() %></td>
	</tr>
	<tr>
		<th>강의장</th>
		<td>
		<div>
  			<p><%=bean.getLecRoom() %></p>
		</div>
		</td>
	</tr>
	<tr>
		<th>교육기간</th>
		<td><%=bean.getLecStartDate() %> ~ <%=bean.getLecFinishDate() %></td>
	</tr>
	<tr>
		<th>수강생</th>
		<td>명</td>
	</tr>
	<tr>
		<td colspan="2">
			<button><a href="${pageContext.request.contextPath }/lecEdit.bit?lecNo=<%=bean.getLecNo()%>">수정</a></button>
			<button type="button" onclick="location='lecDel.bit'">삭제</button>
			<button type="button" onclick="location='lecList.bit'">뒤로</button>
		</td>
	</tr>
</table>
</form>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>