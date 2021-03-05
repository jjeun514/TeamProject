<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body>div{
		margin: 0px auto;
		padding: 0px;
	}
	#header{
		
	}
	#header>h1{
		background-image: url("../imgs/bitcamp.png");
		background-repeat: no-repeat;
		text-indent: -999px;
	}
	#menu{
		overflow: hidden;
		background-color: gray;
	}
	#menu>ul{
		padding: 0px;
		width: 440px;
		list-style: none;
		margin: 0px auto;
	}
	#menu>ul>li{
		width: 100px;
		float: left;
		border-top: 2px solid darkgray;
		border-bottom: 2px solid darkgray;
		margin: 0px 5px;
	}
	#menu>ul>li>a{
		display: block;
		height: 30px;
		line-height: 30px;
		text-align: center;
		text-decoration: none;
		color:white;
	}
	
	#content table,th,td{
		border-collapse: collapse;
		border: 1px solid gray;
	}
	#content table{
		width: 80%;
		margin: 0px auto;
	}
	#content table>thead{}
	#content table>thead>tr{}
	#content table>thead>tr>th{
		background-color: gray;
	}
	#content table>tbody{}
	#content table>tbody>tr:nth-child(2n)>td{
		background-color: darkgray;
	}
	#content table>tbody>tr>td:first-child{
		width: 60px;
	}
	#content table+a{
		display: block;
		width: 80%;
		height: 50px;
		background-color: gray;
		border-radius: 10px;
		text-align: center;
		line-height: 50px;
		color: white;
		font-weight: bold;
		text-decoration: none;
		margin: 10px auto;
		box-shadow:2px 2px 5px darkgray;
		background-image: linear-gradient(gray, darkgray, gray);
	
	}
	#content{}
	#content>form{
		width: 350px;
		margin: 0px auto;
	}
	#content>form>div{}
	#content>form>div>label{
		display: inline-block;
		width: 100px;
	}
	#content>form>div>input{
		width: 200px;
	}
	#content>form>div>button{
		width: 30%;
	}
	#content>form>div>.err{
		display: block;
		color: red;
		text-align: center;
		font-style: italic;
	}
	#content div{
		width: 80%;
		margin: 0px auto;
	}
	#content div>div{
		border-bottom-style: dotted;
		border-bottom-color: gray;
		border-bottom-width: 1px;
	}
	#content div>div>span{
		display:inline-block;
		width: 55%;
	}
	#content div>div>span:first-child{
		background-color:gray;
		width: 40%;
	}
</style>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>


<script type="text/javascript">
 $(document).ready(function(){
	 $('form').submit(function(){
		 $('.err').remove();
		 if($('form input').eq(0).val()==''){
			 $('form input').eq(0).focus().parent()
			 .append('<span class="err">빈칸을 입력하세요</span>')
			 ;
			 return false;
		 }
		 if(Number.isNaN($('form input').eq(0).val()*1)){
			 $('form input').eq(0).select().parent()
			 .append('<span class="err">숫자만 입력하세요</span>')
			 ;
			 return false;
		 }
		 if($('form input').eq(1).val()==''){
			 $('form input').eq(1).focus().parent()
			 .append('<span class="err">빈칸을 입력하세요</span>')
			 ;
			 return false;
		 }
		 if($('form input').eq(2).val()==''){
			 $('form input').eq(2).focus().parent()
			 .append('<span class="err">빈칸을 입력하세요</span>')
			 ;
			 return false;
		 }
	 });
 });   
    
</script>
</head>
<body>
<div>
	<div id="header">
		<h1>비트교육센터</h1>
	</div>
	<div id="menu">
		<ul>
			<li><a href="../">HOME</a></li>
			<li><a href="./list.html">DEPT</a></li>
			<li><a href="../emp/list.html">EMP</a></li>
			<li><a href="../login/login.html">LOGIN</a></li>
		</ul>
	</div>
	<div id="content">
		<h2>dept detail</h2>
		<%@ page import="com.bit.model.DeptDto" %>
		<% DeptDto bean=(DeptDto)request.getAttribute("bean"); %>
		<div>
			<div>
				<span>deptno</span>
				<span><%=bean.getDeptno() %></span>
			</div>
			<div>
				<span>dname</span>
				<span><%=bean.getDname() %></span>
			</div>
			<div>
				<span>loc</span>
				<span><%=bean.getLoc() %></span>
			</div>
			<div>
				<a href="#">수정</a>
				<a href="#">삭제</a>
			</div>
		</div>
	</div>
	<div id="footer">
		Copyright &copy; 비트캠프 All rights reserved.
	</div>
</div>


</body>
</html>