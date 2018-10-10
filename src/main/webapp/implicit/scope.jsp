<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scope.jsp</title>
</head>
<body>
	scope.jsp >>> scopeServlet >>> scopeResult.jsp(dispatch)
	(값을전송) 		>> (각영역에 속성을저장) >> (각영역에서 저장된 값을 확인)
<form action="/scopeServlet" method="post">
	<input type="text" name="requestScope" value="brown"> <br>
	<input type="text" name="sessionScope" value="sally"> <br>
	<input type="text" name="applicationScope" value="cony"> <br>
	<input type="text" name="pageScope" value="james"> <br>
	<input type="submit" value="전송">
</form>

</body>
</html>