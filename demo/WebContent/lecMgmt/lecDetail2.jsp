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
input{
	text-align: center;
	text-decoration: none;
	border: none;
}
#lecStartDate,#lecFinishDate{
	width: 120px;
}
#totalStu{
	background-color: white;
}
</style>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<%
//권한 체크
int deptNo=(Integer) session.getAttribute("deptno");
System.out.println("[lecDetail.jsp] dpetno: "+deptNo);
/*
	강의 수정: 행정만 권한 있음
	deptno: 영업 1, 행정 2, 강사 3
*/
%>
<script type="text/javascript">
$(function(){
	$(document.getElementById('eBtn')).click(function(){
		var deptNo='<%=deptNo%>';
		console.log(deptNo);
		if(deptNo!=2){
			alert('권한이 없습니다.');
		   	location.href='javascript:history.back()';
		}
	});
	$(document.getElementById('dBtn')).click(function(){
		var deptNo='<%=deptNo%>';
		console.log(deptNo);
		if(deptNo!=2){
			alert('권한이 없습니다.');
		   	location.href='javascript:history.back()';
		}
	});
});
</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<%	System.out.println("lecDetail2.jsp");
	LecDto bean=(LecDto)request.getAttribute("bean");
	int No=Integer.parseInt(request.getParameter("lecNo"));
		No=Integer.parseInt(request.getParameter("lecNo"));
	String lecName=request.getParameter("lecName");
	String lecStartDate=request.getParameter("lecStartDate");
	String lecFinishDate=request.getParameter("lecFinishDate");
	String lecRoom=request.getParameter("lecRoom");
	String lecturer=request.getParameter("lecturer");
	
	String totalStu=request.getParameter("count(stuName)");
	request.setAttribute("count", totalStu);
	
	Object cnt=request.getAttribute("totalStu");
	System.out.println("(detail2)cnt: "+cnt);
%>
<table id="conTable">
<tr><td colspan="2" id="subject"><h1>강의 상세페이지</h1></td></tr>
	<tr>
		<th>No</th>
		<td><input type="text" value="<%=No %>" name="lecNo" id="lecNo" readonly="readonly"></td>
	</tr>
	<tr>
		<th>강의명</th>
		<td><input type="text" value="<%=lecName %>"name="lecName" id="lecName" readonly="readonly"></td>
	</tr>
	<tr>
		<th>강사</th>
		<td><input type="text" value="<%=lecturer %>"name="lecturer" id="lecturer" readonly="readonly"></td>
	</tr>
	<tr>
		<th>강의장</th>
		<td>
		<div>
  			<p><input type="text" value="<%=lecRoom %>"name="lecRoom" id="lecRoom" readonly="readonly"></p>
		</div>
		</td>
	</tr>
	<tr>
		<th>교육기간</th>
		<td><input type="text" value="<%=lecStartDate %>"name="lecStartDate" id="lecStartDate" readonly="readonly"> ~ <input type="text" value="<%=lecFinishDate %>"name="lecFinishDate" id="lecFinishDate" readonly="readonly"></td>
	</tr>
	<tr>
		<th>수강생</th>
		<td><input type="text" value="<%=cnt%>"name="totalStu" id="totalStu" readonly="readonly" disabled="disabled">명</td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="eBtn" type="button" onclick="location='lecDetail.bit?lecNo=<%=No %>'">수정</button>
			<button id="dBtn" type="button" onclick="location='lecDel.bit?lecNo=<%=No %>'">삭제</button>
			<button type="button" onclick="location='lecList.bit'">뒤로</button>
		</td>
	</tr>
</table>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>