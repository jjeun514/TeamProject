<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script type="text/javascript">

	var cnt=1;
	$(function(){
		$('[type=button]').click(function(){	
			cnt++;
			$('<div><input type="file" name="file'+cnt+'" /></div>').appendTo('#f');
		});
	});

</script>
</head>
<body>
	<h1>동적파일</h1>
	<form action="upload2.bit" method="post" enctype="multipart/form-data">
		<div id="f">
			<label>file</label><button type="button">추가</button>
			<div>
				<input type="file" name="file1"/>
			</div>
		</div>
		<button type="submit">전송</button>
	</form>
</body>
</html>