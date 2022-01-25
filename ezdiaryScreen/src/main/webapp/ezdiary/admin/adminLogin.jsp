<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 제이쿼리 ===================================================================================== -->
	<!-- ============================================================================================ -->
	
	<!-- css파일 ===================================================================================== -->
	<link href="../../css/admin/adminComponent.css?after" rel="stylesheet"/>
	<!-- ============================================================================================ -->
	
	<!--js파일 ======================================================================================= -->
	<script
            src="https://kit.fontawesome.com/6478f529f2.js"
            crossorigin="anonymous">
    </script>
	<!-- ============================================================================================ -->
	<title>EZ DIARY 관리자 로그인</title>
</head>
<body>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
				<h1>관리자용 로그인</h1>
			</div>
			<div class="contents_warpper">
				<!-- 유효성 검사필요, input 클릭시 boader 지우기 -->
				<div class="content contents_id">
					<div class="login_icons"><i class="far fa-user fa-2x"></i></div>
					<input type="text" placeholder="아이디">
				</div>
				<div class="content contents_pwd">
					<div class="login_icons"><i class="fas fa-lock fa-2x"></i></div>
					<input type="text" placeholder="비밀번호">
				</div>
			</div>
			<div class="content_btn_wrapper">
				<div>
					<input class="login_btn" type="button" value="LOGIN" onclick="location.href='noticeBoard.jsp'">
				</div>
			</div>
		</div>
	</div>
</body>
</html>