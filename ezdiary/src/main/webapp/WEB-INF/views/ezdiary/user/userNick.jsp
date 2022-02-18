<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ include file="../layout/userHeader.jsp" %>

	
		<div class="usermain_wrapper">
		<form action="regist" method="post" name="regist">
			<div class="content_wrapper">
				<div class="upper_title add_margin_top">
					<p>설문조사를 위해
					닉네임을 입력해 주세요!<br>
					(입력 후 엔터키를 눌러주세요)</p>
				</div>
				<div class="insert_nickname">
					<input hidden="hidden" />
					<input class="nickname_field" id="nick" type="text" name="user_nick" maxlength="10" placeholder="글자 제한 10자리" autofocus="autofocus" onkeypress="enter();"/>
				</div>
				<div class="bottom_title">
					<p>정범이 손 한번 흔들어줄래?</p>
				</div>
			</div>
			</form>
		</div>
	
<%-- 	<a style="visibility: hidden;" href='${path}/survey?ask_idx=<c:out value="${answer.ask_idx}" />'></a> --%>
<!-- 	<form method="get" id="moveForm"></form> -->
<script type="text/javascript">
	
</script>
<%@ include file="../layout/userFooter.jsp" %>