<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/adminHeader.jsp" %>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
				<h1>수강생들의 이야기</h1>
			</div>
			<div class="contents_warpper">
				<table class="table">
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>등록일</th>
						<th>닉네임</th>
					</tr>
					<tr>
						<td>2</td>
						<td><a onclick="location.href='userMsgView.jsp'">비대면 수업 개꿀!!!</a></td>
						<td>2022-02-18</td>
						<td>닉네임</td>
					</tr>
					<tr>
						<td>1</td>
						<td>비대면 수업 개꿀</td>
						<td>2022-02-18</td>
						<td>닉네임</td>
					</tr>
				</table>
				<div class="pagging_tab">
					<button><<</button>
					<button><</button>
					<button>1</button>
					<button>></button>
					<button>>></button>
				</div>
				<div class="search_wrapper">
					<input type="text" class="search_input_box"
								placeholder="검색어 입력" name="searchText" onkeypress="search();"/>
				</div>
				<div class="content_btn_wrapper margin_top_less align_right list_view">
					<button class="content_btn" onclick="location.href='adminSelect.jsp'">이전</button>
				</div>
			</div>
		</div>
	</div>


<%@ include file="../layout/adminFooter.jsp" %>