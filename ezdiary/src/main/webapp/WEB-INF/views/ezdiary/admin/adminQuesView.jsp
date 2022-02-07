<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/adminHeader.jsp" %>
<c:set var="askInfo" value="${articleMap.getAskInfo}"/>
<c:set var="answerInfo" value="${articleMap.answerInfoList}"/>
	<div class="admin_wrapper">
		<div class="content_title">
			<h1>상세보기</h1>
		</div>
		<div class="contents_warpper">
			<div class="ques_wrapper">
				<div class="ques_content">
					<div class="ques_wrapper_title">질 문</div>
					<!-- placeholder에 작성했던 질문 내용 삽입될 것 -->
					<input type="text" readonly="readonly" name="ask_cntnt" value="<c:out value='${askInfo.ask_cntnt}'/>">
				</div>
				<div class="write_date_content">
					<div class="ques_wrapper_title">작성일</div>
					<!-- placeholder에 질문을 작성했던 날짜 삽입될 것 -->
					<input type="text" readonly="readonly" name="write_date" value='<c:out value="${askInfo.write_date}"/>'>
				</div>
			</div>
			<div class="answer_wrapper">
				<h2>선택지</h2>
				<c:forEach var="answerInfo" items="${answerInfo}" varStatus="status">
					<div class="answer_content">
					<div class="answer_wrapper_title">${status.count} 번</div>
					<!-- placeholder에 작성했던 답변 내용 삽입될 것 -->
					<input type="text" readonly="readonly" name="answer_idx" value='<c:out value="${answerInfo.answer_cntnt}"/>'>
				</div>
				</c:forEach>
				
				<%-- <div class="answer_content">
					<div class="answer_wrapper_title">1 번</div>
					<!-- placeholder에 작성했던 답변 내용 삽입될 것 -->
					<input type="text" readonly="readonly" name="answer_idx" value='<c:out value="${answerInfo.answer_idx}"/>'>
				</div>
				<div class="answer_content">
					<div class="answer_wrapper_title">2 번</div>
					<!-- placeholder에 작성했던 답변 내용 삽입될 것 -->
					<input type="text" readonly="readonly" name="answer_idx" value='<c:out value="${answerInfo.answer_idx}"/>'>
				</div>
				<div class="answer_content">
					<div class="answer_wrapper_title">3 번</div>
					<!-- placeholder에 작성했던 답변 내용 삽입될 것 -->
					<input type="text" readonly="readonly" name="answer_idx" value='<c:out value="${answerInfo.answer_idx}"/>'>
				</div> --%>
			</div>
		</div>
		<div class="content_btn_wrapper right_align margin_right_add">
			<button class="content_btn" onclick="location.href='${path}/adminQuesList'">확인</button>
			<button class="content_btn margin_right_less" id="moveModFormBtn"
				onclick="location.href='${path}/adminQuesModPage?ask_idx=<c:out value="${askInfo.ask_idx}"/><c:forEach items="${answerInfo}" var="answerInfo">&answer_idx=<c:out value="${answerInfo.answer_idx}"/></c:forEach>'">
						수정</button>
			<%-- <a id="moveModFormBtn" href='${path}/adminQuesModPage?ask_idx=
													<c:out value="${askInfo.ask_idx}"/>
													<c:forEach items="${answerInfo}" var="answerInfo">
													&answer_idx=<c:out value="${answerInfo.answer_idx}"/>
													</c:forEach>'>수정</a> --%>
				<%-- <button class="content_btn margin_right_less" id="moveModFormBtn">
				<a id="moveModFormBtn" href='${path}/adminQuesModPage?ask_idx=
													<c:out value="${askInfo.ask_idx}"/>
													<c:forEach items="${answerInfo}" var="answerInfo">
													&answer_idx=<c:out value="${answerInfo.answer_idx}"/>
													</c:forEach>'>수정</a></button> --%>
			<!-- 삭제 버튼은 삭제 처리 후 질문지 페이지로 이동 -->
			<button class="content_btn color_change" onclick="location.href='${path}/adminQuesList'">삭제</button>
		</div>
	</div>
	<form method="get" id="moveModForm"></form>
<%@ include file="../layout/adminFooter.jsp" %>