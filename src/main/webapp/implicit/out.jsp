<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp 내장객체(implict 객체) : jsp가 servlet 으로 변환되는과정에서 생성된 변수 
		request, session, response, out-->

	<% out.write("아웃객체에서 출력한 ㄴ내용"); %>

</body>
</html>