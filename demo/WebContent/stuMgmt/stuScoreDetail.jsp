<%@page import="com.test.model.StuScoreDto"%>
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
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<script type="text/javascript">


</script>

</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<table id="conTable">
	<tr>
		<td colspan="2" id="subject">
			<h1>성적상세</h1>
		</td>
	</tr>
	<form action="${pageContext.request.contextPath}/stuMgmt/stuScoreUpdate.bit" method="post">
<%StuScoreDto bean=(StuScoreDto)request.getAttribute("detailScore");  %>
	<tr>
		<th>학번</th>
		<td><input type="text" id="" name="stuNo" value="<%=bean.getStuNo() %>" style=" height:21; border:1 solid red; font-size:15pt; text-align: center;"
			readonly="readonly"/></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" id="" name="stuName" value="<%=bean.getStuName() %>" style=" height:21; border:1 solid red; font-size:15pt; text-align: center;" 
			readonly="readonly"/></td>
	</tr>
	
	<tr>
		<th>JAVA</th>
		<td><input type="text" id="" name="java" value="<%=bean.getJava() %>" style=" height:21; border:1 solid red; font-size:15pt; text-align: center;"/></td>
	</tr>
	<tr>
		<th>WEB</th>
		<td><input type="text" id="" name="web" value="<%=bean.getWeb() %>" style=" height:21; border:1 solid red; font-size:15pt; text-align: center;"/></td>
	</tr>
	<tr>
		<th>Framework</th>
		<td><input type="text" id="" name="framework" value="<%=bean.getFramework() %>" style=" height:21; border:1 solid red; font-size:15pt; text-align: center;"/></td>
	</tr>
		
	<tr>
		<td colspan="2">
			<button type="submit">수정</button>
			<button type="button"><a href="${pageContext.request.contextPath}/stuMgmt/stuScoreDelete.bit">삭제</a></button>
			<button type="button"><a href="${pageContext.request.contextPath}/stuMgmt/stuScoreList.bit">목록</a></button>
		</td>
	</tr>
	</form>
</table>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>