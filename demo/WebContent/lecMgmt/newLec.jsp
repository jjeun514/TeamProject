<%@ page import="java.text.SimpleDateFormat, java.util.*, java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
#msg1,#msg2,#msg3,#msg4{
	color: red;
	font-size: 12px;
	text-align: left;
}
input{
	width: 300px;
	text-align: center;
}
#startDate,#endDate{
	width: 120px;
	text-align: center;
}
#instructor{
	color: black;
}
</style>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('span').hide();	// msg 숨긴 상태로 시작 
	$('form').submit(function(){
		// 값이 입력되지 않은채로 버튼을 누르는 경우 페이지가 넘어가지 않도록
		
		// 날짜 계산 (개강일이 종강일보다 늦을 수 없음)
		var startDate=$('#startDate').val();
		var startDateArr=startDate.split('-');
		var start=(startDateArr[0]+startDateArr[1]+startDateArr[2]);
		
		var endDate=$('#endDate').val();
		var endDateArr=endDate.split('-');
		var end=(endDateArr[0]+endDateArr[1]+endDateArr[2]);
		
		// 강의명
		if($('form input').eq(0).val()==''){
			$('#msg1').show();	// msg 출력
			// 강의장
			if($('form input').eq(3).val()==''){
				$('#msg2').show();	// msg 출력
				// 교육기간
				if(start>=end){
					$('#msg4').show();	// msg 출력
					return false;
				}else{
					$('#msg4').hide();
				}
				return false;
			}else{
				$('#msg2').hide();
				// 교육기간
				if(start>=end){
					$('#msg4').show();	// msg 출력
					return false;
				}else{
					$('#msg4').hide();
				}
			}
			return false;
		}else{
			$('#msg1').hide();
			// 강의장
			if($('form input').eq(3).val()==''){
				$('#msg2').show();	// msg 출력
				// 교육기간
				if(start>=end){
					$('#msg4').show();	// msg 출력
					return false;
				}else{
					$('#msg4').hide();
				}
				return false;
			}else{
				$('#msg2').hide();
				// 교육기간
				if(start>=end){
					$('#msg4').show();	// msg 출력
					return false;
				}else{
					$('#msg4').hide();
				}
			}
		}
	});
});
</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<%
// 강사의 deptNo=3
session.getAttribute("empNo");

/* 교육기간 시작일 선택 시, 종강일은 3개월 뒤로 자동 계산
   (시작일의 default는 오늘 날짜로 뜨도록 해놨음)*/
	Calendar cal=Calendar.getInstance();
	cal.setTime(new Date());
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	String start=df.format(cal.getTime());
	/* 종강일 3개월 뒤는 DB에서 계산하도록 함수 입력되어 있음
	date_add("2021-01-01",interval 91 day)
	          ──────────start date 으로 부터 91일 후
	*/
	cal.add(Calendar.MONTH,3);
	String end=df.format(cal.getTime());
%>
<form action="newLec.bit" method="post">
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
		<td><input type="text" name="lecture" size=31 maxlength=50 id="lecture" placeholder="강의명 입력(최대: 한글 16자, 영문 50자)">
		<br><span id="msg1">※필수 - 강의명 입력(최대: 한글 16자, 영문 50자)</span></td>
		<!-- lecName(varchar:50) - not null -->
	</tr>
	<tr>
		<th>교육기간</th>
		<td><input type="date" value="<%= start %>" name="startDate" id="startDate">
		~ <input type="date" value="<%= end %>" name="endDate" id="endDate">
		<br><span id="msg4">※개강일이 종강일보다 늦을 수 없습니다.</span></td>
	</tr>
	<tr>
		<th>강의장</th>
		<!-- lecRoom(varchar:5) - not null -->
		<td><input type="text" name="classroom" size=31 maxlength=5 id="classroom" placeholder="강의장 입력(최대: 영문 5자)">
		<br><span id="msg2">※필수 - 강의장 입력(최대: 영문 5자)</span></td>
	</tr>
	<tr>
		<th>강사</th>
		<!-- ename(varchar:15) - not null -->
		<td><select type="selectBox" name="instructor" id="instructor">
		<c:forEach items="${instructor }" var="bean">
			<option value="${bean.ename}">${bean.ename}</option>
		<br><span id="msg3">※필수 - 강사명 입력</span>
		
		</c:forEach></select></td>
	</tr>
	<tr>
		<th>정원</th>
		<td><input type="text" value="30" name="max" id="max">명</td>
	</tr>
	<tr>
		<td colspan="2">
			<button>등록</button>
			<button type="button" onclick="location='lecList.bit'">목록</button>
		</td>
	</tr>
</table>
</form>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>