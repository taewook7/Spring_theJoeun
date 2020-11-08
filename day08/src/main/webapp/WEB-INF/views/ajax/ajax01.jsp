<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/topmenu.jsp" %>
	<h1>Ajax Test</h1>
	<p id="data1">이 곳에 데이터를 불러오겠습니다.</p>
	<button id="readBtn" class="btn btn-info">데이터 불러오기</button>








<%@ include file="../include/footer.jsp" %>

<script>
$(function() {
	$("#readBtn").on("click",function() {
		$("#data1").load("ajaxReadData.txt");
	});
});
</script>
	
</body>
</html>