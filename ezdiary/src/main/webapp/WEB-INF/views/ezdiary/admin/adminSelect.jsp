<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="admin_wrapper">
		<div class="admin_contents_container margin_bottom_add">
			<div class="content_title margin_top_add">
			<h1>EZ DIARY</h1>
			</div>
			<div class="contents_warpper">
				<c:if test="${member != null }">
					<span>아이디 : ${member.admin_id }</span>
				</c:if>
			</div>
			<div class="content_btn_wrapper">
				<div class="select_btns_wrapper">
					<div class="select_btn_wrapper">					
						<div class="select_btn_img">
							<img alt="구름" src="${path}/resources/image/cloud.png">
							<input class="notice_btn" type="button" value="수강생 게시판" onclick="location.href='${path}/userMsgList'">
						</div>										
					</div>
					<div class="select_btn_wrapper">					
						<div class="select_btn_img">
							<img alt="구름" src="${path}/resources/image/cloud.png">
							<input class="notice_btn" type="button" value="질문지 추가 게시판" onclick="location.href='${path}/adminQuesList'">
						</div>										
					</div>
				</div>
			</div>
		</div>
	</div>