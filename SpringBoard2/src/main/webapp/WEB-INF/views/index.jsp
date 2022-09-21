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
</head>
<body class="d-flex h-100 text-center">
	<div class="d-flex w-100 h-100 p-0 mx-auto flex-column">
	<header class="mb-auto">
		<jsp:include page="./menu.jsp" />
	</header>
	<main class="px-3">
		<section id="main">
			<h2>메인 페이지입니다.</h2>
			<hr>
			<img src="/resources/images/activity.jpg" alt="행글라이더" id="pic">
		</section>
	</main>
	<footer class="mt-auto bg-dark">
		<jsp:include page="./footer.jsp" />
	</footer>
	</div>
<script type="text/javascript">
	//메인 이미지 슬라이드 효과
	let picture = ["/resources/images/activity.jpg", "/resources/images/healing.jpg"];
	let idx = 0;
	
	slideShow();	//함수 호출
	
	function slideShow(){
		document.getElementById("pic").src = picture[idx];
		idx++;
		if(idx == picture.length)
			idx = 0;
		
		setTimeout(slideShow, 2000);	//2초 간격, 콜백 함수(괄호 생략)
	}
</script>
</body>
</html>