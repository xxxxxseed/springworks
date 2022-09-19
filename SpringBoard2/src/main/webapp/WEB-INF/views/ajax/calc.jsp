<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ajax 예제</title>
	<style type="text/css">
		.result{
			border: 5px dotted #000;
			padding: 20px;
			font-size: 2rem;
		}
		.result_msg{
			border: 5px dotted #00f;
			padding: 20px;
			font-size: 2rem;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function calc(){
			let form = document.form1;
			let num1 = form.num1.value;
			let num2 = form.num2.value;
			//alert(num1 + ", " + num2);
			let action = form.action;
			//alert(action);
			
			$.ajax({
				type: "get", 
				url: action,
				dataType: "text",
				data: {
					num1: num1,	//controller(서버의 컨테이너)에 보내줌
					num2: num2
				},
				success: function(data){	//서버에서 view로 응답 처리
					$(".result").text(data);
				},
				error: function(data){
					alert("에러 발생!!");
				}
			});
		}
		
		function calc2(){
			let form = document.form1;
			let num1 = form.num1.value;
			let num2 = form.num2.value;
			//alert(num1 + ", " + num2);
			let action = form.action;
			//alert(action);
			
			$.ajax({
				type: "get", 
				url: action,
				dataType: "text",
				data: {
					num1: num1,	//controller(서버의 컨테이너)에 보내줌
					num2: num2
				},
				success: function(data){	//서버에서 view로 응답 처리
					//data의 값이 배열로 저장 [sum, msg]
					data = data.split("/");
					let sum = data[0];
					let msg = data[1]
					
					$(".result").text(sum);
					$(".result_msg").text(msg);
				},
				error: function(data){
					alert("에러 발생!!");
				}
			});
		}
		
	</script>
</head>
<body>
	<h2>계산 페이지입니다.</h2>
	
	<form action="/ajax/doPlus" method="get" name="form1">
		<input type="text" name="num1" placeholder="숫자1">
		<input type="text" name="num2" placeholder="숫자2">
		<input type="submit" value="더하기">
		<input type="button" value="더하기2" onclick="calc()">
		<input type="button" value="더하기3" onclick="calc2()">
	</form>
	
	<h2>더하기 결과</h2>
	<div class="result"></div>
	
	<h2>더하기 결과 메시지</h2>
	<div class="result_msg"></div>
</body>
</html>