<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 목록</title>
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
			<section id="list">
			<h2>회원 목록</h2>
			<table class="tbl_list">
				<thead>
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<!-- <th>비밀번호</th> -->
						<th>이 름</th>
						<th>가입일</th>
						<th>권한</th>
						<!-- <th>권한2</th> -->
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${memberList }" var="member" varStatus="status">
					<tr>
						<td><c:out value="${status.count }" /></td>
						<td><a href="/member/memberView?userid=<c:out value="${member.userid }" />"><c:out value="${member.userid }" /></a></td>
						<%-- <td><c:out value="${member.userpw }" /></td> --%>
						<td><c:out value="${member.username }" /></td>
						<td>
							<fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<%-- <td><c:out value="${member.authList.get(0) }" /></td> --%>
						<%-- <td><c:out value="${fn: split(member.authList.get(0), '=')[2] }" /></td> --%>
						<!-- replace(문자열, '이전문자', '대체할문자') -->
						<td><c:out value="${fn:replace(fn:split(member.authList.get(0), '=')[2], ')', '') }" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</section>
		</main>
		<footer class="mt-auto bg-dark">
			<jsp:include page="../footer.jsp" />
		</footer>
	</div>
</body>
</html>