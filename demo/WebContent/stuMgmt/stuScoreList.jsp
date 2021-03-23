<%@page import="com.test.model.StuScoreDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
		.Score{
			width: 80%;
			margin: auto;
			text-align: center;
			empty-cells: hide;
		}
		.Score{
			margin-bottom: 5px;
		}
		.Score th{
			background-color: #8b8bb5;
			color: white;
		}
		.Score,#stuScore th,#stuScore td{
			border: solid 1px black;
		}
		.Score a{
			/*셀 전체에 링크 걸리도록*/
			display: block;
			width: 100%;
			height: 100%;
			
			text-decoration: none;
			color: black;
		}
		/*링크에 마우스 올렸을 때*/
		.Score .link:hover{
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
<%@ include file="/templates/menu.jspf" %>
<h1>＜ 성적 관리 ＞</h1>
<div>

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
<!--강의1 성적 목록  -->
<%int cnt=0; %>
<c:forEach items="${lecture }" var="listA">
<table class="Score">
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
			<%List<StuScoreDto> lecList=null; 
				lecList=(List<StuScoreDto>)request.getAttribute("lecList"+cnt);
				if(lecList!=null){
					for(StuScoreDto bean:lecList){
			%>
				<tr class="link">
					<td><a href="${pageContext.request.contextPath}/stuMgmt/stuScoreDetail.bit?stuNo=<%=bean.getStuNo() %>"><%=bean.getStuNo() %></a></td>
					<td><a href="${pageContext.request.contextPath}/stuMgmt/stuScoreDetail.bit?stuNo=<%=bean.getStuNo() %>"><%=bean.getStuName()%></a></td>
					<td><a href="${pageContext.request.contextPath}/stuMgmt/stuScoreDetail.bit?stuNo=<%=bean.getStuNo() %>"><%=bean.getJava() %></a></td>
					<td><a href="${pageContext.request.contextPath}/stuMgmt/stuScoreDetail.bit?stuNo=<%=bean.getStuNo() %>"><%=bean.getWeb() %></a></td>
					<td><a href="${pageContext.request.contextPath}/stuMgmt/stuScoreDetail.bit?stuNo=<%=bean.getStuNo() %>"><%=bean.getFramework()%></a></td>
				</tr>
			<% 	}
			}
			cnt++;
			%>
		</tbody>
</table>
</c:forEach>

		<%@ include file="../templates/footer.jspf" %>
	</body>
</html>