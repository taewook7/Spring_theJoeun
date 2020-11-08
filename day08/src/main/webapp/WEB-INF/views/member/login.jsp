<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>

<div class="container">
<%@ include file="../include/topmenu.jsp" %>

	<h2>로그인</h2>
	<form method="post" action="/member/login">
		<!-- 로그인을 하지 않고 들어온 경우 -->
		<c:if test="${member == null}"> 
			<table class="table table-bordered table-striped table-hover" width="400px">
				<tr>
					<td width="100">아이디</td>
					<td><input type="text" name="userid" id="userid"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="passwd" id="passwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" id="submit">로그인</button>
						<button type="button" onclick="myfunc()">회원가입</button>
					</td>
				</tr>
			</table>		
		</c:if>
		<!-- 정상적으로 로그인을 하여 세션값을 받아온 경우 -->
		<c:if test="${member != null}">
			<div>
				<p><h2>${member.userid}님 환영합니다.</h2></p>
				<button id="memberUpdateBtn" type="button">회원정보수정</button>
				<button id="logoutBtn" type="button">로그아웃</button>
			</div>
		</c:if>
		<c:if test="${msg == false}">
			<p style="color: red; background: yellow;"><h3>로그인을 실패하였습니다. 아이디와 비밀번호를 확인하세요.</h3></p>
		</c:if>
	</form>
		
		<!-- 	회원탈퇴 버튼을 눌렀는데, 비밀번호가 맞지 않으면 메시지를 보여준다. -->
	<div class="col-sm-offset-2 col-sm-8">
		<c:if test="${msg == true}">
			<p style="color:red; background: #dcdcdc;"><h3>회원탈퇴가 완료되었습니다.</h3></p>
		</c:if>
	</div>
	
	

<%@ include file="../include/footer.jsp" %>
<script>
function myfunc() {
	alert("나만의 기능");
}
</script>

<script type="text/javascript">
$(document).ready(function() {
	// 로그아웃 버튼을 눌렀을 경우
	$("#logoutBtn").on("click", function() {
		location.href="/member/logout";
	});

	// 로그인 버튼을 눌렀을 경우
	$("#submit").on("click", function(){
		if($("#userid").val()==""){
			alert("아이디를 입력해주세요.");
			$("#userid").focus();
			return false;
		}
		if($("#passwd").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#passwd").focus();
			return false;
		}
	});

	// 회원정보 수정 버튼이 클릭된 경우 수정하는 페이지로 이동한다.
	$("#memberUpdateBtn").on("click",function() {
		location.href="/member/memberUpdateView";	

	});
});
</script>

</div>

</body>
</html>

















