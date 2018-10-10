<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
</head>
<body>
	여기는 main.jsp 파일이 정상적으로 열려서 보이는거다~~ 이말이야~~ <br>
	<%="아이디 : " + request.getParameter("userId") %> <br>
	<%="비밀번호 : " +request.getParameter("password") %> <br>
	
	<br>
	<%=session.getAttribute("session") %>

</body>
</html>