<%@page import="com.test.model.StuInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style rel="stylesheet" type="text/css">
		#sub22{
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
		#stuAtt{
			width: 80%;
			margin: auto;
			text-align: center;
			empty-cells: hide;
		}
		#stuAtt th{
			background-color: #8b8bb5;
			color: white;
		}
		#stuAtt,#stuAtt th,#stuAtt td{
			border: solid 1px black;
		}
		#stuAtt a{
			/*셀 전체에 링크 걸리도록*/
			display: block;
			width: 100%;
			height: 100%;
			
			text-decoration: none;
			color: black;
		}
		/*링크에 마우스 올렸을 때*/
		#stuAtt #link:hover{
			color: black;
			background-color: #f5f5ff;
		}
		.ok,.edit{
			width: 100%;
			height: 100%;
		}
		h1{
			text-align: center;
		}
</style>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<h1>＜ 출결 관리 ＞</h1>
	<form action="${pageContext.request.contextPath }/stuMgmt/stuAttStatus.bit" method = "post">
			<table id="topPart">
				<tr><td><select name="selectLec" onchange="this.form.submit();">
					<option>강의를 선택하시오</option>
				<%List<StuInfoDto> lecList = null;
					lecList = (List<StuInfoDto>)request.getAttribute("lecNo");
					if (lecList!=null){
						for(StuInfoDto bean : lecList) {
				%>
					<option value="<%=bean.getLecNo()%>"><%=bean.getLecName() %></option>
				<%}}%>
				</select>
			</table>
		</form>
		
	<table id="stuAtt">
		<thead>
		
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화</th>
				
				<th>출석</th>
				<th>지각</th>
				<th>결석</th>
				<th>총 수업일수</th>
				<th>출결입력</th>
			</tr>
		</thead>
		
		<tbody>
		
			<%
			List<StuInfoDto> list = null;
			list = (List<StuInfoDto>)request.getAttribute("stuAttList");
			if ( list != null ) {
				for (StuInfoDto stuAtt: list){
			%>
			<tr id="link">
				<td><%=stuAtt.getStuNo() %></td>
				<td><%=stuAtt.getStuName() %></td>
				<td><%=stuAtt.getStuPhone() %></td>
				
				<td><input type="radio" name="stuAtt" value="stuAtt">출석</td>
				<td><input type="radio" name="stuLate" value="stuLate">지각</td>
				<td><input type="radio" name="stuAbsent" value="stuAbsent">결석</td>
				
				<td id="result">
				</td>
				<td>
					<button class="ok">확인</button>
				</td>	
				<td>
					<button class="edit">수정</button>
				</td>	
			</tr>
			<%}} %>
		</tbody>
	</table>
	
<%@ include file="/templates/footer.jspf" %>
</body>
</html>