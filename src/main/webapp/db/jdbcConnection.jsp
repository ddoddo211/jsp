<%@ page import = "java.sql.Connection"%>
<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.ResultSet"%>
<%@ page import = "java.sql.SQLException"%>
<%@ page import = "java.sql.Statement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>jdbcConnection.jsp</title>
</head>
<body>
	
	<%
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "bms";
		String password = "java";
		
		Connection conn = null;
		Class.forName(driver);
		try {
		
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 10; i++){
			conn = DriverManager.getConnection(url, username, password);
			out.println(" Schema : " + conn.getSchema() + "<br />");
			try {conn.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		long endTime = System.currentTimeMillis();
		out.println("conn 걸린 시간 : " + ((double)(endTime - startTime)/1000) + "sec");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	%>
	
</body>
</html>