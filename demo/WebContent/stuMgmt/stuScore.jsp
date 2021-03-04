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
		#stuScore #link:hover{
			color: black;
			background-color: #f5f5ff;
		}
		.ok,.edit{
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
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){
	
	$('.ok').click(function(e){
		
		var name=$(':radio').attr('name');
		console.log(name);
		var checked=$('input[name=\"'+name+'\"]:checked').val();
		$('#result').html(checked);
		// 확인 버튼 한 번 누르면 버튼 비활성화
		//$('.ok').prop("disabled",true);	
	});
});

</script>
</head>
<body>
<%@ include file="/templates/menu.jspf" %>
<h1>＜ 성적 관리 ＞</h1>
<table id="topPart">
<tr><td>
<select>
	<option>강의를 선택하시오</option>
	<option>웹 개발자 양성 A</option>
	<option>웹 개발자 양성 B</option>
	<option>웹 개발자 양성 C</option>
</select>
</td></tr>
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
		
			<tr id="link">
				<td>1101</td>
				<td>권태민</td>
				<td><input type="text" /></td>
				<td><input type="text" /></td>
				<td><input type="text" /></td>
				<td id="okBtn">
					<button class="ok">확인</button>
				</td>	
				<td id="editBtn">
					<button class="edit">수정</button>
				</td>	
			</tr>
		
			<tr id="link">
				<td>1102</td>
				<td>권태만</td>
				<td><input type="text" /></td>
				<td><input type="text" /></td>
				<td><input type="text" /></td>
				<td id="okBtn">
					<button class="ok">확인</button>
				</td>	
				<td id="editBtn">
					<button class="edit">수정</button>
				</td>	
			</tr>
		
			
		</tbody>
	</table>
	
<%@ include file="/templates/footer.jspf" %>
</body>
</html>