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

</head>

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
			
				<c:forEach items="${userList }" var="vo" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${vo.userId}</td>
						<td>${vo.name}</td>
						<td><fmt:formatDate value="${vo.birth}" pattern="yyyy-MM-dd" /></td>
					</tr>	
					
				</c:forEach>
				
				
			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>
	<form action="/userAllList" method="get">
		<div class="text-center">
			<ul class="pagination">
				<%
				List<UserVo> userList = (List<UserVo>)request.getAttribute("userList");
				PageVo pageVo = (PageVo)request.getAttribute("pageVo");
				int pageSize = pageVo.getPageSize();
				int userListSize = userList.size();
				System.out.println("pageSize : "+pageSize);
				System.out.println("userListSize : "+userListSize);
				for(int pg = 0; pg < (userListSize/pageSize+1);pg++){
					%>
				<li><a href="/userAllList?pageNum=<%=pg+1%>"><%=pg+1 %></a></li>
					
					<%
					}
				%>
			</ul>
		</div>
	</form>
	</div>
</div>
				


			</div>
		</div>
	</div>
</body>
</html>
