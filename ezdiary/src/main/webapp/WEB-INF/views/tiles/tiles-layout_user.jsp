<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!-- 공통변수 처리 -->
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<c:set var="RESOURCES_PATH" value="${CONTEXT_PATH}/resources" scope="application"/>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<!-- 제이쿼리 ===================================================================================== -->
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script language="javascript" src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
		<!-- ============================================================================================ -->
		
		<!-- css파일 ===================================================================================== -->
		<link href="${path}/resources/css/user/userMain.css?after" rel="stylesheet"/>
		<link href="${path}/resources/css/user/layout.css?after" rel="stylesheet"/>
		<link href="${path}/resources/css/user/userMsg.css?after" rel="stylesheet"/>
		<link href="${path}/resources/css/user/userResult.css?after" rel="stylesheet"/>
		<!-- ============================================================================================ -->
		<!--js파일 ======================================================================================= -->
		<script type="text/javascript" src="${path}/resources/js/user/userMain.js?after"></script>
		<!-- ============================================================================================ -->
	    <title><tiles:insertAttribute name="title" /></title>
  </head>
  <body>
  		<tiles:insertAttribute name="header" />
	  	<tiles:insertAttribute name="body"/>
  		<tiles:insertAttribute name="foot" />
  </body>
</html>