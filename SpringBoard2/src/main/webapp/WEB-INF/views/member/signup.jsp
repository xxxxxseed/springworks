<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	<link rel="stylesheet" href="/resources/css/style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<script type="text/javascript" src="/resources/js/validation.js"></script>
</head>
<body class="d-flex h-100 text-center">
	<div class="d-flex w-100 h-100 p-0 mx-auto flex-column">
		<header class="mb-auto">
			<jsp:include page="../menu.jsp" />
		</header>
		<main class="px-3">
			<section id="signup">
			<h2>회원 가입</h2>
			<form action="/member/signup" method="post" 
				onsubmit="return checkForm()" name="regForm">
				<table class="tbl_signup">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userid" placeholder="ID"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userpw"
							placeholder="PASSWORD"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="userpw_confirm"
							placeholder="PASSWORD"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록">
							<input type="reset" value="취소">
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