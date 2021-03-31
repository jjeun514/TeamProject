<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
<style type="text/css">
#idea{
	
}

.pc{
	text-align: center;
	font-size: 19px;

}


.jumbotron>img{
	display : block;

	margin : auto;

}

.table{
	margin-right: 5px;
}


</style>
</head>
<body>

<!--상단 메뉴  -->
<nav class="navbar navbar-default navbar-inverse">
  <div class="container">
    
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="" src="imgs/logo.png">
      </a>
    </div>
    
    <ul class="nav navbar-nav">
    	<li><a href="/advertising/adHome.jsp">HOME</a></li>
    	<li><a href="/advertising/adIntro.jsp">학원소개</a></li>
    	<li><a href="/advertising/Bbs.bit">교육과정</a></li>    	
    </ul>
  </div>
</nav>

<div class="container">
	<div class="row">
	  <!--본문 시작  -->
	 <c:forEach items="${list }" var="bean"> 
	  <div class="col-xs-4">
		  <table class="table">
		  	<tr>
		  		<td>
		  			<a href="/advertising/adBbsDetail.bit?lecNo=${bean.lecNo }">
		  				<img src="imgs/lectureA.png" alt="...">
		  			</a>
		  		</td>
		  	</tr>
		  	<tr>
		  		<td>
		  			<a href="/advertising/adBbsDetail.bit?lecNo=${bean.lecNo }">
		  				${bean.lecName }	
		  			</a>
		  		</td>
		  	</tr>
		  	<tr>
		  		<td></td>
		  	</tr>
		  	<tr>
		  		<td>개강일 | ${bean.lecStartDate }</td>
		  	</tr>
		  	<tr>
		  		<td>교육기간 | ${bean.lecStartDate } ~ ${bean.lecFinishDate }</td>
		  	</tr>
		  	
		  </table>

  	  </div>
  	</c:forEach>  
	
<div class="col-sm-11"></div>
<a href="/advertising/add.bit" class="btn btn-primary col-sm-1" role="button">입 력</a>

	  <!--본문 끝  -->
	</div>
</div>


	<!--footer  -->
	<div class="row">
	  <div class="col-xs-12 text-center">
	  Copyright &copy; BitCamp All rights reserved.
	  </div>
	</div>
	


</body>
</html>