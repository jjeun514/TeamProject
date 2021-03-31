<%@page import="com.bit.model.AdDto"%>
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


h1{
	text-align: center;
	margin-bottom: 50px;
}

.form-group{
	margin: 50px auto;
}
</style>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#lecStartDate" ).datepicker({dateFormat:'yy-mm-dd'}).on("change",function(){ 
    	
    	var before=$('#lecStartDate').val(); 
    		
    	
    	var arr=before.split('-');
    	
    	var beforeDate=new Date(arr[0],arr[1]-1,arr[2]);
    	console.log(before);
    	
    	var after=beforeDate.getFullYear()+"-"+(beforeDate.getMonth()+3)+"-"+beforeDate.getDate();
    	
    	if(before!=null)
    		$('#lecFinishDate').val(after);
    		    
    });

    
  });
  </script>


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

<div class="col-sm-12">
	<h1>개설 강의 정보 입력</h1>
</div>

<form class="form-horizontal" action="/advertising/adInsert.bit" method="post">
    
	  <div class="form-group">
	    <label for="" class="col-sm-3 control-label">강의명</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" id="lecName" name="lecName" value=""style="text-align: center;">
	    </div>
	    <label for="" class="col-sm-2"></label>
	  </div>
	
	  <div class="form-group">
	    <label for="" class="col-sm-3 control-label">강의일정</label>
	    <div class="col-sm-3">
	      <input type="text" id="lecStartDate"  name="lecStartDate" class="datepicker form-control">
	    </div>
	    <label for="" class="col-sm-1" style="text-align: center">~</label>
	    <div class="col-sm-3">
	      <input type="text" id="lecFinishDate"  name="lecFinishDate" class="form-control">
	    </div>
	    <label for="" class="col-sm-2"></label>
	  </div>
	
	  <div class="form-group">
	  	<div class="col-sm-3"></div>
	  	<div class="col-sm-7">
	      <button type="submit" class="btn btn-primary btn-block">입력</button>
	    </div>
	    <div class="col-sm-2"></div> 
	  </div>
  
  
</form>	
	 

	


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