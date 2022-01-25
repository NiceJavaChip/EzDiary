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
	<link href="../../css/admin/adminQuesViewAndMod.css?after" rel="stylesheet"/>
	<link href="../../css/admin/userMsgView.css?after" rel="stylesheet"/>
	<!-- ============================================================================================ -->
	
	<!--js파일 ======================================================================================= -->
	<script
            src="https://kit.fontawesome.com/6478f529f2.js"
            crossorigin="anonymous">
    </script>
	<!-- ============================================================================================ -->
	<title>EZ DIARY 사용자 메시지 상세보기</title>
</head>
<body>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
			<h1>상세보기</h1>
		</div>
		<div class="contents_warpper">
			<div class="sub_content_wrapper">
					<div class="msg_view_sub_title">닉네임</div>
					<!-- placeholder에 사용자가 작성했던 닉네임이 삽입될 것 -->
					<input type="text" placeholder="">
			</div>
			<div class="sub_content_wrapper">
					<div class="msg_view_sub_title">작성일</div>
					<!-- placeholder에 내용 작성시 날짜가 삽입될 것 -->
					<input type="text" placeholder="">
			</div>
			<div class="sub_content_wrapper">
					<div class="msg_view_sub_title">내용</div>
					<!-- placeholder에 내용 작성시 날짜가 삽입될 것 -->
					<input type="text" placeholder="">
			</div>
		</div>
		<div class="content_btn_wrapper right_align">
			<button class="content_btn" onclick="location.href='adminQuesList.jsp'">확인</button>
			<!-- 저장시 어느 페이지로 넘어가는 지. -->
			<button class="content_btn color_change" onclick="location.href='adminQuesList.jsp'">삭제</button>
			<!-- 취소가 되면 질문지 LIST로 넘어가야 하는 것이 아닌지 -->
		</div>
		</div>
	</div>
</body>
</html>