<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	<link rel="stylesheet" href="/resources/css/style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<!-- <script type="text/javascript" src="/resources/js/validation.js"></script> -->
	<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
	<script>
	function checkForm(){
		//변수 할당
		let id = document.getElementById("userid");
		let pwd1 = document.getElementById("userpw");
		let pwd2 = document.getElementById("userpw_confirm");
		let name = document.getElementById("username");
		let idChkVal = document.getElementById("idCheck");
		
		/* let form = document.regForm;     //폼 이름
		let id = form.userid.value;    //아이디 입력값
		let pwd1 = form.userpw.value;    //비밀번호 입력값
		let pwd2 = form.userpw_confirm.value; //비밀번호 확인 입력값
		let name = form.username.value;      //이름 입력값 */
		
		//정규식 변수 할당
		let regExpId = /^[a-zA-Z0-9]*$/ //영문자, 숫자만(^-시작, *-반복)
		let regExpPwd1 = /[a-zA-Z0-9]/  //영문자, 숫자
		let regExpPwd2 = /[~!@#$%^&*()_+/]/  //특수문자
		let regExpPwd3 = /[ㄱ-ㅎㅏ-ㅣ가-힣]/  //한글
		
		if(id.value.length < 4 || id.value.length > 12 || !regExpId.test(id.value)){
			alert("아이디는 영문자, 숫자 포함 4-12자 이하로 입력해주세요 ");
			userid.select();
			return false;
		}else if(pwd1.value.length < 8 || pwd1.value.length > 12 ||
				!regExpPwd1.test(pwd1.value) || !regExpPwd2.test(pwd1.value) ||
				regExpPwd3.test(pwd1.value)){
			alert("비밀번호는 영문자, 숫자, 특수문자 포함 8-12자 이하로 입력해주세요 ");
			userpw.select();
			return false;
		}else if(pwd1.value != pwd2.value){
			alert("비밀번호를 동일하게 입력해주세요");
			userpw_confirm.select();
			return false;
		}else if(name.value == ""){
			alert("이름을 입력해주세요");
			username.select();
			return false;
		}else if(idChkVal.value == "N"){
			alert("아이디 중복 확인을 해주세요");
			return false;
		}
	}//checkForm() 닫기
	
	function checkID(){
		//alert("check");
		$.ajax({
			type: "post",
			url: "http://localhost:8080/member/checkID?${_csrf.parameterName }=${_csrf.token }",
			dataType: "json",
			data: {"userid": $("#userid").val()},
			success: function(data){
				//alert(data);
				if(data == 1){
					$("#check").text("이미 가입된 ID입니다.");
					$("#check").css({"color": "red", "padding-top": "5px"});
				}else if(data == 0){
					$("#idCheck").attr("value", "Y");
					$("#check").text("사용 가능한 ID입니다.");
					$("#check").css({"padding-top": "5px"});
				}
			},
			error: function(data){
				alert("에러 발생");
			}
		});
	}
	</script>
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
						<td>
							<input type="text" id="userid" name="userid" placeholder="ID">
							<button type="button" id="idCheck" value="N" 
									onclick="checkID()">ID 중복</button>
							<p id="check"></p>
						</td>
						
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" id="userpw" name="userpw"
							placeholder="PASSWORD"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" id="userpw_confirm" name="userpw_confirm"
							placeholder="PASSWORD"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" id="username" name="username"></td>
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