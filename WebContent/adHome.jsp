<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	  <div class="col-xs-12">
	  <!--본문 시작  -->
	  
<!--carousel  -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner " role="listbox">
    <div class="item active">
      <img src="imgs/visual1.jpg" alt="...">
      <div class="carousel-caption">...</div>
    </div>
    <div class="item">
      <img src="imgs/visual2.jpg" alt="...">
      <div class="carousel-caption">...</div>
    </div>
    <div class="item">
      <img src="imgs/visual3.jpg" alt="...">
      <div class="carousel-caption">...</div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
	  <!--본문 끝  -->
  		</div>
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