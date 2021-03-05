<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int su=1234;
	boolean boo=true;
	String msg1="msg";
	request.setAttribute("su", su);
	request.setAttribute("boo", boo);
	request.setAttribute("msg", msg1);
	request.setAttribute("sysdate", new java.util.Date());
	
	String[] arr1={"item1","item2","item3","item4"};
	request.setAttribute("arr", arr1);
	
	ArrayList list=new ArrayList();
	list.add("arrItem1");
	list.add("arrItem2");
	list.add("arrItem3");
	list.add("arrItem4");
	request.setAttribute("alist", list);
	
	HashMap map=new HashMap();
	map.put("key1", "val1");
	map.put("key2", "val2");
	map.put("key3", "val3");
	map.put("key4", "val4");
	request.setAttribute("hmap", map);
	
	%>
	<jsp:useBean id="bean" class="com.bit.emp.model.EmpDto" scope="request"></jsp:useBean>
	<jsp:setProperty property="su1" name="bean" value="1234"/>
	<jsp:setProperty property="su2" name="bean" value="3.14"/>
	<jsp:setProperty property="su3" name="bean" value="A"/>
	<jsp:setProperty property="boo" name="bean" value="true"/>
	<jsp:setProperty property="msg" name="bean" value="ABCD"/>
	<% bean.setNalja(new java.util.Date()); %>
	<jsp:forward page="ex05.jsp"></jsp:forward>
</body>
</html>







