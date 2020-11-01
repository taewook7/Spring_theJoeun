<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/topmenu.jsp" %>
	<h2>로그인</h2>
	<form name="loginForm" method="post">
		<table class="table table-bordered table-striped table-hover" width="400px">
			<tr>
				<td>아이디</td>
				<td> 
					<input type="text" name="userid" id="userid"/>
				</td>			
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="passwd" id="passwd" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input class="btn btn-info btn-sm" type="button" id="btnLogin" value="로그인" />
					
					
					<!--  로그인 버튼을 클릭한 후 결과에 대한 처리 -->
					<c:if test="${message=='nologin'}">
						<div style="color:red;">
							로그인을 하신 후에 사용하십시오. 
						</div>
					</c:if>
					
					<c:if test="${message=='error'}">
						<div style="color:red;">
							아이디 또는 비밀번호가 일치하지 않는다.
						</div>
					</c:if>		
					<c:if test="${message=='logout'}">
						로그아웃 처리가 되었습니다.
					</c:if>
				</td>
			</tr>
			
		</table>
	</form>
<%@ include file="../include/footer.jsp" %>

<script>
$(function() {
	// btnLogin을 클릭하였을 경우 아이디와 비밀번호가 입력되었는지 검사한다.
	// val 은 value 임   userid 의 값을 가지고와서  변수 userid 에 저장 
	$("#btnLogin").click(function() {
		var userid = $("#userid").val();   // 태그의 value 속성값
		var passwd = $("#passwd").val();

		if(userid == "") {
			alert("아이디를 입력하십시오.");
			$("#userid").focus();  //입력 포커스 이동
			return; //함수 종료
		}
		if(passwd =="") {
			alert("비밀번호를 입력하십시오.");
			$("#passwd").focus(); 
		}

		//폼데이터를 서버로 제출
		//버튼에서 submit을 안넣었기때문에 아래와 같이 작성
		document.loginForm.action="${path}/member/login_check.do";
		document.loginForm.submit();
		
	});
});

</script>
</body>
</html>













