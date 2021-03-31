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

function lecChoice() {
	// alert("java scaript call");
	document.stuAttFormName.action = "/demo/stuMgmt/stuAttList.bit";
	document.stuAttFormName.submit();
}

function attChoice(stuNoVal) {
	var stuAtt,stuLate,stuAbsent;
	stuAtt = document.getElementsByName("stuAtt"+stuNoVal)[0].checked == true ? 1:null;
	stuLate = document.getElementsByName("stuLate"+stuNoVal)[0].checked == true ? 1:null;
	stuAbsent = document.getElementsByName("stuAbsent"+stuNoVal)[0].checked == true ? 1:null;
	
	if(stuAtt == null && stuLate == null && stuAbsent == null) {
		alert("출결을 선택해주세요.");
		return;
	} else {
		document.getElementById("stuNoId").value     = document.getElementsByName("stuNo"+stuNoVal)[0].value;
		document.getElementById("stuAttId").value    = stuAtt;
		document.getElementById("stuLateId").value   = stuLate;
		document.getElementById("stuAbsentId").value = stuAbsent;
		document.stuAttFormName.action = "/demo/stuMgmt/stuAttInsert.bit";
		document.stuAttFormName.submit();
		var attInsert = document.getElementById('confirm');
		attInsert.innerText = "입력완료";
	}
}

</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<h1>＜ 출결 입력 ＞</h1>
	<form name = "stuAttFormName">
			<table id="topPart">
				<tr><td><select name="selectLec" onchange="lecChoice()">
					<option>강의를 선택하시오</option>
				<%List<StuInfoDto> lecList = null;
					lecList = (List<StuInfoDto>)request.getAttribute("lecInfoList");
					if (lecList!=null){
						for(StuInfoDto bean : lecList) {
				%>
					<option value="<%=bean.getLecNo()%>"><%=bean.getLecName() %></option>
				<%}}%>
				</select>
			</table>
	<table id="stuAtt">
		<thead>
		
			<tr>
				<th><input type = "hidden"/></th>
				<th>학번</th>
				<th>이름</th>
				<th>전화</th>
				
				<th>출석</th>
				<th>지각</th>
				<th>결석</th>
				<th>입력여부</th>
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
				<td><input type = "hidden" name = "stuNo<%=stuAtt.getStuNo() %>" value = "<%=stuAtt.getStuNo() %>"/></td>
				<td><%=stuAtt.getStuNo() %></td>
				<td><%=stuAtt.getStuName() %></td>
				<td><%=stuAtt.getStuPhone() %></td>
				
				
				<td><input type="checkbox" name="stuAtt<%=stuAtt.getStuNo() %>" value="1">출석</td>
				<td><input type="checkbox" name="stuLate<%=stuAtt.getStuNo() %>" value="1">지각</td>
				<td><input type="checkbox" name="stuAbsent<%=stuAtt.getStuNo() %>" value="1">결석</td>
				<td id = "confirm">미입력</td>
				
				<td id="result">
				</td>
				<td>
					<input type = "button" class="ok" onclick = "attChoice(<%=stuAtt.getStuNo() %>);" value = "입 력"/><input type = "hidden" name = "lecNo" value = "<%=stuAtt.getLecNo()%>"/>
			</tr>
			<%}} %>
		</tbody>
	</table>
	<input type = "hidden" id = "stuNoId"     name="stuNo" />
	<input type = "hidden" id = "stuAttId"    name="stuAtt"/>
	<input type = "hidden" id = "stuLateId"   name="stuLate"/>
	<input type = "hidden" id = "stuAbsentId" name="stuAbsent"/>
</form>
<%@ include file="/templates/footer.jspf" %>
</body>
</html>