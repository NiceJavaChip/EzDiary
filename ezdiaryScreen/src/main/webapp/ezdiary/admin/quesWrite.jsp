<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/adminHeader.jsp" %>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
			<h1>질문지 작성</h1>
			</div>
			<div class="contents_warpper">
				<div class="ques_wrapper">
					<div class="ques_content">
						<div class="ques_wrapper_title">질 문</div>
						<!-- placeholder에 작성했던 질문 내용 삽입될 것 -->
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
				<button class="content_btn" onclick="location.href='adminQuesList.jsp'">저장</button>
				<!-- 저장시 어느 페이지로 넘어가는 지. -->
				<button class="content_btn color_change" onclick="location.href='adminQuesList.jsp'">취소</button>
				<!-- 취소가 되면 질문지 LIST로 넘어가야 하는 것이 아닌지 -->
			</div>
		</div>
	</div>
<%@ include file="../layout/adminFooter.jsp" %>