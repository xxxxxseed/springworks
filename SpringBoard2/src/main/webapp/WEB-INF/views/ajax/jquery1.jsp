<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jquery 예제</title>
	<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("button").click(function(){
				$("h2").css("color", "blue");
				//empty() 이전 내용 제거
				//$("#msg").empty().append("<p>고맙습니다.</p>");		//append(html 추가)
				$("#msg").text("고맙습니다");
			});
		});
	</script>
</head>
<body>
	<h2>jQuery 예제</h2>
	
	<button type="button">전송</button>
	<div id="msg"></div>
</body>
</html>