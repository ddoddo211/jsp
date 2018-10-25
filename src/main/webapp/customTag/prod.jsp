<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("select").on("change",function(){
			var pprod_id = $(this).val();
			var pprod_name = $("select option:selected").text();
			
			$("#selectedID").val(pprod_id);
			$("#selectedNM").val(pprod_name);
			
			
		});
		
	});


</script>

</head>
<body>

<tags:prodTag lprod="P201"/>
<tags:prodTag lprod="P101"/>
<br>
선택한 상품ID : <input type="text" readonly="readonly" id="selectedID"/>
<br>
선택한 상품NM : <input type="text" readonly="readonly" id="selectedNM"/>

</body>
</html>