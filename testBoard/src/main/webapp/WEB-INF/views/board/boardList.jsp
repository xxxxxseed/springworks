<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
	<style type="text/css">
		table, th, td{border: 1px solid #ccc; border-collapse: collapse;}
	</style>
</head>
<body>
	<table>
		<tr>
			<th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th>
		</tr>
	<c:forEach items="${boardList }" var="board">
		<tr>
			<td><c:out value="${board.bno }" /></td>
			<td><c:out value="${board.title }" /></td>
			<td><c:out value="${board.writer }" /></td>
			<td><c:out value="${board.regDate }" /></td>
			<td><c:out value="${board.cnt }" /></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>