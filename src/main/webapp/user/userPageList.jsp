<%@page import="kr.or.ddit.user.model.PageVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
	<%@ include file="/common/basicLib.jsp" %>
<style type="text/css">
	.userClick{
		cursor: pointer;
	}
	.userClick:hover {
		background: skyblue !important;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		console.log("document.ready");
		
		//tr 에 select(class="userClick")
		$(".userClick").click(function(){
			
		});
		
		$(".userClick").on("click", function(){
			console.log("userClick");
			var userId = $(this).children()[1].innerText;
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
		
	});
</script>

</head>

<form action="/userDetail" method="get" id="frm">
	<input type="hidden" id="userId" name = "userId"/>
</form>

<body>


	<%-- 지시자 --%>
	<%@ include file="/common/header.jsp" %>

	<div class="container-fluid">
		<div class="row">

	<%-- 지시자 --%>
	<%@ include file="/common/left.jsp" %>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
						<th>번호		</th>
						<th>아이디		</th>
						<th>이름		</th>
						<th>생일		</th>
				</tr>
				<% 	
					List<UserVo> userListP = (List<UserVo>)request.getAttribute("userListP");
					for(UserVo uv : userListP){
						Date birth = uv.getBirth();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String fmBirth = sdf.format(birth);
					%>
					<tr class="userClick">
						<td><%=uv.getRnum() %></td>
						<td><a href="/userDetail?userId=<%=uv.getUserId() %>"><%=uv.getUserId()%></a></td>
						<td><%=uv.getName() %></td>
						<td><%=fmBirth %></td>
					</tr>	
						
						<%
					}
					%>
			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>
		
		<%
		int totalCnt = (Integer)request.getAttribute("totalCnt");
		PageVo pageVo = (PageVo)request.getAttribute("pageVo");
		
		int startIndex = pageVo.getPage();
		if(startIndex<6){
			startIndex = 1;
		} else if(startIndex%5==0) {
			startIndex -= 4;
		} else {
			startIndex = startIndex-(startIndex%5)+1;
		}
		int endIndex = startIndex +5;
		int moveFoward = startIndex-5;
		if(moveFoward<0){
			moveFoward = 1;
		}
		if(endIndex > totalCnt/pageVo.getPageSize()+1){
			endIndex = totalCnt/pageVo.getPageSize()+2;
		}
		
		%>

		<div class="text-center">
			<ul class="pagination">
			<li><a href="/userPageList?pageNum=<%=moveFoward%>"><</a></li>
			<%
			for(int pg = startIndex;pg < endIndex;pg++){
				if(pg==pageVo.getPage()){
					%><li><a href="/userPageList?pageNum=<%=pg%>" style="background:#428bca; color:white;"><%=pg%></a></li><%
				} else{
				%>
				<li><a href="/userPageList?pageNum=<%=pg%>"><%=pg%></a></li>
				<%
				}
			}
			%>
			<li><a href="/userPageList?pageNum=<%=endIndex%>">></a></li>
			</ul>
		</div>
	</div>
</div>
				


			</div>
		</div>
	</div>
</body>
</html>
