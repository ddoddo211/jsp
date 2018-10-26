<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
view.jsp
<!-- post -->
<form method="post" action="/filterServlet">
	<input type="text" name="userNm" value="브라움"/><br>
	<button type="submit">전송</button> <br>
("userNm") : ${userNm }
<br>

<%
Map<String, Integer> countMap = new HashMap<String, Integer>(); 
countMap = (Map<String, Integer>)application.getAttribute("countMap");
for(String key : countMap.keySet()){
	out.println(key + " : " + countMap.get(key) + "<br>");
}
%>
	
</form>
</body>
</html>