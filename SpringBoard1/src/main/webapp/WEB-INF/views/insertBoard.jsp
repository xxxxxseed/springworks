<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome~</title>
	<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<script type="text/javascript">
		function checkForm(){
			let form = document.regForm;
			
			if(form.title.value == ""){
				alert("제목을 입력해주세요");
				form.title.select();
				return false;
			}
			if(form.writer.value == ""){
				alert("작성자를 입력해주세요");
				form.writer.select();
				return false;
			}
			if(form.content.value == ""){
				alert("내용을 입력해주세요");
				form.content.select();
				return false;
			}
			form.submit();
		}
	</script>
	<div id="container">
		<section id="list">
			<h2>글 쓰기</h2>
			<form action="/insertBoard" method="post" name=regForm>
				<table class="tbl_reg">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="content" cols="50" rows="10"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="등록" onclick="checkForm()">
							<a href="/boardList"><input type="button" value="목록"></a>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>