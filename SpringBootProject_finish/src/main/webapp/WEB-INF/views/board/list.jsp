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
<title>게시물 목록 보기</title>
</head>
<body>

<div class="container">
	<h2>게시글 목록</h2>
	<button class="btn btn-primary" onclick="location.href='/board/insert'">글쓰기</button>
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>No</th>
				<th>주 제</th>
				<th>내 용</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>댓글</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${list}">
			<tr>
				<td class="info" onclick="location.href='/board/detail/${board.bno}'">${board.bno}</td>
				<td>${board.subject}</td>
				<td>${board.content}</td>
				<td>${board.writer}</td>
				<td><fmt:formatDate value='${ board.reg_date}' pattern="yyyy년-MM월-dd일 HH시 mm분 ss초"/></td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>

</layoutTag:layout>