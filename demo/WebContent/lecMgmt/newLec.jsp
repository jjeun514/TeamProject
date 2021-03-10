<%@page import="java.text.SimpleDateFormat, java.util.*, java.text.*"%>
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
#lecture,#classroom,#instructor{
	color: #c2c7cf;
	text-align: center;
}
input:hover{
	background-color: #f2f7ff;
	border: solid 1px darkblue;
}
input:click{
	background-color: #f2f7ff;
	color: black;
}
#msg1,#msg2,#msg3{
	color: red;
	font-size: 12px;
	text-align: left;
}
</style>
<link rel="stylesheet" type="text/css" href="../css/jquery.bxslider.css">
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../js/jquery.bxslider.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('span').hide();	// msg 숨긴 상태로 시작 
	$('form').submit(function(){
		// 값이 입력되지 않은채로 버튼을 누르는 경우 페이지가 넘어가지 않도록
		if($('input').val()=='')$('span').show();
		if($('input').val()!='')
		// 강의명
		if($('form input').eq(0).val()==''){
			$('#msg1').show();	// msg 출력
			$('form input').eq(0).focus();
			return false;
		}else{
			$('#msg1').hide();
		}
		// 강의장
		if($('form input').eq(3).val()==''){
			$('#msg2').show();	// msg 출력
			$('form input').eq(3).focus();
			return false;
		}else{
			$('#msg2').hide();
		}
		// 강사
		if($('form input').eq(4).val()==''){
			$('#msg3').show();	// msg 출력
			$('form input').eq(4).focus();
			return false;
		}else{
			$('#msg3').hide();
		}
	});
});
</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<%
/* 교육기간 시작일 선택 시, 수료일은 3개월 뒤로 자동 계산 */
Calendar cal=Calendar.getInstance();
cal.setTime(new Date());
DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
String start=df.format(cal.getTime());
cal.add(Calendar.MONTH,3);
String end=df.format(cal.getTime());
%>
<form action="newLec.jsp" method="post">
<table id="conTable">
<tr><td colspan="2" id="subject"><h1>강의 개설</h1></td></tr>
<!-- 강의장 이름, 강사 이름 input
	 강의 등록창에서 강의 생성 후 강의 목록창으로 넘어감 (버튼 클릭 시 lecList.jsp로 이동
	 *사용자가 입력해야하는 부분:
		1) 강의명 - input
		2) 교육기간 lecStartDate 선택 시 (3개월 뒤 lecFinishDate 자동) - date
		3) 강의장 - input
		4) 강사 - input
		5) 정원 - input (default 30)
	  -->
	<tr>
		<th>강의명</th>
		<td><input type="text" name="lecture" size=31 maxlength=50 id="lecture">
		<br><span id="msg1">※필수 - 강의명 입력(최대 50자)</span></td>
		<!-- lecName(varchar:50) - not null -->
	</tr>
	<tr>
		<th>교육기간</th>
		<td><input type="date" value="<%= start %>" name="startDate" id="startDate">
		~ <input type="date" value="<%= end %>" name="endDate" id="endDate"></td>
	</tr>
	<tr>
		<th>강의장</th>
		<!-- lecRoom(varchar:5) - not null -->
		<td><input type="text" name="classroom" size=31 maxlength=5 id="classroom">
		<br><span id="msg2">※필수 - 강의명 입력(최대 5자)</span></td>
	</tr>
	<tr>
		<th>강사</th>
		<!-- ename(varchar:15) - not null -->
		<td><input type="text" name="instructor" size=31 maxlength=15 id="instructor">
		<br><span id="msg3">※필수 - 강사명 입력</span></td>
	</tr>
	<tr>
		<th>정원</th>
		<td><input type="text" value="30" name="max" id="max">명</td>
	</tr>
	<tr>
		<td colspan="2">
			<button>등록</button>
			<button type="button">뒤로</button>
		</td>
	</tr>
</table>
</form>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>