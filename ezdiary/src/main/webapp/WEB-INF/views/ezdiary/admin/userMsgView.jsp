<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
			<h1>상세보기</h1>
		</div>
		<form action="userMsgRemove" method="post">
		<div class="contents_warpper">
			<div class="sub_content_wrapper">
			<input type="hidden" name="user_idx" value="<c:out value='${userMsgInfo.userDTO.user_idx}'/>">
					<div class="msg_view_sub_title">닉네임</div>
					<!-- placeholder에 사용자가 작성했던 닉네임이 삽입될 것 -->
					<input class="user_msg_view_input" 
					readonly="readonly" type="text" name="user_nick" value="<c:out value='${userMsgInfo.userDTO.user_nick}'/>">
			</div>
			<div class="sub_content_wrapper">
					<div class="msg_view_sub_title">작성일</div>
					<!-- placeholder에 내용 작성시 날짜가 삽입될 것 -->
					<input class="user_msg_view_input" type="text" readonly="readonly" name="write_date" value="<c:out value='${userMsgInfo.msgDTO.write_date}'/>">
			</div>
			<div class="sub_content_wrapper">
					<div class="msg_view_sub_title">내용</div>
					<!-- placeholder에 내용 작성시 날짜가 삽입될 것 -->
					<input class="user_msg_view_input" type="text" readonly="readonly" name="msg_cntnt" value="<c:out value='${userMsgInfo.msgDTO.msg_cntnt}'/>">
			</div>
		</div>
		<div class="content_btn_wrapper right_align">
			<button type="button" class="content_btn" onclick="location.href='${path}/userMsgList'">확인</button>
			<button class="content_btn color_change">삭제</button>
		</div>
		</form>
		</div>
	</div>