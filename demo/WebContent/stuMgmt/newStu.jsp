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


</script>

</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<form action="${pageContext.request.contextPath }/stuMgmt/newStu.bit">
	<table id="conTable">
	<tr><td colspan="2" id="subject"><h1>수강생 등록</h1></td></tr>
		<tr>
			<th>강의명</th>
			<td>
				<select name="lecNo"">
					<option>강의를 선택하시오</option>
				<%List<StuInfoDto> lecList = null;
					lecList = (List<StuInfoDto>)request.getAttribute("lecNo");
					if (lecList!=null){
						for(StuInfoDto bean : lecList) {
				%>
					<option value="<%=bean.getLecNo()%>"><%=bean.getLecNo() %></option>
				<%}}%>

				</select>
			</td>
		</tr>
		<tr>
			<th>교육기간</th>
			<td>lecStartDate</td>불러와야 함<td>lecFinishDate</td>
		</tr>
		<tr>
			<th>강의장</th>
			<td>불러와야 함</td>
		</tr>
		<tr>
			<td  colspan="2">수강생정보</td>
		</tr>
		<tr>
			<td>수강생 번호 : <input type = "text" name = "stuNo" value = "번호"/></td>
			<td>수강생 이름 : <input type="text" name = "stuName"/></td><br/>
			<td>전화 : <input type="text" name = "stuPhone"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type = "submit">확인</button>
				<button type = "reset">취소</button>
			</td>
		</tr>
		
	</table>
</form>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>