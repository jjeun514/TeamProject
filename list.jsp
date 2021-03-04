<%@page import="com.bit.dept.model.DeptDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style rel="stylesheet" type="text/css">
table,td,th{
	border: 1px solid black;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
<%@ include file="template/menu.jspf" %>
	<table>
		<thead>
			<tr>
				<th>deptno</th>
				<th>dname</th>
				<th>loc</th>
				
				<th>출석</th>
				<th>지각</th>
				<th>결석</th>
				<th>출결</th>
			</tr>
		</thead>
		
		<tbody>
		<%
		List<DeptDto> list;
		list=(List<DeptDto>)request.getAttribute("list");
			
		int cnt=0;
		for(DeptDto bean:list){
		%>
			<tr>
				<td><%=bean.getDeptno() %></td>
				<td><%=bean.getDname() %></td>
				<td><%=bean.getLoc() %></td>
				
				<th>
				<input type="radio" name="attendance<%=cnt %>" value="att">
				출석</th>
				<th>
				<input type="radio" name="attendance<%=cnt %>" value="late">
				지각</th>
				<th>
				<input type="radio" name="attendance<%=cnt++ %>" value="abs">
				결석</th>
				
				<td id="result">
				</td>
				<td>
					<button class="ok">확인</button>
				</td>	
			</tr>
		<%
		}
		%>
			
		</tbody>
	</table>
	
<%@ include file="template/footer.jspf" %>
</body>
</html>