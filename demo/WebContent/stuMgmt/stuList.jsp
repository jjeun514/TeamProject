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
	</style>
	</head>
	<body>
	<%@ include file="../templates/menu.jspf" %>
	<h1>＜ 수강생 목록 ＞</h1>
	<table id="topPart">
	<tr><td><select>
		<option>강의를 선택하시오</option>
		<option>웹 개발자 양성 A</option>
		<option>웹 개발자 양성 B</option>
		<option>웹 개발자 양성 C</option>
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
		<tr id="link">
			<td><a href="stuDetail.jsp">01</a></td>
			<td><a href="stuDetail.jsp">권태민</a></td>
			<td><a href="stuDetail.jsp">01046117304</a></td>
			<td><a href="stuDetail.jsp">50</a></td>
			<td><a href="stuDetail.jsp">85</a></td>
			<td><a href="stuDetail.jsp">99</a></td>
			<td><a href="stuDetail.jsp">100</a></td>
		</tr>
		
		<tr id="link">
			<td><a href="stuDetail.jsp">02</a></td>
			<td><a href="stuDetail.jsp">권태만</a></td>
			<td><a href="stuDetail.jsp">01046117306</a></td>
			<td><a href="stuDetail.jsp">100</a></td>
			<td><a href="stuDetail.jsp">90</a></td>
			<td><a href="stuDetail.jsp">88</a></td>
			<td><a href="stuDetail.jsp">58</a></td>
		</tr>
	</tbody>
	</table>
	<%@ include file="../templates/footer.jspf" %>
	</body>
	</html>