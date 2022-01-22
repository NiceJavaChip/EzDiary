<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${path}/resources/css/userMain.css" rel="stylesheet"/> 	
<title>설문 시작</title>
</head>
<body>
	<div class="usermain_wrapper">
		<div class="content_wrapper">
			<div class="upper_title">
				<p>Ezen아카데미에서 생긴일</p>
			</div>
			<div class="main_title">
				<p>EZDIARY 설문조사</p>
			</div>
			<div class="start">
				<button class="start_btn">시작하기</button>
			</div>
			<div class="bottom_title">
				<p>20분에 캡춰하겠습니다</p>
			</div>
		</div>
	</div>
</body>
</html>