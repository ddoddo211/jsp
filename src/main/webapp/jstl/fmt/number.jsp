<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="number" value="100000"></c:set>
<c:set var="numberPercent" value="1"></c:set>

<h2>기본</h2>
<fmt:formatNumber value="${number }"/> <br/>
<fmt:formatNumber value="${number }" type="currency"/> <br/>
<fmt:formatNumber value="${numberPercent }" type="percent"/> <br/>

<h2>영문</h2>
<fmt:setLocale value="en_us"/>
<fmt:formatNumber value="${number }"/> <br/>
<fmt:formatNumber value="${number }" type="currency"/> <br/>
<fmt:formatNumber value="${numberPercent }" type="percent"/> <br/>
<h2>독일</h2>
<fmt:setLocale value="de_de"/>
<fmt:formatNumber value="${number }"/> <br/>
<fmt:formatNumber value="${number }" type="currency"/> <br/>
<fmt:formatNumber value="${numberPercent }" type="percent"/> <br/>

<h2>parsenumber</h2>
<fmt:setLocale value="ko"/>
<c:set var="parseNumber" value="1,000.99"/>
<fmt:parseNumber value="${parseNumber }"/>








</body>
</html>