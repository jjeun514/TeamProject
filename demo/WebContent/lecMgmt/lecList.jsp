	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@ page import="java.util.*,com.bit.lec.model.LecDto"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		background-color: #f5f5ff;
		cursor: pointer;
	}
	#link:hover{
		color: blue;
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
	#tilde{
		width: 5px;
	}
	#totalStu{
		width: 70px;
	}
	
	</style>
	
	</head>
	
	<body>
	<%@ include file="../templates/menu.jspf" %>
	<%
	//권한 체크
	int deptNo=(Integer) session.getAttribute("deptno");
	System.out.println("[lecList.jsp] dpetno: "+deptNo);
	/*
		강의 목록 열람: 영업/행정/강사 모두 권한 있음
		deptno: 영업 1, 행정 2, 강사 3
	*/
	if(deptNo!=1 && deptNo!=2 && deptNo!=3){
			System.out.println("영업/행정/강사가 아닌경우");
			response.setContentType("text/html; charset=UTF-8");
		    out.println("<script>alert('권한이 없습니다.'); location.href='javascript:history.back()';</script>");
		    out.flush();
		// 로그인이 되어 있지 않은 경우 (영업, 행정, 강사가 아닌경우)
		// 컨트롤러에서 처리
	}
	
	LecDto bean2=(LecDto)request.getAttribute("cnt");
	String totalStu=request.getParameter("count(*)");
	request.setAttribute("count", totalStu);
	%>
	<h1>＜ 강의 목록 ＞</h1>
	<table id="lecTable">
	<thead>
		<tr>
			<th id="no">No</th>
			<th>강의명</th>
			<th id="instructor">강사</th>
			<th id="classroom">강의장</th>
			<th>교육기간</th>
			<th id="totalStu">수강생</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list }" var="bean">
	<!-- 반복문 돌려서 DB에서 값 꺼내와야함 (부분 반복)-->
		<tr id="link">
			<td><a href="${pageContext.request.contextPath }/lecDetail.bit?lecNo=${bean.lecNo}">${bean.lecNo}</a></td>	<!-- No -->
		<!-- DB: 강의명, 강사, 강의장, 시작일 ~ 종강일 (반복문)-->
			<td><a href="${pageContext.request.contextPath }/lecDetail.bit?lecNo=${bean.lecNo}">${bean.lecName}</a></td>	<!-- 강의명 -->
			<td><a href="${pageContext.request.contextPath }/lecDetail.bit?lecNo=${bean.lecNo}">${bean.ename}</a></td>	<!-- 강사 -->
			<td><a href="${pageContext.request.contextPath }/lecDetail.bit?lecNo=${bean.lecNo}">${bean.lecRoom}</a></td>	<!-- 강의장 -->
			<td><a href="${pageContext.request.contextPath }/lecDetail.bit?lecNo=${bean.lecNo}">${bean.lecStartDate}&nbsp;~&nbsp;${bean.lecFinishDate}</a></td>	<!-- 시작일 ~ 종강일 -->
		<!-- 수강생 (30명 정원) -->
			<td><a href="${pageContext.request.contextPath }/lecDetail.bit?lecNo=${bean.lecNo}">${bean.totalStu }/30 &nbsp;명</a></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<%@ include file="../templates/footer.jspf" %>
	</body>
	</html>