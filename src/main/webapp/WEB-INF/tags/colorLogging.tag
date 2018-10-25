<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" type="Integer" required="false"%>
<%@ attribute name="color" type="String" required="true"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
	<c:when test="${length==null }">
		<c:set var="leng">20</c:set>
		
	</c:when>
	
	<c:otherwise>
		<c:set var="leng">${length }</c:set>
	
	</c:otherwise>
</c:choose>




<c:forEach var="i" begin="1" end="${leng }"><span class="C${i }">=</span></c:forEach>

<font color="${color }">
<span>
logging
</span>
</font>

<c:forEach var="i" begin="1" end="${leng }"><span class="C${i }">=</span></c:forEach>
<br>
<%--
length : 5
=======logging=======
--%>