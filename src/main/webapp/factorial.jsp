<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<%! 
	public int factorial(int num){
		int result = 0;
		if(num ==1){
			result = 1;
		} else {
			result = num*factorial(num-1);
		}
		return result;
	}
	
	
	%>
<body>
	<%for(int i = 1; i<9 ; i++){ %>
	factorial(<%=i %>) >>> <%=factorial(i) %><br>
	<%} %>

</body>
</html>