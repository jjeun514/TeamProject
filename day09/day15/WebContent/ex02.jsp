<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> EL 연산</h1>
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
				<td>사칙연산(+)</td>
				<td>＄{1+2+3}</td>
				<td>${1+2+3 }</td>
				<td><%=1+2+3 %></td>
			</tr>
			<tr>
				<td>사칙연산(-)</td>
				<td>＄{5-2}</td>
				<td>${5-2 }</td>
				<td><%=5-2 %></td>
			</tr>
			<tr>
				<td>사칙연산(x)</td>
				<td>＄{5*2}</td>
				<td>${5*2 }</td>
				<td><%=5*2 %></td>
			</tr>
			<tr>
				<td>사칙연산(÷)</td>
				<td>＄{4/2}</td>
				<td>${4/2 }</td>
				<td><%=4/2 %></td>
			</tr>
			<tr>
				<td>사칙연산(÷)</td>
				<td>＄{5/2}</td>
				<td>${5/2 }</td>
				<td><%=5/2 %></td>
			</tr>
			<tr>
				<td>사칙연산(÷)</td>
				<td>＄{5 div 2}</td>
				<td>${5 div 2 }</td>
				<td><%=5/2 %></td>
			</tr>
			<tr>
				<td>사칙연산(%)</td>
				<td>＄{5 % 2}</td>
				<td>${5 % 2 }</td>
				<td><%=5%2 %></td>
			</tr>
			<tr>
				<td>사칙연산(%)</td>
				<td>＄{5 mod 2}</td>
				<td>${5 mod 2 }</td>
				<td><%=5%2 %></td>
			</tr>
			<tr>
				<td>동등비교</td>
				<td>＄{1==1}</td>
				<td>${1==1 }</td>
				<td><%=1==1 %></td>
			</tr>
			<tr>
				<td>동등비교</td>
				<td>＄{1 eq 1}</td>
				<td>${1 eq 1 }</td>
				<td><%=1==1 %></td>
			</tr>
			<tr>
				<td>비교</td>
				<td>＄{5<2}</td>
				<td>${5<2 }</td>
				<td><%=5<2 %></td>
			</tr>
			<tr>
				<td>비교</td>
				<td>＄{5 lt 2}</td>
				<td>${5 lt 2 }</td>
				<td><%=5<2 %></td>
			</tr>
			<tr>
				<td>비교</td>
				<td>＄{5>2}</td>
				<td>${5>2 }</td>
				<td><%=5>2 %></td>
			</tr>
			<tr>
				<td>비교</td>
				<td>＄{5 gt 2}</td>
				<td>${5 gt 2 }</td>
				<td><%=5>2 %></td>
			</tr>
			<tr>
				<td>비교</td>
				<td>＄{5 lt 2}</td>
				<td>${5 le 2 }</td>
				<td><%=5<=2 %></td>
			</tr>
			<tr>
				<td>비교</td>
				<td>＄{5 gt 2}</td>
				<td>${5 ge 2 }</td>
				<td><%=5>=2 %></td>
			</tr>
		</tbody>
	</table>
</body>
</html>









