<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style rel="stylesheet" type="text/css">

#idTest { 
 position:   absolute;
    top:        76px;
    left:       265px;
    width:      71px;
    height:     24px;
}
#empNoTest { 
 position:   absolute;
    top:        156px;
    left:       265px;
    width:      71px;
    height:     24px;
}
</style>

<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">

$(function(){
	
	
	$('#idTest').click(function() {
		var sysId=$('#sysId').val();
		
		$.ajax({
			url :"${pageContext.request.contextPath}/accAdd.bit?sysId="+sysId,
			type : "get",
			dataType:"text", 
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
          $('#empNo').attr("disabled", false);
          $('#empNoTest').attr("disabled", false);
  		 
        }
    });
    
    $('#empNoTest').click(function() {
		var empNo=$('#empNo').val();
		
		$.ajax({
			url :"${pageContext.request.contextPath}/empCheck.bit?empNo="+empNo,
			type : "get",
			dataType:"text", 
			success: function(empNoCheck){
				var empNoCheck=empNoCheck;
				if(empNoCheck=="0"){
	           		 alert("사원번호를 입력하세요.");
	            }else if(empNoCheck=="1"){
		            alert("사원번호를 확인하세요.");
	            }else if(empNoCheck=="2"){
		            alert("없는 사원번호입니다.");
	            }else if(empNoCheck=="3"){
		            alert("사용가능한 사원번호입니다.");
		            $('button[type="submit"]').attr("disabled", false);
	            }
	        },
	        error: function(xhr) {
	            alert('에러입니다.');
	        }  
		});
	});

});

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
				<td><button id="idTest" type="button">중복체크</button></td>
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
				<td><button id="empNoTest" type="button" disabled="disabled">사번확인</button></td>
			</tr>
			<tr>
				<td><button type="submit" disabled="disabled">가입</button></td>
				<td><button type="reset">취소</button></td>
			</tr>
		</table>
	</form>
</body>
</html>