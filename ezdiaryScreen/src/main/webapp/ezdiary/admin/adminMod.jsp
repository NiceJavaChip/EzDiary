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
	<!-- ============================================================================================ -->
	
	<!--js파일 ======================================================================================= -->
	<script
            src="https://kit.fontawesome.com/6478f529f2.js"
            crossorigin="anonymous">
    </script>
	<!-- ============================================================================================ -->
	<title>EZ DIARY 관리자 질문지 수정하기</title>
</head>
<body>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
			<h1>수정하기</h1>
			</div>
			<div class="contents_warpper">
				<div class="ques_wrapper">
					<div class="ques_content">
						<div class="ques_wrapper_title">질 문</div>
						<!-- placeholder에 작성했던 질문 내용 삽입될 것 -->
						<input type="text" placeholder="">
					</div>
					<div class="write_date_content">
						<div class="ques_wrapper_title">작성일</div>
						<!-- placeholder에 질문을 작성했던 날짜 삽입될 것 -->
						<input type="text" placeholder="">
					</div>
				</div>
				<div class="answer_wrapper">
					<h2>선택지</h2>
					<div class="answer_content">
						<div class="answer_wrapper_title">1 번</div>
						<!-- placeholder에 작성했던 답변 내용 삽입될 것 -->
						<input type="text" placeholder="">
					</div>
					<div class="answer_content">
						<div class="answer_wrapper_title">2 번</div>
						<!-- placeholder에 작성했던 답변 내용 삽입될 것 -->
						<input type="text" placeholder="">
					</div>
					<div class="answer_content">
						<div class="answer_wrapper_title">3 번</div>
						<!-- placeholder에 작성했던 답변 내용 삽입될 것 -->
						<input type="text" placeholder="">
					</div>
				</div>
			</div>
			<div class="content_btn_wrapper right_align">
				<button class="content_btn" onclick="location.href='ques_notice_list.jsp'">확인</button>
				<button class="content_btn" onclick="location.href='ques_mod.jsp'">수정</button>
				<!-- 삭제 버튼은 삭제 처리 후 질문지 페이지로 이동 -->
				<!-- <button class="content_btn delete_btn" onclick="location.href='ques_notice_list.jsp'">삭제</button> -->
			</div>
		</div>
	</div>
</body>
</html>