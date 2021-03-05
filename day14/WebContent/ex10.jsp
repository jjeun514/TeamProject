<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">


</style>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		CKEDITOR.replace('editor1');
	});
</script>

</head>
<body>
	<form>
		<div>
			<label>제목</label>
			<input type="text" name="sub">
		</div>
	 <textarea name="editor1" id="editor1" rows="10" cols="80">
            </textarea>
            <script>
            	
            </script>
		<div>
			<button>입력</button>
		</div>
	</form>
</body>
</html>