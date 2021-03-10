<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
#sub11{
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
</style>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<table id="conTable">
<tr><td colspan="2" id="subject"><h1>수강생 정보 수정</h1></td></tr>
	<tr>
		<th>이름</th>
		<td><input type="text" /></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>	
		<input type="text" />
		</td>
	</tr>
	<tr>
		<td colspan="2"> 이 밑으로 변경 불가</td>
		
	</tr>
	
	<tr>
		<th>강의명</th>
		<td>
			웹개발자B
		</td>
	</tr>
	<tr>
		<th>출석률</th>
		<td>50%</td>
	</tr>
	<tr>
		<td colspan="2"> 성적</td>
		
	</tr>
	<tr>
		<th>java</th>
		<td>55</td>
	</tr>
	<tr>
		<th>web</th>
		<td>99</td>
	</tr>
	<tr>
		<th>Framework</th>
		<td>100</td>
	</tr>
	<tr>
		<td colspan="2">
			<button>수정</button>
			<button>뒤로</button>
		</td>
	</tr>
</table>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>