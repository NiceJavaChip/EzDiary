<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/userHeader.jsp" %>
	<div class="usermain_wrapper">
		<div class="content_wrapper" id="divBox">
			<div class="upper_title">
				<p>취업이 안 되는 코로나 시기... 
				아이러니 하게도 이 시기에 코딩 열풍이다
				현재 내 상태는?</p>
			</div>
			<div class="select_items">
				<button class="items_btn" type="button">코딩과 1도 관련 없는 비전공자 취준생</button>
				<button class="items_btn" type="button">4년을 무사히 졸업한 컴광과 취준생</button>
				<button class="items_btn" type="button">직무 전환을 위해 고민하는 재직자</button>
				<button class="items_btn" type="button" onclick="location.href='userResultloading.jsp'">더 나은 곳으로 이직을 위해 고민하는 재직자</button>
			</div>
			<div class="prev_btn" id="prev_btn_fadeout">
				<button type="button" onclick="location.href='userNick.jsp'">이 전</button>
			</div>
		</div>
	</div>
	
<%@ include file="../layout/userFooter.jsp" %>
