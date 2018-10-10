<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<%for(int gob = 1; gob <10; gob++){ %>
	<tr>
		<%for(int dan = 2; dan <10; dan++){ %>
		<td><%=dan+" * "+gob+" = "+dan*gob %></td>
		<%} %>
	</tr>
	<%
		
	} %>

</table>

</body>
</html>