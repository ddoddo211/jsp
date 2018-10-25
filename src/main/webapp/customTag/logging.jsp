<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.C1{color:red;}
	.C2{color:orange;}
	.C3{color:yellow;}
	.C4{color:green;}
	.C5{color:blue;}
	.C6{color:black;}
	.C7{color:grey;}
	.C8{color:skyblue;}
	.C9{color:magenta;}
	.C10{color:pink;}
</style>
</head>
<body>

<tags:loggingTag/>
<c:forEach begin="1" end="10" var="i">
${i } // 
</c:forEach>
<tags:loggingTag/>

<h2>color logging tag</h2>
<tags:loggingTag/>


<tags:colorLogging length="10" color="blue"/>
<c:forEach begin="1" end="10" var="i">
${i } // <br>
</c:forEach>
<tags:colorLogging length="10" color="orange"/>


<tags:colorLogging color="orange"/>

</body>
</html>