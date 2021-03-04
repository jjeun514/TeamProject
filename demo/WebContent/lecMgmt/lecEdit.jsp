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
<tr><td colspan="2" id="subject"><h1>강의 정보 수정</h1></td></tr>
	<tr>
		<th>강의명</th>
		<td><input type="text" name= "lecture" id="lecture"></td>
	</tr>
	<tr>
		<th>교육기간</th>
		<td><input type="date" value="2022-01-01" name= "date" id="date">
		~ <input type="date" value="2022-01-01" name= "date" id="date"></td>
	</tr>
	<tr>
		<th>강의장</th>
		<td>
		<div>
  			<input type="radio" id="L1" name="classroom" value="L1"
        	 checked>
 			<label for="L1">L1</label>
 			<input type="radio" id="L2" name="classroom" value="L2">
 			<label for="L2">L2</label>
  			<input type="radio" id="L3" name="classroom" value="L3">
  			<label for="L3">L3</label>
		</div>
		</td>
	</tr>
	<tr>
		<th>강사</th>
		<td><select>
		<option>엄진영</option>
		<option>이현주</option>
		<option>임경균</option>
		</select></td>
	</tr>
	<tr>
		<th>정원</th>
		<td><input type="text" value="30" name= "max" id="max">명</td>
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