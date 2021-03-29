	<%@ page import="com.test.model.Dto"%>
<%@page import="java.util.List"%>
<%@page import="java.io.Console"%>
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
	#contents{
		text-align: center;
		line-height: 50px;
	}
	</style>
	
	</head>
	<body>
	<% 
	List<Dto> information=(List<Dto>)request.getAttribute("list");
	Dto dto=information.get(0);	

	session.setAttribute("sysId", dto.getSysId());
	session.setAttribute("sysPw", dto.getSysPw());
	session.setAttribute("empNo", dto.getEmpNo());
	session.setAttribute("deptno", dto.getDeptno());
	
	%>
	<%@ include file="templates/menu.jspf" %>
	<%@ page import="java.util.ArrayList" %>
	<h2>환영합니다!</h2>
	<p><%="'"+session.getAttribute("sysId")+"' " %>님으로 로그인되었습니다.</p>
	<%@ include file="templates/footer.jspf" %>
	</body>
	</html>