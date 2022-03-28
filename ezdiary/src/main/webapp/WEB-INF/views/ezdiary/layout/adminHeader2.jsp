<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 제이쿼리 ===================================================================================== -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- ============================================================================================ -->
	
	<!-- css파일 ===================================================================================== -->
	<link href="${path}/resources/css/admin/adminComponent.css?after" type="text/css" rel="stylesheet"/>
	<link href="${path}/resources/css/admin/layout.css?after" rel="stylesheet"/>
	<link href="${path}/resources/css/admin/btnPointer.css?after" rel="stylesheet"/>
	<link href="${path}/resources/css/admin/adminQuesViewAndMod.css?after" rel="stylesheet"/>
	<link href="${path}/resources/css/admin/listView.css?after" rel="stylesheet"/>
	<link href="${path}/resources/css/admin/userMsgView.css?after" rel="stylesheet"/>
	<link href="${path}/resources/css/admin/adminSelect.css?after" rel="stylesheet"/>
	<!-- ============================================================================================ -->
	
	<!--js파일 ======================================================================================= -->
	<script type="text/javascript" src="${path}/resources/js/admin/adminSearch.js?1"></script>
	<script
            src="https://kit.fontawesome.com/6478f529f2.js"
            crossorigin="anonymous">
    </script>
	<!-- ============================================================================================ -->
	<title>EZ DIARY 관리자 로그인</title>
</head>
<body>
	<div class="header2">
		<div class="header_colum">
			<span class="header_logo">EzDiary</span>
		</div>
		<div class="header_colum">
			<c:if test="${member != null }">
				<div class="header_content">${member.admin_name }님 안녕하세요</div>
				<div class="header_content"><button onclick="location.href='${path}/loginView'">로그아웃</button></div>
			</c:if>
			<c:if test="${member == null }">
				<script type="text/javascript">
				window.onload=function() {
					alert("다시 로그인해주세요");
					location.href="${path}/loginView";
				}
				</script>
			</c:if>
		</div>
	</div>
