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
#sub21{
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
<!-- 
<table id="conTable">
<tr><td colspan="2" id="subject"><h1>수강생 등록</h1></td></tr>
	<tr>
		<th>강의명</th>
		<td>
			<select>
				<option>웹 개발자A</option>
				<option>웹 개발자B</option>
				<option>웹 개발자C</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>교육기간</th>
		<td>21.3.25~21.6.25</td>
	</tr>
	<tr>
		<th>강의장</th>
		<td>11</td>
	</tr>
	<tr>
		<td  colspan="2">수강생정보</td>
	</tr>
	<tr>
		<td>수강생 이름 : <input type="text" value="30"/></td>
		<td>전화 : <input type="text" value="30"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<button>확인</button>
			<button>취소</button>
		</td>
	</tr>
</table>
 -->
<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
      <input type="text" class="form-control" placeholder="Search for...">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
<%@ include file="/templates/footer.jspf" %>
</body>
</html>