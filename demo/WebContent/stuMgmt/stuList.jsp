	<%@page import="java.util.*,com.bit.model.StuInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style rel="stylesheet" type="text/css">
		#sub21{
			background-color: white;
			border-right: solid 3px darkblue;
			color: #103163;
		}
		#topPart{
			width: 80%;
			height: 50px;
			margin: auto;
			text-align: right;
		}
		#addBtn,#addBtn:hover,#addBtn:active,#addBtn:visited{
			text-decoration: none;
			cursor: pointer;
			color: black;
		}
		#stuTable{
			width: 80%;
			margin: auto;
			text-align: center;
		}
		#stuTable th{
			background-color: #8b8bb5;
			color: white;
		}
		#stuTable,#stuTable th,#stuTable td{
			border: solid 1px black;
		}
		#stuTable a{
			/*셀 전체에 링크 걸리도록*/
			display: block;
			width: 100%;
			height: 100%;
			
			text-decoration: none;
			color: black;
		}
		/*링크에 마우스 올렸을 때*/
		#stuTable #link:hover{
			color: blue;
			background-color: #f5f5ff;
			cursor: pointer;
		}
		h1{
			text-align: center;
		}
		
		h3{
			text-align: center;
		}
	</style>
	
	<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	
	</script>
	
	</head>
	<body>
	<%@ include file="../templates/menu.jspf" %>
	<h1>＜ 수강생 목록 ＞</h1>
	<h3>강의명</h3>
	<h3>To Do : 항목별 앵커태그, 강의 동적 처리, 출석률 계산, 수강생 등록, 수강생 개별 정보</h3>
	<form action="/stuList.bit" method="post">
		<table id="topPart">
			
			<tr><td><select name="selectLec" onchange="this.form.submit();">
				<option>강의를 선택하시오</option>
				<option value="1">웹 개발자 양성 A</option>
				<option value="2">웹 개발자 양성 B</option>
				<option value="3">웹 개발자 양성 C</option>
			</select>
			<button><a href="newStu.jsp" id="addBtn">수강생 등록</a></button></td></tr>
			</table>
			
			<table id="stuTable">
			<thead>
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>출석률</th>
					<th>자바</th>
					<th>웹</th>
					<th>프레임워크</th>
				</tr>
			</thead>
			
			<tbody>
			<%
			List<StuInfoDto> list = null;
			list = (List<StuInfoDto>)request.getAttribute("selectLec");
			if ( list != null ) {
				for (StuInfoDto stuInfo: list){
			%>
				<tr>
					<td><a href = "stuDetail.jsp?deptno=<%=stuInfo.getStuNo() %>"><%=stuInfo.getStuNo() %></a></td>
					<td><a href = "stuDetail.jsp?deptno=<%=stuInfo.getStuNo() %>"><%=stuInfo.getStuName() %></a></td>
					<td><a href = "stuDetail.jsp?deptno=<%=stuInfo.getStuNo() %>"><%=stuInfo.getStuPhone() %></a></td>
					<td>출석률</td>
					<td><a href = "stuDetail.jsp?deptno=<%=stuInfo.getStuNo() %>"><%=stuInfo.getJava() %></a></td>
					<td><a href = "stuDetail.jsp?deptno=<%=stuInfo.getStuNo() %>"><%=stuInfo.getWeb() %></a></td>
					<td><a href = "stuDetail.jsp?deptno=<%=stuInfo.getStuNo() %>"><%=stuInfo.getFramework() %></a></td>
				</tr>				
			<%}} %>
			</tbody>
			
		</table>
	</form>
	<%@ include file="../templates/footer.jspf" %>
	</body>
	</html>