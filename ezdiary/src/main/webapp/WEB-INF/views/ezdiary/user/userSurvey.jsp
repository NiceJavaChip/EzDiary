<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/userHeader.jsp" %>
   <div class="usermain_wrapper survey">
      <div class="content_wrapper" id="divBox">
         <div class="upper_title">
         			<!-- items = ${ask} ->컨트롤러에서 정한 model.addAttribute("ask", askDTO); 의 "ask" -->
         <c:forEach var="ask" items="${ask}">
            <p><c:out value="${ask.ask_cntnt}"/></p>      
         </c:forEach>
         </div>
         <c:forEach var="answer" items="${answer}">
	         <div class="select_items">
	            <button class="btn items_btn" id="start_btn1" type="button"><c:out value="${answer.answer_cntnt }"/></button>
<!-- 	            <button class="btn items_btn" id="start_btn1" type="button">4년을 무사히 졸업한 컴광과 취준생</button> -->
<!--                 <button class="btn items_btn" id="start_btn1" type="button">직무 전환을 위해 고민하는 재직자</button> -->
<!--                 <button class="btn items_btn" type="button" onclick="location.href='userResultloading.jsp'">더 나은 곳으로 이직을 위해 고민하는 재직자</button> -->
	         </div>
	     </c:forEach>
         <div class="prev_btn" id="prev_btn_fadeout">
            <button type="button" onclick="location.href='regist'">이 전</button>
         </div>
      </div>
      <div class="content_wrapper2" id="divBox2" style="display: none;">
         <div class="upper_title">
            <p>취업이 안 되는 코로나 시기... 
            아이러니 하게도 이 시기에 코딩 열풍이다
            현재 내 상태는?</p>
         </div>
         <div class="select_items">
            <button class="btn items_btn2" id="start_btn2" type="button">제발 한번에 되게 해주세요</button>
            <button class="btn items_btn2" id="start_btn2" type="button">제발 한번에 되게 해주세요</button>
            <button class="btn items_btn2" id="start_btn2" type="button">제발 한번에 되게 해주세요</button>
            <button class="btn items_btn2" type="button" onclick="location.href='userResultloading.jsp'">더 나은 곳으로 이직을 위해 고민하는 재직자</button>
         </div>
         <div class="prev_btn" id="prev_btn_fadeout">
            <button type="button" onclick="location.href='userNick.jsp'">이 전</button>
         </div>
      </div>
      <div class="content_wrapper2" id="divBox3" style="display: none;">
         <div class="upper_title">
            <p>취업이 안 되는 코로나 시기... 
            아이러니 하게도 이 시기에 코딩 열풍이다
            현재 내 상태는?</p>
         </div>
         <div class="select_items">
            <button class="btn items_btn3" id="start_btn3" type="button">이렇게 하면 되는건가...</button>
            <button class="btn items_btn3" id="start_btn3" type="button">이렇게 하면 되는건가...</button>
            <button class="btn items_btn3" id="start_btn3" type="button">이렇게 하면 되는건가...</button>
            <button class="btn items_btn3" type="button" onclick="location.href='userResultloading.jsp'">더 나은 곳으로 이직을 위해 고민하는 재직자</button>
         </div>
         <div class="prev_btn" id="prev_btn_fadeout">
            <button type="button" onclick="location.href='userNick.jsp'">이 전</button>
         </div>
      </div>
      <div class="content_wrapper2" id="divBox4" style="display: none;">
         <div class="upper_title">
            <p>취업이 안 되는 코로나 시기... 
            아이러니 하게도 이 시기에 코딩 열풍이다
            현재 내 상태는?</p>
         </div>
         <div class="select_items">
            <button class="btn items_btn4" id="start_btn3" type="button">이렇게 하면 되는건가...</button>
            <button class="btn items_btn4" id="start_btn3" type="button">이렇게 하면 되는건가...</button>
            <button class="btn items_btn4" id="start_btn3" type="button">이렇게 하면 되는건가...</button>
            <button class="btn items_btn4" type="button" onclick="location.href='userResultloading.jsp'">더 나은 곳으로 이직을 위해 고민하는 재직자</button>
         </div>
         <div class="prev_btn" id="prev_btn_fadeout">
            <button type="button" onclick="location.href='userNick.jsp'">이 전</button>
         </div>
      </div>
   </div>
<%@ include file="../layout/userFooter.jsp" %>