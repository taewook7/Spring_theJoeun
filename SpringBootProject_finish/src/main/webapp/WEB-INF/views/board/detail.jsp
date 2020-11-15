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
<title>게시글 상세 정보</title>
</head>
<body>

	<div class="container">
		<h2>게시글 상세 정보</h2>
		<button class="btn btn-warning" onclick="location.href='/board/update/${detail.bno}'">수정</button>
		<button class="btn btn-danger" onclick="location.href='/board/delete/${detail.bno}'">삭제</button>
		
		<form class="form-horizontal" action="/board/lnsert" method="post">
			<div class="form-group">
				<label>제  목</label>			
				<p>${detail.subject}</p>
			</div>
			
			<div class="form-group">
				<label>작성자</label>
				<p>${detail.writer}</p>
			</div>
			<div class="form-group">
				<label>작성일자</label>
				<p>${detail.reg_date}</p>
			</div>
			<div class="form-group">
				<label>첨부파일</label>
				<p><a href="/board/fileDown/${files.bno}">${files.fileOriName}</a>
			</div>
			<div class="form-group">
				<label>내  용</label>
				<p>${detail.content} </p> 
			</div>
			<button type="submit" class="btn btn-primary">글쓰기</button>
		</form>
	</div>
</body>
</html>

</layoutTag:layout>