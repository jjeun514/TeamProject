<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">


$(function(){
	
	$('button[type="button"]').click(function() {
		var sysId=$('#sysId').val();
		
		$.ajax({
			url :"${pageContext.request.contextPath}/accAdd.bit?sysId="+sysId,
			type : "get",
			dataType:"text", //받을때의 데이터 타입 ->controller에서 application/? 이부분과 매치
			//data:{"sysId":sysId},      <-- 이렇게 보내든 위처럼 보내든 상관 없음
			success: function(idCheck){
				var idCheck=idCheck;
				if(idCheck=="0"){
	            alert("아이디를 입력하세요");
	            }else if(idCheck=="1"){
		            alert("아이디를 4자 이상 입력하세요");
	            }else if(idCheck=="2"){
		            alert("아이디를 20자 이하 입력하세요");
	            }else if(idCheck=="3"){
		            alert("중복된 아이디가 있습니다.");
	            }else if(idCheck=="4"){
		            alert("중복체크 성공!");
		            $('#sysPw').attr("disabled", false);
		            $('#PwConform').attr("disabled", false);
		            $('#empNo').attr("disabled", false);
		            
	            }
	        },
	        error: function(xhr) {
	            alert('에러입니다.');
	        }  
		});
	});

    $('#PwConform').keyup(function(){
    	 var pw=$('#sysPw').val();
    	 var pwck=$('#PwConform').val();
        if(pw != pwck){
          $('#pwSame').html('비밀번호 일치하지 않음');
          $('#pwSame').attr('color', 'red');
        } else{
          $('#pwSame').html('비밀번호 일치함');
          $('#pwSame').attr('color', 'blue');
        }
    });
    $('button[type="submit"]').attr("disabled", false);
});

	//$(function() {

	//	var pw = $('#sysPw').val();
	//	var pwck = $('#PwConform').val();
	//	var empNo = $('#empNo').val();

	//	if (pw != null && pwck != null) {
	//		if (pw == pwck) {
	//			$('#pwSame').html("비밀번호가 일치합니다.")
	//			$('#pwSame').style.color = 'blue';
	//		} else {
	//			$('#pwSame').html("비밀번호가 일치하지 않습니다.")
	//			$('#pwSame').style.color = 'red';
	//		}
	//	}

		//$('button[type="submit"]').attr("disabled", false);
	//});
</script>
</head>
<body>
	<h2>회원가입</h2>
	<!-- 일단 emp테이블에 입력되어있고, empno를 알려준 후 회원가입을 해야 하는지 -->
	<form action="accAdd.bit" method="post">
		<table>
			<tr>
				<td><label>id (email)</label></td>
				<td><input type="text" id="sysId" name="sysId"></td>
				<td><button type="button">중복체크</button></td>
			</tr>
			<tr>
				<td><label>pw</label></td>
				<td><input type="password" id="sysPw" name="sysPw" disabled="disabled"/><font
					id="pwCheck"></font></td>
			</tr>
			<tr>
				<td><label>pw확인</label></td>
				<td><input type="password" id="PwConform" name="PwConform" disabled="disabled"/><font
					id="pwSame"></font></td>
			</tr>
			<tr>
				<td><label>empNo</label></td>
				<td><input type="text" id="empNo" name="empNo" disabled="disabled"></td>
			</tr>
			<tr>
				<td><button type="submit" disabled="disabled">가입</button></td>
				<td><button type="reset">취소</button></td>
			</tr>
		</table>
	</form>
</body>
</html>