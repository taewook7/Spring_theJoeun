<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags" %>

<layoutTag:layout>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form class="form-horizontal" action="/board/updateProc" method="post">
		<div class="form-group">
			<label>제  목</label>
			<input type="text" class="form-control" id="subject" name="subject" value="${detail.subject}"/>
		</div>
		
		<div class="form-group">
			<label>내  용</label>
			<textarea class="form-control" id="content" name="content" rows="10" cols="100">${detail.content}</textarea>
		</div>
		
		<div class="form-group">
			<input type="hidden" name="bno" value="${bno}"/>
			<button type="submit" class="btn btn-primary">수정</button>
			
		</div>
		
	</form>
</div>
</body>
</html>


</layoutTag:layout>