<%@page import="com.test.model.StuInfoDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

<script type="text/javascript">

function lecChoice() {
	// alert("java scaript call");
	document.newStuFormName.action = "/demo/stuMgmt/selectLecForNew.bit";
	document.newStuFormName.submit();
}

function newStu() {
	document.newStuFormName.action = "/demo/stuMgmt/newStu.bit";
	document.newStuFormName.submit();
}

</script>

</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<form name = "newStuFormName">
	<table id="conTable">
	<tr><td colspan="2" id="subject"><h1>수강생 등록</h1></td></tr>
		<tr>
			<th>강의명</th>
			<td>
				<select name="selectLec" onchange="lecChoice()">
					<option>강의를 선택하시오</option>
				<%List<StuInfoDto> lecList = null;
					lecList = (List<StuInfoDto>)request.getAttribute("allLecList");
					if (lecList!=null){
						for(StuInfoDto bean : lecList) {
				%>
					<option value="<%=bean.getLecNo()%>"><%=bean.getLecName() %></option>
			<%}}%>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>교육기간</th>
			<%List<StuInfoDto> lecInfo = null;
			lecInfo = (List<StuInfoDto>)request.getAttribute("selectOneLec");
					if (lecInfo!=null){
						for(StuInfoDto oneLec : lecInfo) {
		%>
			<td><%=oneLec.getLecStartDate() %></td><td><%=oneLec.getLecFinishDate() %></td>
		</tr>
		<input type = "hidden" name = "lecNo" value = "<%=oneLec.getLecNo()%>"/>
		<!-- <tr>
			<th>강의장</th>
			<td></td>
		</tr> -->
					<%}}%>
		<tr>
			<td  colspan="2">수강생정보</td>
		</tr>

		<tr>
			<%List<StuInfoDto> stuNo = null;
			stuNo = (List<StuInfoDto>)request.getAttribute("maxStuNo");
			if (stuNo!=null){
				for(StuInfoDto No : stuNo) {
			%>
			<td>수강생 번호 : <input type = "text" name = "stuNo" value = "<%=No.getStuNo() %>" readonly = "readonly"/></td><%}} %>
			<td>수강생 이름 : <input type="text" name = "stuName"/></td>
			<td>전화 : <input type="text" name = "stuPhone"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type = "button" onclick = "newStu();" value = "등 록"/>
				<input type = "reset" value = "작성취소"/>
				<input type = "button" value = "뒤로" onclick="location.href='stuPage.bit'"/>
			</td>
		</tr>
		
	</table>
</form>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>