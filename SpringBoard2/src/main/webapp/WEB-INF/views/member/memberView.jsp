<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보</title>
	<link rel="stylesheet" href="/resources/css/style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</head>
<body class="d-flex h-100 text-center">
	<div class="d-flex w-100 h-100 p-0 mx-auto flex-column">
		<header class="mb-auto">
			<jsp:include page="../menu.jsp" />
		</header>
		<main class="px-3">
			<section id="memberView">
			<h2>회원 정보</h2>
			<form action="/member/update" method="post" 
				onsubmit="return checkForm()" name="newWrite">
				<table class="tbl_signup">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userid" value="${member.userid }"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userpw"
							value="${member.userpw }"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="userpw_confirm"
							value="${member.userpw }"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="username" value="${member.username }"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정">
							<a href="/member/delete?userid=<c:out value="${member.userid }" />"
								onclick="return confirm('정말로 탈퇴하시겠습니까?')">
								<input type="button" value="탈퇴">
							</a>
							<a href="/member/memberList"><input type="button" value="목록"></a>
							
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			</form>
		</section>
		</main>
		<footer class="mt-auto bg-dark">
			<jsp:include page="../footer.jsp" />
		</footer>
	</div>
</body>
</html>