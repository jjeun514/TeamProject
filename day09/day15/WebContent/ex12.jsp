<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		var table=$('<table/>')
		.append('<tr><th>날짜시간</th><th>날씨</th></tr>');
		$('#data').hide().find('data').each(function(){
			var col1=$(this).find('tmEf').text();
			var col2=$(this).find('wf').text();
			$('<tr/>')
				.append('<td>'+col1+'</td>')
				.append('<td>'+col2+'</td>')
				.appendTo(table);
		});
		$('h1').after(table);
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>etc jstl</h1>
	<div id="data">
	<c:import url="http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109"></c:import>
	</div>
</body>
</html>