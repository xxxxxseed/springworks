<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<section id="view">
			<h2>글 상세 보기</h2>
			<form action="/board/updateBoard" method="post">
				<!-- 수정 시에 기본키 속성이 반드시 필요함 -->
				<input type="hidden" name="bno" value="${board.bno }">
				<!-- 수정, 삭제시에 페이지 번호 유지(안하면 무조건 1페이로 이동) -->
				<input type="hidden" name="pageNum" value="${cri.pageNum }">
				<input type="hidden" name="amount" value="${cri.amount }">
				<input type="hidden" name="type" value="${cri.type }">
				<input type="hidden" name="keyword" value="${cri.keyword }">
				<table class="tbl_view">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" value="${board.title }"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer" value="${board.writer }"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="content" 
								cols="50" rows="10"><c:out value="${board.content }" /></textarea>
						</td>
					</tr>
					<tr>
						<td>등록일</td>
						<td class="time">
							<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
					</tr>
					<tr>
						<td>조회수</td>
						<td><input type="text" name="cnt" value="${board.cnt }"></td>
					</tr>
					<tr>
						<td colspan="2">
						<security:authentication property="principal" var="pinfo" />
						<security:authorize access="isAuthenticated()">
						<c:if test="${pinfo.username eq board.writer }">
							<input type="submit" value="수정">
							<a href="/board/deleteBoard?bno=<c:out value="${board.bno }" />"
								onclick="return confirm('해당 게시글을 삭제하시겠습니까?')">
								<input type="button" value="삭제">
							</a>
						</c:if>
						</security:authorize>
							<a href="/board/boardList"><input type="button" value="목록" class="listBtn"></a>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			</form>
		</section>
		<!-- 페이지 처리 전송 폼 -->
		<form action="/board/boardList" method="get" id="actionForm">
			<input type="hidden" name="bno" value="${board.bno }">
			<input type="hidden" name="pageNum" value="${cri.pageNum }">
			<input type="hidden" name="amount" value="${cri.amount }">
			<input type="hidden" name="type" value="${pageMaker.cri.type }">
			<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
		</form>
		<!-- 댓글 영역 -->
		<div class="comment">
			<h4>댓글</h4>
			<ul class="replyList">
				<c:forEach items="${replyList }" var="list">
					<li>
						<p>작성자: <c:out value="${list.replyer }" />&nbsp;&nbsp;
							(작성일: <fmt:formatDate value="${list.replyDate }"
										pattern="yyyy-MM-dd HH:mm:ss"/>)
						</p>
						<p class="content"><c:out value="${list.reply }" /></p>
					</li>
				</c:forEach>
			</ul>
		</div>
		<!-- 댓글 등록폼 -->
		<form action="" method="post" id="replyForm" class="replyForm">
			<input type="hidden" name="bno" value="${board.bno }">
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			<ul>
				<li>
					<label>작성자</label>
					<input type="text" name="replyer" id="replyer"
							value="<security:authentication property="principal.username"/>">
				</li>
				<li>
					<textarea rows="4" cols="60" name="reply" id="reply"></textarea>
					<button type="button" class="replyBtn">댓글 등록</button>
				</li>
			</ul>
		</form>
		</main>
		<footer class="mt-auto bg-dark">
			<jsp:include page="../footer.jsp" />
		</footer>
	</div>
	
<script type="text/javascript">
	$(document).ready(function(){	//제이쿼리 환경
		//목록 버튼 이벤트
		let actionForm = $("#actionForm");
	
		$(".listBtn").click(function(e){
			e.preventDefault();		//기본 동작 막아줌
			actionForm.submit();
		});
		
		//댓글 등록 이벤트 처리
		let replyForm = $("#replyForm");
		$(".replyBtn").click(function(e){
			e.preventDefault();
			console.log("click...");
			
			replyForm.attr("action", "/board/reply");
			replyForm.submit();
		});
	});
</script>

</body>
</html>