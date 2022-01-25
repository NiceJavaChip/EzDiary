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
	<link href="../../css/admin/adminSelect.css?after" rel="stylesheet"/>
	<!-- ============================================================================================ -->
	
	<!--js파일 ======================================================================================= -->
	<script
            src="https://kit.fontawesome.com/6478f529f2.js"
            crossorigin="anonymous">
    </script>
	<!-- ============================================================================================ -->
	<title>관리자 게시판</title>
</head>
<body>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
			<h1>EZ DIARY</h1>
			</div>
			<div class="contents_warpper">
			
			</div>
			<div class="content_btn_wrapper">
				<div class="select_btns_wrapper">
					<div class="select_btn_wrapper">					
						<div class="select_btn_img">
							<img alt="구름" src="../../image/cloud.png">
							<input class="notice_btn" type="button" value="수강생 게시판" onclick="location.href='userMsgList.jsp'">
						</div>										
					</div>
					<div class="select_btn_wrapper">					
						<div class="select_btn_img">
							<img alt="구름" src="../../image/cloud.png">
							<input class="notice_btn" type="button" value="질문지 추가 게시판" onclick="location.href='adminQuesList.jsp'">
						</div>										
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>