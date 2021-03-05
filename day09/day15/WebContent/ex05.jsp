<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과</h1>
	<h2>기본자료형</h2>
	<ul>
		<li>${su }</li>
		<li>${boo }</li>
		<li>${msg }</li>
		<li>${sysdate }</li>
	</ul>
	
	<ol>
		<li>${arr[0] }</li>
		<li>${arr[1] }</li>
		<li>${arr[2] }</li>
		<li>${arr[3] }</li>
	</ol>
	
	<ol>
		<li>${alist.get(0) }</li>
		<li>${alist.get(1) }</li>
		<li>${alist.get(2) }</li>
		<li>${alist.get(3) }</li>
	</ol>
	
	<ul>
		<li>${hmap.key1 }</li>
		<li>${hmap.key2 }</li>
		<li>${hmap.key3 }</li>
		<li>${hmap.key4 }</li>
	</ul>
	
	<ul>
		<li>${bean.su1 }</li>
		<li>${bean.su2 }</li>
		<li>${bean.su3 }</li>
		<li>${bean.boo }</li>
		<li>${bean.msg }</li>
		<li>${bean.nalja }</li>
	</ul>
</body>
</html>






