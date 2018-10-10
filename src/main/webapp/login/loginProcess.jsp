<%@page import="java.util.Enumeration"%>
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
<%-- login.jsp 에서 전송한 파라미터: id password --%>
<%-- request parameter 관련 메서드
	1. getParameter(String name);
	2. getParameterValues(String name);
	3. getParameterMap();
	4. getParameterNames();

 --%>
 	<%
 		String[] userIdValues = request.getParameterValues("userId");
 		
 		Map<String, String[]> requestMap = request.getParameterMap();
 		
 		// userId, password
 		Enumeration<String> parameterNames = request.getParameterNames();
 		while(parameterNames.hasMoreElements()){
 			String parameterName = parameterNames.nextElement();
 			System.out.println("parameterName : "+parameterName);
 		}
 		
 	%>
 
	request.getParameter("userId") : <%=request.getParameter("userId") %> <br>
	<%for(String str : userIdValues){
		out.write(str+"<br>");
	}
		%>
	request.getParameter("password") : <%=request.getParameter("password") %> <br>
	
	
	<h2>requestMap</h2>
	<%for(String str : requestMap.get("userId")){ %>
		str : <%=str%>
	<%	}	%> <br>
	
	requestMap.get("password") : <%=requestMap.get("password") %>
	
	<%-- jsp>> servlet
		1. 서블릿 생성 LoginServlet
			: 사용자가 보낸 파라미터를 전부 화면에 출력
			userId * 2
			password * 1
			
			userId : adfasdf
			userId : asdfasdfa
			password: pass12312
	 --%>

</body>
</html>