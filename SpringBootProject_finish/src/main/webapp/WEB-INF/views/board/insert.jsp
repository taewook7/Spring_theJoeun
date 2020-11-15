<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags" %>

<layoutTag:layout>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>

<div class="container">
	<h2>게시글 작성</h2>
	<form class="form-horizontal" action="/board/insertProc" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label class="control-label col-sm-2">제 목</label>
			<div class="col-sm-2">
			<input type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하십시오."/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">작성자</label>
			<div class="col-sm-2">
			<input type="text" class="form-control" id="writer" name="writer" placeholder="작성자를 입력하십시오."/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">내 용</label>
			<div class="col-sm-8">
			<textarea rows="6" cols="100" id="content" name="content" placeholder="내용을 입력하십시오." ></textarea>
			</div>
		</div>
		
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
				<input type="file" name="files">
				<button type="submit" class="btn btn-primary">글작성</button>
			</div>
		</div>
		
		
	</form>
</div>


</body>
</html>



</layoutTag:layout>