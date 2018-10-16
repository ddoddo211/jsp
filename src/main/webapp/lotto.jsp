<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
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

	int no = (int) (Math.random() * 19 + 1);
	String sql = "select * from jspstudent where no=" + no;
	rs = stmt.executeQuery(sql);

	String name = "";
	if (rs.next()) {
		name = rs.getString("name");
	}
	System.out.println(name);

	rs.close();
	stmt.close();
	conn.close();
%>
<script type="text/javascript">
	$(document).ready(function(){
		
		setInterval($(function move() {
			$('.hello').animate({
				top : 100,
				left : 200
				
			}, function() {
				$('.hello').animate({
					top : 50,
					left : 50
				});
			});
			$("input").val("<%=name%>");
		})
		,10);
	});
</script>
<style type="text/css">
.hello {
	width: 50px;
	height: 50px;
	background: pink;
	position: absolute;
	top: 50px;
	left: 50px;
	border-radius: 50px;
}
</style>

</head>
<body>
	<!-- 	<canvas id="myCanvas" width="200" height="200" -->
	<!-- 		style="border : 1px solid black"></canvas> -->
	<!-- 	
<script type="text/javascript">
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	//ctx.fillStyle = "#FF0000";  
	//ctx.fillRect(0,0,150,75); // 사각형
	ctx.beginPath();
	//좌표x, 중심좌표y, 반지름
	ctx.arc(100,100,100,0,2*Math.PI);
	ctx.stroke();
	var name = "";
	ctx.font="60px Arial";
	ctx.fillText("",10,120);
</script>
 -->
	<div class="hello"><input type="text"/></div>


</body>
</html>















