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
<script type="text/javascript">
$(function(){
	$(document.getElementById('editBtn')).click(function(){
		$(document.getElementById('title')).html('<h4>강의 수정페이지</h4>');
		$("[readonly=readonly]").not(':eq(0)').not(':eq(6)').removeProp('readonly');
		$(document.getElementById('lecName')).css('border','black 1px solid');
		$(document.getElementById('lecturer')).css('border','black 1px solid');
		$(document.getElementById('lecRoom')).css('border','black 1px solid');
		$(document.getElementById('lecStartDate')).css('border','black 1px solid');
		$(document.getElementById('lecFinishDate')).css('border','black 1px solid');
		// 강사는 text input에서 select로 바뀌고 전체 강사 중 선택할 수 있도록 함
		$(document.getElementById('lecturer')).replaceWith(
			'<select name="lecturer" id="lecturer">'+
				'<c:forEach items="${name }" var="name">'+
				'<c:if test="${bean.ename eq name.ename }">'+
				'<option value="${name.lecNo }" selected="selected">${name.ename }</option>'+
				'</c:if>'+
				'<c:if test="${bean.ename ne name.ename }">'+
				'<option value="${name.lecNo }">${name.ename }</option>'+
				'</c:if>'+
				'</c:forEach>'+
			'</select>');
		$(document.getElementById('editBtn')).replaceWith(
				'<button id="btn" type="submit" onclick="location='+
				'lecEdit.bit?lecNo=${bean.lecNo}'+'">확인</button>'		
			);
		return false;
	});
});
</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<%
	LecDto bean=(LecDto)request.getAttribute("bean");

	String lecturer=request.getParameter("lecturer");
	request.setAttribute("lecturer", lecturer);
	
	LecDto bean2=(LecDto)request.getAttribute("cnt");
	String totalStu=request.getParameter("count(stuName)");
	request.setAttribute("count", totalStu);
%>
<table id="conTable">
<tr><td colspan="2" id="subject"><h1 id="title">강의 상세페이지</h1></td></tr>
<form action="lecEdit.bit" method="post">
	<tr>
		<th>No</th>
		<td><input type="text" value="${bean.lecNo }" name="lecNo" id="lecNo" readonly="readonly"></td>
	</tr>
	<tr>
		<th>강의명</th>
		<td><input type="text" value="${bean.lecName }"name="lecName" id="lecName" readonly="readonly"></td>
	</tr>
	<tr>
		<th>강사</th>
		<td><input type="text" value="${bean.ename }"name="lecturer" id="lecturer" readonly="readonly"></td>
	</tr>
	<tr>
		<th>강의장</th>
		<td>
		<div>
  			<p><input type="text" value="${bean.lecRoom }"name="lecRoom" id="lecRoom" readonly="readonly"></p>
		</div>
		</td>
	</tr>
	<tr>
		<th>교육기간</th>
		<td><input type="date" value="${bean.lecStartDate }"name="lecStartDate" id="lecStartDate" readonly="readonly"> ~ <input type="date" value="${bean.lecFinishDate }"name="lecFinishDate" id="lecFinishDate" readonly="readonly"></td>
	</tr>
	<tr>
		<th>수강생</th>
		<td><input type="text" value="${cnt.totalStu }"name="totalStu" id="totalStu" readonly="readonly" disabled="disabled">명</td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="editBtn">수정</button>
</form>
			<button type="button" onclick="location='lecDel.bit?lecNo=${bean.lecNo}'">삭제</button>
			<button type="button" onclick="location='lecList.bit'">뒤로</button>
		</td>
	</tr>
</table>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>