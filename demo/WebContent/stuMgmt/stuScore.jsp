<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style rel="stylesheet" type="text/css">
		#sub23{
			background-color: white;
			border-right: solid 3px darkblue;
			color: #103163;
		}
		#topPart{
			width: 80%;
			height: 50px;
			margin: auto;
			text-align: right;
		}
		#addBtn,#addBtn:hover,#addBtn:active,#addBtn:visited{
			text-decoration: none;
			cursor: pointer;
			color: black;
		}
		#stuScore{
			width: 80%;
			margin: auto;
			text-align: center;
			empty-cells: hide;
		}
		#stuScore th{
			background-color: #8b8bb5;
			color: white;
		}
		#stuScore,#stuScore th,#stuScore td{
			border: solid 1px black;
		}
		#stuScore a{
			/*셀 전체에 링크 걸리도록*/
			display: block;
			width: 100%;
			height: 100%;
			
			text-decoration: none;
			color: black;
		}
		/*링크에 마우스 올렸을 때*/
		#stuScore .link:hover{
			color: black;
			background-color: #f5f5ff;
		}
		.ok{
			width: 100%;
			height: 100%;
		}
		input{
			background-color: transparent;
			border: none;
			width: 100%;
			height: 100%;
		}
		th{
			width: 15%;
		}
		h1{
			text-align: center;
		}
</style>
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>

<script type="text/javascript">

</script>
</head>

<body>
<%@ include file="../templates/menu.jspf" %>
<h1>＜ 성적 관리 ＞</h1>

<div>
<h2 id="h2"> 안녕하세요  </h2>
<button id="test">수정</button>
</div>

<form action="${pageContext.request.contextPath}/stuMgmt/stuScore.bit" >
<table id="topPart">
<tr>
	<td>
		<select name="scoreList" onchange="this.form.submit();">
			<option value="0">강의를 선택하시오</option>
			<option value="1">웹 개발자 양성 A</option>
			<option value="2">웹 개발자 양성 B</option>
			<option value="3">웹 개발자 양성 C</option>
		</select>
	</td>
</tr>
</form>
</table>
	<table id="stuScore">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>		
				<th>자바</th>
				<th>웹</th>
				<th>프레임워크</th>
			</tr>
		</thead>
		
 		<tbody>
			<c:forEach items="${allList}" var="bean">
				<tr class="link">
		<form action="${pageContext.request.contextPath}/stuMgmt/stuScoreInsert.bit" method="post">
					
					<td><input name="stuNo" type="text" value="${bean.stuNo }" readonly="readonly"/></td>
					<td>${bean.stuName}</td>
					<td><input class="inputScore" name="java" type="text" value="${bean.java }" /></td>
					<td><input class="inputScore" name="web" type="text" value="${bean.web }" /></td>
					<td><input class="inputScore" name="framework" type="text" value="${bean.framework }" /></td>
					<td><button class="ok" type="submit">확인</button></td>		
		</form>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
	
<%@ include file="../templates/footer.jspf" %>
</body>
</html>
