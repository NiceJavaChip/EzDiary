<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/adminHeader.jsp" %>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title">
				<h1>질문지 LIST</h1>
			</div>
			<div class="contents_warpper">
				<table class="table">
					<tr>
						<th>글번호</th>
						<th>질문</th>
						<th>등록일</th>
					</tr>
					<%-- <tr>
						<td>2</td>
						<td><a onclick="location.href='${path}/adminQuesView'">취업이 안 되는 코로나...</a></td>
						<td>2022-02-18</td>
					</tr>
					<tr>
						<td>1</td>
						<td>질문 1</td>
						<td>2022-02-18</td>
					</tr> --%>
					<c:forEach items="${quesList}" var="quesList" varStatus="status">
						<tr>
							<td><c:out value="${quesList.ask_idx}" /></td>
							<td><a class="move" href='${path}/adminQuesView?ask_idx=
													<c:out value="${quesList.ask_idx}"/>
													<c:forEach items="${answerInfo}" var="answerInfo">
													&answer_idx=<c:out value="${answerInfo.answer_idx}"/>
													</c:forEach>'>
								<c:out value="${quesList.ask_cntnt }" /></a></td>
							<td><c:out value="${quesList.write_date }" /></td>							
						</tr>
					</c:forEach>
				</table>
				<form method="get" id="moveForm">
					<input type="hidden" name="pageNum" value="${boardPage.boardDTO.pageNum}"> 
					 <input type="hidden" name="search" value="${boardPage.boardDTO.search}">
				</form>
				<div class="pagging_box">
					<div class="pagging_tab">
						<ul id="pageInfo" class="pageInfo">
						<c:if test="${boardPage.prev}">
	                    	<li><button onclick="
	                    	location.href='${path}/adminQuesList?pageNum=${boardPage.startPage-1}'"><</button></li>
	                	</c:if>
							<c:forEach var="num" begin="${boardPage.startPage}" end="${boardPage.endPage}">
								<li>
									<button class="${boardPage.boardDTO.pageNum == num ? 'active':''}" onclick="location.href='${path}/adminQuesList?pageNum=${num}'">${num}</button>
								</li>
							</c:forEach>
						<c:if test="${boardPage.next}">
	                    	<li><button onclick="
	                    	location.href='${path}/adminQuesList?pageNum=${boardPage.endPage+1}'">></button></li>
	                	</c:if>
						</ul>
					</div>
				</div>
				<div class="search_wrapper">
					<input id="search" type="text" class="search_input_box"
								placeholder="검색어 입력" name="search" value="${boardPage.boardDTO.search}"/>
				</div>
				<div class="content_btn_wrapper margin_top_less align_right list_view">
					<button class="content_btn" onclick="location.href='${path}/adminselect'">이전</button>
					<button class="content_btn width_add" onclick="location.href='${path}/quesWrite'">질문추가</button>
				</div>
			</div>
		</div>
	</div>
<%@ include file="../layout/adminFooter.jsp" %>