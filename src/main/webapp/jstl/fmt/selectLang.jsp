<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
<c:choose>
	<c:when test="${param.lang==null }">
		언어를 고르세요(기본 한국어)
	</c:when>
	<c:otherwise>
		${param.lang} 페이지
	</c:otherwise>
</c:choose>

</title>
</head>
<body>
<!-- 
1. lang 이라고 이름지어진 파라미터로 locale 을 설정
2. 만약 lang 파라미터가 없을 경우 ko를 기본값으로 사용

3. selectbox 가 변경될때 해당 언어로 페이지 재요청
4. select box 는 현재요청된 lang 파라미터 언어값이 선택되어져 있어야 함

최초 접속 : localhost / selectLang.jsp
그 이후 select box 를 변경하여 페이지 재요청
 -->
<script src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	var lang = "<%=request.getParameter("lang")%>";

	$(document).ready(function(){
		
		if(lang==""){
			$("select").val("ko");			
		} else {
			$("select").val(lang);
		}
		
		$("select").on("change",function(){
			lang = $(this).val();
			
			location.href = "/jstl/fmt/selectLang.jsp?lang="+lang;
		})
		
		
		
	});
</script>
 
 
<select>
	<option value="ko">한국어</option>
	<option value="en">english</option>
	<option value="ja">日本語</option>
</select>


<h2>언어선택하기</h2>
<fmt:setLocale value="${param.lang }"/>
<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
	<fmt:message key="hello"></fmt:message>
	<fmt:message key="visitor">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</fmt:bundle>



</body>
</html>