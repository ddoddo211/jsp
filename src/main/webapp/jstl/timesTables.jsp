<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	tr:nth-child(2n) {
		background: skyblue;
	}
	
	tr:nth-of-type(odd) {
		background: green;
	} 
	
	table {
		border-spacing: 10px
	}
	
	td {
		padding: 20px;
		
	}


</style>
</head>
<body>
<table>
	<c:forEach begin="1" end="9" var="gob">
			<tr>
									<%--parameter 로 넘겨준 number 라는 값을 받아서 끝나는 단수를 지정 --%>
			<c:forEach begin="2" end="${param.number }" var="dan">
				<td>${dan}*${gob}=${gob*dan}</td>
		
			</c:forEach>
			</tr>
	</c:forEach>	

</table>

</body>
</html>