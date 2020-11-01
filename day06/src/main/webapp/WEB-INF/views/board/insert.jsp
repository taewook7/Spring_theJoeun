<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 등록</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/topmenu.jsp" %>
	<h1>게시글 등록</h1><hr>
	
	<form class="form-horizontal" action="/board/insert" method="post">
		<div class="form-group">
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				<h3 align="center">회원 가입 정보</h3>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">제  목</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="b_title" name="b_title"
					placeholder="게시글 제목"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">내  용</label>
			<div class="col-sm-5">
				<textarea rows="6" cols="100" name="b_detail" placeholder="게시글 내용"></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">이  름</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="b_writer" name="b_writer"
					placeholder="게시글 작성자"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-2">
				<button type="submit" class="btn_button">등록</button>
			</div>
		</div>
	</form>
	
	<%@ include file="../include/footer.jsp" %>
</body>
</html>












