<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome~</title>
	<link rel="stylesheet" href="/resources/css/style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
</head>
<body class="d-flex h-100 text-center">
	<div class="d-flex w-100 h-100 p-0 mx-auto flex-column">
		<header class="mb-auto">
			<jsp:include page="../menu.jsp" />
		</header>
		<main class="px-3">
			<section id="list">
			<h2>글 삭제</h2>
			<form action="/board/replyDelete" method="post" id="deleteForm">
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
				<input type="hidden" name="bno" value="${selectReply.bno }">
				<input type="hidden" name="rno" value="${selectReply.rno }">
				
				<div>
					<h3>해당 댓글을 삭제하시겠습니까?</h3>
					<button type="submit" class="deleteBtn">예</button>
					<button type="button" class="cancelBtn">아니오</button>
				</div>
			</form>
		</section>
		</main>
		<footer class="mt-auto bg-dark">
			<jsp:include page="../footer.jsp" />
		</footer>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		let deleteForm = $("#deleteForm");
		
		$(".cancelBtn").click(function(e){
			e.preventDefault();
			console.log("click...");
			
			deleteForm.attr("method", "get");
			deleteForm.attr("action", "/board/boardView?bno=${selectReply.bno}");
			deleteForm.submit();
		});
	});
</script>
</body>
</html>