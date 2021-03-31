<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.bit.lec.model.LecDto,com.bit.lec.model.LecDao"%>
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
#cnt1,#cnt2{
	background-color: white;
}
</style>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<%
// 권한 체크
// deptno 1~3을 제외한 비로그인 유저는 Controller단에서 잡아내고
// 1~3 내 권한은 이 페이지에서 버튼단위로 나뉘기 때문에
// jquery로 잡아주기
int deptNo=(Integer) session.getAttribute("deptno");
System.out.println("[lecDetail.jsp] dpetno: "+deptNo);
/*
	강의 열람: 모두 권한
	강의 수정/삭제: 행정만 권한 있음
	deptno: 영업 1, 행정 2, 강사 3
*/
%>
<script type="text/javascript">
$(function(){
	$(document.getElementById('btn')).hide();
	var deptNo='<%=deptNo%>';
	console.log(deptNo);
	if(deptNo!=2){
		$('#editBtn').attr('disabled',true)
		$('#dBtn').attr('disabled',true)
	}
	$(document.getElementById('editBtn')).click(function(){
		$(document.getElementById('back')).replaceWith(
				'<button><a href="lecDetail.bit?lecNo=${bean.lecNo}">뒤로</a></button>'
		);
		if(deptNo==2){
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
					'<option value="${name.ename }" selected="selected">${name.ename }</option>'+
					'</c:if>'+
					'<c:if test="${bean.ename ne name.ename }">'+
					'<option value="${name.ename }">${name.ename }</option>'+
					'</c:if>'+
					'</c:forEach>'+
				'</select>');
			$(document.getElementById('btn')).show();
			$(document.getElementById('btn')).click(function(){
				$(document.getElementById('cnt1')).remove();
			});
			$(document.getElementById('editBtn')).hide();
			return false;
		} else{
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
		   	return false;
		}
	});
});
</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<%
	System.out.println("lecDetail.jsp");
	LecDto bean=(LecDto)request.getAttribute("bean");

	String lecturer=request.getParameter("lecturer");
	request.setAttribute("lecturer", lecturer);
	
	System.out.println("totalStu②"+request.getAttribute("totalStu"));
	Object cnt=request.getAttribute("totalStu");
	System.out.println("(detail1)cnt: "+cnt);
%>
<form id="fm" action="lecEdit.bit" method="post">
<table id="conTable">
<tr><td colspan="2" id="subject"><h1 id="title">강의 상세페이지</h1></td></tr>
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
		<td><input type="text" value="${bean.lecStartDate }"name="lecStartDate" id="lecStartDate" readonly="readonly"> ~ <input type="text" value="${bean.lecFinishDate }"name="lecFinishDate" id="lecFinishDate" readonly="readonly"></td>
	</tr>
	<tr>
		<th>수강생</th>
		<td><input id="cnt1" type="text" value="${totalStu.totalStu }"name="totalStu" readonly="readonly" disabled="disabled">명</td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="editBtn">수정</button>
			<button id="btn" type="submit" onclick="location='lecDetail.bit?lecNo=${bean.lecNo}'">확인</button>
			<button id="dBtn" type="button" onclick="location='lecDel.bit?lecNo=${bean.lecNo}'">삭제</button>
			<button id="back" type="button" onclick="location='lecList.bit'">뒤로</button>
		</td>
	</tr>
</table>
</form>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>