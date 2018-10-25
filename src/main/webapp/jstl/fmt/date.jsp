<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="date" value="<%=new Date() %>" />
date : ${date } <br>
format date : <fmt:formatDate value="${date }"/><br>
format date(yyyy-MM-dd) : <fmt:formatDate value="${date }" pattern="yyyy-MM-dd"/><br>
type=date : <fmt:formatDate value="${date }" type="date"/><br>
type=date dateStyle="full" : <fmt:formatDate value="${date }" type="date" dateStyle="full"/><br>
type=date dateStyle="medium" : <fmt:formatDate value="${date }" type="date" dateStyle="medium"/><br>
type=date dateStyle="short" : <fmt:formatDate value="${date }" type="date" dateStyle="short"/><br>
type=time : <fmt:formatDate value="${date }" type="time"/><br>

<c:set var="parseDate" value="2018-10-25"/>
parse date : <fmt:parseDate var="dt" value="${parseDate }" pattern="yyyy-MM-dd" />
<fmt:formatDate value="${dt }" type="date" dateStyle="medium"/>


</body>
</html>