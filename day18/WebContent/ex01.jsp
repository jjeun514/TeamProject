<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일업로드</h1>
	<!--  enctype="multipart/form-data" 타입을 이렇게 해서 보냈으면-->
	<!--  받을때도 멀티파트 리퀘스트로 받아야함 -> ex02controller가봐-->
	<form action="ex02.bit" method="post" enctype="multipart/form-data">
	<div>
		<label>id</label>
		<input type="text" name="id" />
	</div>
	<div>
		<label>file</label>
		<input type="file" name="file01" />
	</div>
	<div>
		<button>업로드</button>
	</div>
	</form>
</body>
</html>