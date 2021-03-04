	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<!--
 CSS: id/class명 변경 금지
  -->	
	<style rel="stylesheet" type="text/css">
	#sub12{
		background-color: white;
		border-right: solid 3px darkblue;
		color: #103163;
	}
	#lecTable{
		width: 80%;
		margin: auto;
		text-align: center;
	}
	#lecTable th{
		background-color: #8b8bb5;
		color: white;
	}
	#lecTable,#lecTable th,#lecTable td{
		border: solid 1px black;
	}
	#lecTable a{
		/*셀 전체에 링크 걸리도록*/
		display: block;
		width: 100%;
		height: 100%;
		
		text-decoration: none;
		color: black;
	}
	/*링크에 마우스 올렸을 때*/
	#lecTable #link:hover,#lecTable #link:active,#lecTable #link:visited{
		color: blue;
		background-color: #f5f5ff;
		cursor: pointer;
	}
	h1{
		text-align: center;
		height: 80px;
	}
	</style>
	
	</head>
	
	<body>
	<%@ include file="../templates/menu.jspf" %>
	<h1>＜ 강의 목록 ＞</h1>
	<table id="lecTable">
	<thead>
		<tr>
			<th>강의번호</th>
			<th>강의명</th>
			<th>강사</th>
			<th>강의장</th>
			<th>교육기간</th>
			<th>수강생</th>
		</tr>
	</thead>
	<tbody>
	<!-- 반복문 돌려서 DB에서 값 꺼내와야함 -->
		<tr id="link">
			<td><a href="lecDetail.jsp">11</a></td>
			<td><a href="lecDetail.jsp">웹개발자A</a></td>
			<td><a href="lecDetail.jsp">임현경</a></td>
			<td><a href="lecDetail.jsp">11</a></td>
			<td><a href="lecDetail.jsp">21.1.5</a></td>
			<td><a href="lecDetail.jsp">30명</a></td>
		</tr>
		
		<tr id="link">
			<td><a href="lecDetail.jsp">22</a></td>
			<td><a href="lecDetail.jsp">웹개발자B</a></td>
			<td><a href="lecDetail.jsp">임경균</a></td>
			<td><a href="lecDetail.jsp">12</a></td>
			<td><a href="lecDetail.jsp">21.2.1</a></td>
			<td><a href="lecDetail.jsp">24명</a></td>
		</tr>
	</tbody>
	</table>
	<%@ include file="../templates/footer.jspf" %>
	</body>
	</html>