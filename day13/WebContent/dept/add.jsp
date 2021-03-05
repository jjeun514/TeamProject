<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>

<style type="text/css">
body>div {
	margin: 0px auto;
	padding
	0px;
}

#header {
	
}

#header>h1 {
	background-image: url("../imgs/bitcamp.png");
	background-repeat: no-repeat;
	text-indent: -999px;
}

#menu {
	overflow: hidden;
	background-color: gray;
}

#menu>ul {
	padding: 0px;
	width: 400px;
	list-style: none;
	margin: 0px auto;
}

#menu>ul>li {
	width: 100px;
	float: left;
	border-bottom: 2px solid darkgray;
	border-top: 2px solid darkgray;
	margin: 0px;
}

#menu>ul>li>a {
	display: block;
	height: 30px;
	line-height: 30px;
	text-align: center;
	text-decoration: none;
	color: white;
}

.bx-controls {
	display: none;
}

	#content{}
	#content>from{
	width: 80%;
	margin: 0px auto;
	}
	#content>from>div{}
	#content>from>div>label{
		display: inline-block;
		width: 100px;
	}
	#content>from>div>input{
		width: 200px;
	}
	#content>from>div>button{
		width: 30%;
	}
	#content>form>div>.err{
		display: block;
		color:  red;
		text-align: center;
		font-style: italic;
	}

</style>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
		$('.err').remove();
			if($('form input').eq(0).val()==""){
				$('form input').eq(0).focus().parent()
				.append('<span class="err">빈칸이 올 수 없습니다.')
				;
				return false;
			}
			if(Number.isNaN($('form input').eq(0).val()*1)){
				$('form input').eq(0).select().parent().append('<span class="err">숫자만 입력하세요.')
				;
				return false;
			}
			if($('form input').eq(1).val()==""){
				$('form input').eq(1).focus().parent().append('<span class="err">빈칸이 올 수 없습니다.')
				;
				return false;
			}
			if($('form input').eq(2).val()==""){
				$('form input').eq(2).focus().parent().append('<span class="err">빈칸이 올 수 없습니다.')
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
				<li><a href='../'>HOME</a></li>
				<li><a href='../dept/list.html'>DEPT</a></li>
				<li><a href='../emp/list.html'>EMP</a></li>
				<li><a href='../login/login.html'>LOGIN</a></li>
			</ul>
		</div>
		<div id="content">
			<h2>Add</h2>
			<form action="add.html" method="get">
				<div>
					<label>deptno</label>
					<input type="text" name="deptno">
				</div>
				<div>
					<label>dname</label>
					<input type="text" name="dname">
				</div>
				<div>
					<label>loc</label>
					<input type="text" name="loc">
				</div>
				<div>
					<button>입력</button>
					<button type="reset">리셋</button>
					<button type="button">취소</button>
				</div>
			</form>
		</div>
		<div id="footer">
			<address>서울시 중구 비트캠프</address>
		</div>
</body>
</html>