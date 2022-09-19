<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><spring:message code="message.user.login.title" /></title>
	<link rel="stylesheet" href="/resources/css/style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</head>
<body class="d-flex h-100 text-center">
	<div class="d-flex w-100 h-100 p-0 mx-auto flex-column">
		<header class="mb-auto">
			<jsp:include page="./menu.jsp" />
		</header>
		<main class="px-3">
			<section id="login">
			<div class="title">
				<h2><spring:message code="message.user.login.title" /></h2>
			</div>
			<p class="lang">
				<a href="customLogin?lang=ko">
					<spring:message code="message.user.login.language.ko" /> |
				</a>
				<a href="customLogin?lang=en">
					<spring:message code="message.user.login.language.en" />
				</a>
			</p>
			<h2 class="error"><c:out value="${error }" /></h2>
			<form action="/login" method="post">
				<table class="tbl_login">
					<tr>
						<td><spring:message code="message.user.login.id" /></td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td><spring:message code="message.user.login.password"/></td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="<spring:message code="message.user.login.loginBtn"/>">
							<input type="reset" value="<spring:message code="message.user.login.resetBtn"/>">
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			</form>
		</section>
		</main>
		<footer class="mt-auto bg-dark">
			<jsp:include page="./footer.jsp" />
		</footer>
	</div>
</body>
</html>