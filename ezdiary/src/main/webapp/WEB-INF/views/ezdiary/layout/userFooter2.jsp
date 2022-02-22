<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="userCount" value="${userCount}"/>
	<div class="footer">
		<div class="stick_container">
			<div class="stick_flex_container">
				<div class="stick pink" onclick="location.href='${path}/loginView'"></div>
				<div class="stick white"></div>
			</div>
		</div>
		<div class="border"></div>
		<div class="border_shadow"></div>
		<div class="wood">
			<div class="footer_content_box">
				<div class="footer_content">
					<div class="now_user_count">
						<p>현재까지 <c:out value="${userCount}" /> 명이<br> 참여했어요!</p>
					</div>
				</div>
				<div class="footer_content">
					<div class="back_to_user_nick_btn">
            			<button type="button" onclick="location.href='regist'"><span>다시 설문지<br>작성하기</span></button>
        			 </div>
				</div>
				<div class="footer_content"></div>
			</div>
		</div>
	</div> 
</body>
</html>