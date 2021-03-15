<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.sendRedirect("home.jsp");
%>
<%
    // 인증 가능 사용자 및 비밀번호 목록.
    String[] users = { "aaa", "bbb", "ccc" };
    String[] passwords = { "111", "222", "333" };
    
    // login.jsp로부터 전달받은 데이터를 변수에 저장.
    String id = request.getParameter("idInput");
    String pw = request.getParameter("pwInput");
    Object a=request.getAttribute("list");
    // 사용자 인증
    String RedirectUrl = "login.jsp"; // 인증 실패시 로그인 페이지로 이동 
    for (int i = 0; i < users.length; i++) {
        if (users[i].equals(id) && passwords[i].equals(pw)) {
            session.setAttribute("signedUser", id); // 인증되었음 세션에 남김
            RedirectUrl = "home.jsp"; // 인증 성공 시 홈화면으로 이동
        }
    }
    response.sendRedirect(RedirectUrl);
%>
</body>
</html>