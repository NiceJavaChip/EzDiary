<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/adminHeader.jsp" %>
<c:set var="askInfo" value="${articleMap.getAskInfo}"/>
<c:set var="answerInfo" value="${articleMap.answerInfoList}"/>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
			<h1>수정하기</h1>
			</div>
			<form id="modifyForm" name="modifyForm" action="${path}/adminQuesMod" method="post" enctype="multipart/form-data">
				<div class="contents_warpper">
					<div class="ques_wrapper">
						<div class="ques_content">
							<div class="ques_wrapper_title">글 번호</div>
							<!-- placeholder에 작성했던 질문 내용 삽입될 것 -->
							<input type="text" name="ask_cntnt" value="<c:out value='${askInfo.ask_idx}'/>">
							<div class="ques_wrapper_title">질 문</div>
							<!-- placeholder에 작성했던 질문 내용 삽입될 것 -->
							<input type="text" name="ask_cntnt" value="${askInfo.ask_cntnt}">
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
							<input type="text" name="answer_idx" value='<c:out value="${answerInfo.answer_cntnt}"/>'>
							</div>
						</c:forEach>
						<!-- <div class="answer_content">
							<div class="answer_wrapper_title">1 번</div>
							placeholder에 작성했던 답변 내용 삽입될 것
							<input type="text" placeholder="">
						</div>
						<div class="answer_content">
							<div class="answer_wrapper_title">2 번</div>
							placeholder에 작성했던 답변 내용 삽입될 것
							<input type="text" placeholder="">
						</div>
						<div class="answer_content">
							<div class="answer_wrapper_title">3 번</div>
							placeholder에 작성했던 답변 내용 삽입될 것
							<input type="text" placeholder="">
						</div> -->
					</div>
				</div>
				<div class="content_btn_wrapper right_align">
					<button id="quesModCancelBtn" class="content_btn" onclick="backToList(modifyForm)">취소</button>
					<button id="quesModBtn" class="content_btn color_change" <%-- onclick="location.href='${path}/adminQuesView'" --%>>수정</button>
					<!-- 삭제 버튼은 삭제 처리 후 질문지 페이지로 이동 -->
					<!-- <button class="content_btn delete_btn" onclick="location.href='ques_notice_list.jsp'">삭제</button> -->
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		let modifyForm = $("#modifyForm");
		
		$('#quesModBtn').on("click",function(e){
			modifyForm.submit();
		});
		
		/* function ModSucess(obj) {
			obj.action="adminQuesView?ask_idx=${askInfo.ask_idx}";
			obj.submit();
		} */
		
		function backToList(obj) {
			obj.action="adminQuesView?ask_idx=${askInfo.ask_idx}";
			obj.submit();
		}
	</script>
<%@ include file="../layout/adminFooter.jsp" %>