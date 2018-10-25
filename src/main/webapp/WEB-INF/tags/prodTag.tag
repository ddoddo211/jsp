<%@tag import="java.util.HashMap"%>
<%@tag import="java.util.Map"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="lprod" type="String" required="true"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "bms";
	String password = "java";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	Class.forName(driver);
	conn = DriverManager.getConnection(url, username, password);
	stmt = conn.createStatement();
	
	String sql = "select prod_id, prod_name from prod where prod_lgu='"+lprod+"' order by prod_lgu";
	rs = stmt.executeQuery(sql);

	Map<String,String> prod = new HashMap<String,String>();
	String prod_id = "";	String prod_name = "";
	while (rs.next()) {
		prod_id = rs.getString("prod_id");
		prod_name = rs.getString("prod_name");
		prod.put(prod_id, prod_name);
		
	}

	rs.close();
	stmt.close();
	conn.close();
	%>
	
		<select>
	<%
	
	for(String key : prod.keySet()){
		%>
			<option value="<%=key%>"><%=prod.get(key) %></option>
		<%
	}
%>
		</select>


