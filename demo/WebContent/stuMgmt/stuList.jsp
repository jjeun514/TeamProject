	<%@page import="com.test.model.StuScoreDto"%>
<%@page import="java.util.*, com.test.model.StuInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	
	<form action="${pageContext.request.contextPath }/stuMgmt/stuList.bit">
			<table id="topPart">
				<tr><td><select name="selectLec" onchange="this.form.submit();">
					<option>강의를 선택하시오</option>
				<%List<StuInfoDto> lecList = null;
					lecList = (List<StuInfoDto>)request.getAttribute("allLecList");
					if (lecList!=null){
						for(StuInfoDto bean : lecList) {
				%>
					<option value="<%=bean.getLecNo()%>"><%=bean.getLecName() %></option>
				<%}}%>
				</select>
					
				<button><a href="${pageContext.request.contextPath }/stuMgmt/newStuPage.bit" id="addBtn">수강생 등록</a></button></td></tr>
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
					List<StuInfoDto> stuList = null;
					stuList = (List<StuInfoDto>)request.getAttribute("selectStu");
					if ( stuList != null ) {
						for (StuInfoDto stuInfo : stuList){
							
					%>
						<tr>
							<td><a href = "stuDetail.bit?stuNo=<%=stuInfo.getStuNo() %>"><%=stuInfo.getStuNo() %></a></td>
							<td><a href = "stuDetail.bit?stuNo=<%=stuInfo.getStuNo() %>"><%=stuInfo.getStuName() %></a></td>
							<td><a href = "stuDetail.bit?stuNo=<%=stuInfo.getStuNo() %>"><%=stuInfo.getStuPhone() %></a></td>							
							<td><a href = "stuDetail.bit?stuNo=<%=stuInfo.getStuNo() %>"><%=stuInfo.getAttTotal() %>%</td>
							<td><a href = "stuDetail.bit?stuNo=<%=stuInfo.getStuNo() %>"><%=stuInfo.getJava() %></a></td>
							<td><a href = "stuDetail.bit?stuNo=<%=stuInfo.getStuNo() %>"><%=stuInfo.getWeb() %></a></td>
							<td><a href = "stuDetail.bit?stuNo=<%=stuInfo.getStuNo() %>"><%=stuInfo.getFramework() %></a></td>
						</tr>				
					<%}} %>
					</tbody>
					
				</table>
	</form>
	<%@ include file="../templates/footer.jspf" %>
	</body>
	</html>