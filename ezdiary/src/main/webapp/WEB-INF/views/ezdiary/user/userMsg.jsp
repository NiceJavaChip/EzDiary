<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/userHeader.jsp" %>
	<div class="usermain_wrapper_msg">
		<div class="content_wrapper">
			<div class="my_answer">
				<span>내가 한 답변</span>
			</div>
			<c:forEach var="mySurveyList" items="${mySurveyList}">
				<div class="my_questions">
					<p><c:out value="${mySurveyList.ask_cntnt }"/></p>
				</div>
				<div class="answer_items">
					<button class="answer_btn" type="button"><c:out value="${mySurveyList.answer_cntnt}"/></button>
				</div>
			</c:forEach>
			<form action="msg" method="post">
				<div class="msg">
					<span>학원 & 강사님에게 하고 싶은 말</span>
				</div>
				<div>
					<textarea id="test" name="msg_cntnt" maxlength="1000" rows="13" cols="70" placeholder="글자제한 1000자리"></textarea>
					<div class="text_cnt" id="test_cnt">(0 / 1000)</div>
					<input class="submit_btn" type="submit" value="전 송">
				</div>
			</form>
		</div>
	</div>
<%@ include file="../layout/userFooter2.jsp" %>