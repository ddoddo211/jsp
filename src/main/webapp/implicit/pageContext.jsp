<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 내장객체(implicit) 
	request, response, session, application, out, pageContext
--%>
<%
	out.equals(pageContext.getOut());
	pageContext.getRequest();
	
	//out, request
	//response, session, page
	//application
%>                                                                                                                  <br>
out.equals(pageContext.getOut()) : <%=out.equals(pageContext.getOut()) %>                                           <br>
request.equals(pageContext.getRequest()) : <%=request.equals(pageContext.getRequest()) %>                           <br>
response.equals(pageContext.getResponse()) : <%=response.equals(pageContext.getResponse()) %>                       <br>
session.equals(pageContext.getSession()) : <%=session.equals(pageContext.getSession()) %>                           <br>
page.equals(pageContext.getPage()) : <%=page.equals(pageContext.getPage()) %>                                       <br>
application.equals(pageContext.getServletContext()) : <%=application.equals(pageContext.getServletContext()) %>     <br>

</body>
</html>