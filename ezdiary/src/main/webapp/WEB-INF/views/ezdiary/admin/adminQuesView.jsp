<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/adminHeader.jsp" %>
	<div class="admin_wrapper">
		<div class="content_title">
			<h1>상세보기</h1>
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
		<div class="content_btn_wrapper right_align margin_right_add">
			<button class="content_btn" onclick="location.href='${path}/adminQuesList'">확인</button>
			<button class="content_btn margin_right_less" onclick="location.href='${path}/adminQuesMod'">수정</button>
			<!-- 삭제 버튼은 삭제 처리 후 질문지 페이지로 이동 -->
			<button class="content_btn color_change" onclick="location.href='${path}/adminQuesList'">삭제</button>
		</div>
	</div>
<%@ include file="../layout/adminFooter.jsp" %>