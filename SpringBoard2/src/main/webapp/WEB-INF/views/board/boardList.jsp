<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>목로 보기</title>
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
			<h2>글 목록</h2>
			<form action="/board/boardList" method="get" id="searchForm">
				<select name="type">
					<option value="T">제목</option>
					<option value="C">내용</option>
					<option value="W">작성자</option>
					<option value="TC">제목 OR 내용</option>
					<option value="TW">제목 OR 작성자</option>
					<option value="TWC">제목 OR 작성자 OR 내용</option>
				</select>
				<input type="text" name="keyword" class="keyword"
						value="${pageMaker.cri.keyword }">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
				<button type="button">Search</button>
			</form>
			<table class="tbl_list">
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th>
				</tr>
				<c:forEach items="${boardList }" var="board">
				<tr>
					<td><c:out value="${board.bno }" /></td>
					<td><a class="move" href='<c:out value="${board.bno }" />'>
							<c:out value="${board.title }" />
							<!-- 댓글 개수 -->
							[<c:out value="${board.replyCnt }" />]
						</a>
					</td>
					<td><c:out value="${board.writer }" /></td>
					<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td><c:out value="${board.cnt }" /></td>
				</tr>
				</c:forEach>
			</table>
			<!-- pagination(페이징) -->
			<div>
				<ul>
				<!-- 이전(Previous) 메뉴 -->
				<c:if test="${pageMaker.prev }">
					<li class="page-link">
						<a href="${pageMaker.startPage - 1 }">이전</a>
					</li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" 
							var="num">
					<!-- 현재 페이지 활성화-->
					<c:if test="${pageMaker.cri.pageNum eq num }">
					<li class="page-link">
						<b><a href="${num }" style="color: blue">
							<c:out value="${num }" /></a>
						</b>
					</li>
					</c:if>
					<c:if test="${pageMaker.cri.pageNum ne num }">
					<li class="page-link">
						<a href="${num }"><c:out value="${num }" /></a>
					</li>
					</c:if>
				</c:forEach>
				<!-- 다음(Next) 메뉴 -->
				<c:if test="${pageMaker.next }">
					<li class="page-link">
						<a href="${pageMaker.endPage + 1 }">다음</a>
					</li>
				</c:if>
				</ul>
			</div>
			<!-- 페이지 처리와 검색 전송 폼 -->
			<form action="/board/boardList" method="get" id="actionForm">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
				<input type="hidden" name="type" value="${pageMaker.cri.type }">
				<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
			</form>
			
			<div class="btn_box">
				<a href="/board/insertBoard"><button type="button">글쓰기</button></a>
			</div>
		</section>
		</main>
		<footer class="mt-auto bg-dark">
			<jsp:include page="../footer.jsp" />
		</footer>
	</div>

<script type="text/javascript">
	$(document).ready(function(){	//제이쿼리 환경
		let actionForm = $("#actionForm");
		//페이지 이동
		$(".page-link a").on("click", function(e){
			e.preventDefault();		//기본 동작 제한(링크 걸리지 않음)
			let targetPage = $(this).attr("href");	//클릭한 페이지
			console.log(targetPage);
			
			actionForm.find("input[name='pageNum']").val(targetPage);
			actionForm.submit();
		});
		
		//상세 페이지로 전송
		$(".move").on("click", function(e){
			e.preventDefault();
			
			let targetBno = $(this).attr("href");
			console.log(targetBno);
			
			actionForm.append("<input type='hidden' name='bno' value='" + targetBno + "'>");
			actionForm.attr("action", "/board/boardView");
			actionForm.submit();
		});
		
		//검색 폼 처리
		let searchForm = $("#searchForm");
		$("#searchForm button").click(function(e){
			e.preventDefault();
			console.log("click");
			
			searchForm.find("input[name='pageNum']").val(1);	//1페이지부터 검색
			searchForm.submit();
		});
	});
</script>

</body>
</html>