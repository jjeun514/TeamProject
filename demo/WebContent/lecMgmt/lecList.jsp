	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@page import="java.util.*,com.bit.model.LecListDto"%>
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
	
	#no{
		width: 70px;
	}
	#instructor{
		width: 100px;
	}
	#classroom{
		width: 70px;
	}
	#startDate,#endDate{
		width: 100px;
	}
	#tilde{
		width: 5px;
	}
	#total{
		text-align: right;
	}
	#totalStu{
		width: 70px;
	}
	
	</style>
	
	</head>
	
	<body>
	<%@ include file="../templates/menu.jspf" %>
	<h1>＜ 강의 목록 ＞</h1>
	<table id="lecTable">
	<thead>
		<tr id="link">
			<th id="no">No</th>
			<th>강의명</th>
			<th id="instructor">강사</th>
			<th id="classroom">강의장</th>
			<th>교육기간</th>
			<th id="totalStu">수강생</th>
		</tr>
	</thead>
	<tbody>
	<%
	%>
	<!-- 반복문 돌려서 DB에서 값 꺼내와야함 (부분 반복)-->
	<%int cnt=1; %>
		<tr id="link">
			<td><a href="lecDetail.jsp"><%=cnt++ %></a></td>	<!-- No -->
		<!-- DB: 강의명, 강사, 강의장, 시작일 ~ 종강일 (반복문)-->
			<td><a href="lecDetail.jsp"></a></td>	<!-- 강의명 -->
			<td><a href="lecDetail.jsp"></a></td>	<!-- 강사 -->
			<td><a href="lecDetail.jsp"></a></td>	<!-- 강의장 -->
			<td id="startDate"><a href="lecDetail.jsp">&nbsp;~&nbsp;</a></td>	<!-- 시작일 ~ 종강일 -->
		<!-- 수강생 (30명 정원) -->
			<td id="total"><a href="lecDetail.jsp">/30 &nbsp;</a></td>
		</tr>
	</tbody>
	</table>
	<%@ include file="../templates/footer.jspf" %>
	</body>
	</html>