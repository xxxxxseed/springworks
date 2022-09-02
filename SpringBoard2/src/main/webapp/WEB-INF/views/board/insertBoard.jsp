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
	<script type="text/javascript">
		function checkForm(){
			let form = document.newWrite;		//폼 이름
			let title = form.title.value;		//제목 입력값
			let writer = form.writer.value;		//작성자 입력값
			let content = form.content.value;	//내용 입력값
			
			if(title == ""){
				alert("제목을 입력해주세요");
				form.title.select();
				return false;
			}
			if(writer == ""){
				alert("작성자를 입력해주세요");
				form.writer.select();
				return false;
			}
			if(content == ""){
				alert("내용을 입력해주세요");
				form.content.select();
				return false;
			}
		}
	</script>
</head>
<body class="d-flex h-100 text-center">
	<div class="d-flex w-100 h-100 p-0 mx-auto flex-column">
		<header class="mb-auto">
			<jsp:include page="../menu.jsp" />
		</header>
		<main class="px-3">
			<section id="list">
			<h2>글 쓰기</h2>
			<form action="/board/insertBoard" method="post" 
				onsubmit="return checkForm()" name="newWrite">
				<table class="tbl_reg">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" placeholder="Title"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer" readonly="readonly"
								value="<security:authentication property="principal.username"/>"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="content" cols="50" rows="10"
								placeholder="Content"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록">
							<a href="/board/boardList"><input type="button" value="목록"></a>
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