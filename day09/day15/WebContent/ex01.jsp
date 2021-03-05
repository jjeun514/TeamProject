<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> EL language(EL 표현식)</h1>
	<table>
		<thead>
			<tr>
				<th>자료형</th>
				<th>표현방식</th>
				<th>EL</th>
				<th>java</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>숫자1(정수)</td>
				<td>＄{1234+1}</td>
				<td>${1234+1}</td>
				<td><%=1234+1 %></td>
			</tr>
			<tr>
				<td>숫자2(실수)</td>
				<td>＄{3.14+1}</td>
				<td>${3.14+1 }</td>
				<td><%=3.14+1 %></td>
			</tr>
			<tr>
				<td>문자열</td>
				<td>＄{'ABC'}</td>
				<td>${'ABC' }</td>
				<td><%="A" %></td>
			</tr>
			<tr>
				<td>문자열</td>
				<td>＄{"문자열"}</td>
				<td>${"문자열" }</td>
				<td><%="문자열" %></td>
			</tr>
			<tr>
				<td>Boolean</td>
				<td>＄{true}</td>
				<td>${true }</td>
				<td><%=true %></td>
			</tr>
			<tr>
				<td>Boolean</td>
				<td>＄{false}</td>
				<td>${false }</td>
				<td><%=false %></td>
			</tr>
			<tr><% Object obj=null; %>
				<td>NULL</td>
				<td>＄{null}</td>
				<td>${null }</td>
				<td><%=obj %></td>
			</tr>
		</tbody>
	</table>
</body>
</html>









