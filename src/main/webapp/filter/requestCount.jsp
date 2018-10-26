<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Map<String, Integer> countMap = new HashMap<String, Integer>(); 
countMap = (Map<String, Integer>)application.getAttribute("countMap");
for(String key : countMap.keySet()){
	out.println(key + " : " + countMap.get(key) + "<br>");
}
%>

</body>
</html>