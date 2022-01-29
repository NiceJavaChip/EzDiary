<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/adminHeader.jsp" %>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
				<h1>관리자용 로그인</h1>
			</div>
				<div class="contents_warpper">
				<!-- 유효성 검사필요, input 클릭시 boader 지우기 -->
				<div class="content contents_id">
					<div class="login_icons"><i class="far fa-user fa-2x"></i></div>
					<input type="text" placeholder="아이디">
				</div>
				<div class="content contents_pwd">
					<div class="login_icons"><i class="fas fa-lock fa-2x"></i></div>
					<input type="text" placeholder="비밀번호">
				</div>
			</div>
			<div class="content_btn_wrapper">
				<div>
					<input class="login_btn" type="button" value="LOGIN" onclick="location.href='${path}/adminselect.do'">
				</div>
			</div>
		</div>
	</div>


<%@ include file="../layout/adminFooter.jsp" %>