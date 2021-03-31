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



출처: https://seungjenote.tistory.com/entry/CSS-이미지-가운대-정렬방법왼쪽-오른쪽 [SeungJe Note]
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
	  <div class="col-xs-12">
	  <!--본문 시작  -->
	  
		<div class="jumbotron">
		   <img id="idea" alt="" src="imgs/company.png">
		   <div>
               <div class="pc">본 교육기관은 1983년 벤처기업 1호로 창업해 디지털 시대를 선도하는</div>
               <div class="pc">(주) 비트컴퓨터가 <span class="bold">[기술은 나눌수록 커진다]  [우수한 인재를 양성해 사회에 환원하겠다]</span> 는 목적으로 설립하였습니다.</div>
               <div class="pc">따라서 기관장은 국내 최고의 IT전문가로 정부 정책의 방향을 이해하고 공감하며</div>
               <div class="pc">산업체가 필요로 하는 인재를 양성하기 위해 양질의 훈련과정을 운영하고 있습니다.</div>
               <div class="pc">더불어 ‘한국 소프트웨어 산업 협회’ 회장 활동 등 국내 SW산업의 건전한 발전과 진흥을 목적으로</div>
               <div class="pc"><span class="bold">SW산업에 대한 인식제고와 SW산업정책, 제도분야의 개선을 위해 다각적인 활동을 하고 있습니다.</span></div>
           </div>
           <img alt="" src="imgs/company1.png">
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