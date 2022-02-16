<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/adminHeader.jsp" %>
<%-- <c:set var="userMsgList" value="${userMap.userMsgList}"/>
<c:set var="userName" value="${userMap.user}"/> --%>
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
					<%-- <tr>
						<td>2</td>
						<td><a onclick="location.href='${path}/userMsgView'">비대면 수업 개꿀!!!</a></td>
						<td>2022-02-18</td>
						<td>닉네임</td>
					</tr> --%>
					<c:forEach items="${userMsgList}" var="userMsgList" varStatus="status">
						<input type="hidden" value="${userMsgList.msgDTO.user_idx}" />
						<tr>
							<td><c:out value="${userMsgList.msgDTO.msg_idx}" /></td>
							<td><a class="moveMsgView"
									href='${path}/userMsgView?user_idx=
													<c:out value="${userMsgList.msgDTO.user_idx}"/>'>
								<c:out value="${userMsgList.msgDTO.msg_cntnt }" /></a></td>
							<td><c:out value="${userMsgList.msgDTO.write_date }" /></td>							
							<td><c:out value="${userMsgList.userDTO.user_nick }" /></td>												
						</tr>
					</c:forEach>
				</table>
				<form method="get" id="msgMoveForm">
					<input type="hidden" name="pageNum" value="${boardPage.boardDTO.pageNum}"> 
					 <%-- <input type="hidden" name="search" value="${boardPage.boardDTO.search}"> --%>
				</form>
				<div class="pagging_box">
					<div class="pagging_tab">
						<ul id="pageInfo" class="pageInfo">
						<c:if test="${boardPage.prev}">
	                    	<li><button onclick="
	                    	location.href='${path}/userMsgList?pageNum=${boardPage.startPage-1}'"><</button></li>
	                	</c:if>
							<c:forEach var="num" begin="${boardPage.startPage}" end="${boardPage.endPage}">
								<li>
									<button class="${boardPage.boardDTO.pageNum == num ? 'active':''}" onclick="location.href='${path}/userMsgList?pageNum=${num}'">${num}</button>
								</li>
							</c:forEach>
						<c:if test="${boardPage.next}">
	                    	<li><button onclick="
	                    	location.href='${path}/userMsgList?pageNum=${boardPage.endPage+1}'">></button></li>
	                	</c:if>
						</ul>
					</div>
				</div>
				<form method="get" id="msgMoveForm">	
				<div class="search_wrapper">
				<input type="hidden" name="pageNum" value="${boardPage.boardDTO.pageNum}"> 
					<input id="search" type="text" class="search_input_box"
								placeholder="검색어 입력" name="search" value="${boardPage.boardDTO.search}"/>
				</div>
				</form>
				<div class="content_btn_wrapper margin_top_less align_right list_view">
					<button class="content_btn" onclick="location.href='${path}/adminselect'">이전</button>
				</div>
			</div>
		</div>
	</div>


<%@ include file="../layout/adminFooter.jsp" %>