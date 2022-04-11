<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
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
