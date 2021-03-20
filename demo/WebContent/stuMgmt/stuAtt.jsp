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
<h1>＜ 출결 관리 ＞</h1>
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
	<table id="stuAtt">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화</th>
				
				<th>출석</th>
				<th>지각</th>
				<th>결석</th>
				<th>출석률</th>
			</tr>
		</thead>
		
		<tbody>
		
			<tr id="link">
				<td>1101</td>
				<td>권태민</td>
				<td>01046117304</td>
				
				<td>
				<input type="radio" name="attendance" value="att">
				출석</td>
				<td>
				<input type="radio" name="attendance" value="late">
				지각</td>
				<td>
				<input type="radio" name="attendance" value="abs">
				결석</td>
				
				<td id="result">
				</td>
				<td>
					<button class="ok">확인</button>
				</td>	
				<td>
					<button class="edit">수정</button>
				</td>	
			</tr>
		
			<tr id="link">
				<td>1102</td>
				<td>권태만</td>
				<td>01046117306</td>
				
				<td>
				<input type="radio" name="attendance" value="att">
				출석</td>
				<td>
				<input type="radio" name="attendance" value="late">
				지각</td>
				<td>
				<input type="radio" name="attendance" value="abs">
				결석</td>
				
				<td id="result">
				</td>
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