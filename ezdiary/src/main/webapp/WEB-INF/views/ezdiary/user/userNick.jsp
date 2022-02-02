<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/userHeader.jsp" %>
	<form action="regist" method="post" >
		<div class="usermain_wrapper">
			<div class="content_wrapper">
				<div class="upper_title">
					<p>설문조사를 위해
					닉네임을 입력해 주세요!
					(입력 후 엔터키를 눌러주세요)</p>
				</div>
				<div class="insert_nickname">
					<input class="nickname_field" id="nick" type="text" name="user_nick" maxlength="10" placeholder="글자 제한 10자리" autofocus="autofocus" onkeypress="enter();"/>
				</div>
				<div class="bottom_title">
					<p>정범이 손 한번 흔들어줄래?</p>
				</div>
			</div>
		</div>
	</form>

<%@ include file="../layout/userFooter.jsp" %>