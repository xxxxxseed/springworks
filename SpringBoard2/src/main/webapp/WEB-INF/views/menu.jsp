<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Menu</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<div class="container-fluid">
				<a href="#" class="navbar-brand">Hi-Media</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarsExample01" aria-controls="navbarsExample01"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="navbar-collapse collapse" id="navbarsExample01">
		    	<security:authorize access="isAnonymous()">
			    	<ul class="navbar-nav me-auto mb-2 mb-md-0">
			            <li class="nav-item">
				            <a class="nav-link" href="/">HOME</a>
				        </li>
			            <li class="nav-item">
				            <a class="nav-link" href="/member/signup">회원가입</a>
				        </li>
				    	<li class="nav-item">
				        	<a class="nav-link" href="/customLogin">로그인</a>
				        </li>
				    	<li class="nav-item">
				        	<a class="nav-link" href="/member/memberList">회원목록</a>
				        </li>
				        <li class="nav-item">
				            <a class="nav-link" href="/board/boardList">게시판</a>
				        </li>
				        <li class="nav-item dropdown">
				            <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">전체메뉴</a>
				            <ul class="dropdown-menu">
				            	<li><a class="dropdown-item" href="/">HOME</a></li>
				            	<li><a class="dropdown-item" href="/member/signup">회원가입</a></li>
				            	<li><a class="dropdown-item" href="/customLogin">로그인</a></li>
				            	<li><a class="dropdown-item" href="/member/memberList">회원목록</a></li>
				            	<li><a class="dropdown-item" href="/board/boardList">게시판</a></li>
				            </ul>
				        </li>
			        </ul>
		        </security:authorize>
		        
		        <security:authentication property="principal" var="pinfo"/>
		        <security:authorize access="isAuthenticated()">
		        	<ul class="navbar-nav me-auto mb-2 mb-md-0">
			            <li class="nav-item">
				            <a class="nav-link" href="/">HOME</a>
				        </li>
			            <li class="nav-item">
				            <a class="nav-link" href='/member/memberView?userid=<c:out value="${pinfo.username}"/>'>나의정보</a>
				        </li>
				    	<li class="nav-item">
				        	<a class="nav-link" href="/customLogout">(<c:out value="${pinfo.username}" />님)로그아웃</a>
				        </li>
				    	<li class="nav-item">
				        	<a class="nav-link" href="/member/memberList">회원목록</a>
				        </li>
				        <li class="nav-item">
				            <a class="nav-link" href="/board/boardList">게시판</a>
				        </li>
				        <li class="nav-item dropdown">
				            <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">전체메뉴</a>
				            <ul class="dropdown-menu">
				            	<li><a class="dropdown-item" href="/">HOME</a></li>
				            	<li><a class="dropdown-item" href="/member/memberView?userid=<c:out value="${pinfo.username}"/>">나의정보</a></li>
				            	<li><a class="dropdown-item" href="/customLogout">(<c:out value="${pinfo.username}" />님)로그아웃</a></li>
				            	<li><a class="dropdown-item" href="/member/memberList">회원목록</a></li>
				            	<li><a class="dropdown-item" href="/board/boardList">게시판</a></li>
				            </ul>
				        </li>
			        </ul>
		        </security:authorize>
			        <form role="search">
			        	<input class="form-control" type="search" placeholder="Search" aria-label="Search">
			        </form>
      			</div>
			</div>
		</nav>
</body>
</html>