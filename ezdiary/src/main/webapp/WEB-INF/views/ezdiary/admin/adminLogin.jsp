<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/adminHeader.jsp" %>
	<div class="admin_wrapper">
		<div class="admin_contents_container">
			<div class="content_title margin_top_add">
				<h1>관리자용 로그인</h1>
			</div>
			<form name="frmLogin" id="frmLogin" method="post">
				<div class="contents_warpper">
				<!-- 유효성 검사필요, input 클릭시 boader 지우기 -->
					<div class="content contents_id">
						<div class="login_icons"><i class="far fa-user fa-2x"></i></div>
						<input type="text" name="admin_id" placeholder="아이디">
					</div>
					<div class="content contents_pwd">
						<div class="login_icons"><i class="fas fa-lock fa-2x"></i></div>
						<input type="password" name="admin_pw" placeholder="비밀번호">
					</div>
					<c:if test="${result == 0 }">
						<div class="login_warn">사용자 ID 또는 비밀번호를 다시 입력해주세요.</div>
					</c:if>
				</div>
				<div class="content_btn_wrapper">
					<div>
						<input class="login_btn" id="login_btn" type="button" value="LOGIN">
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- <script>
		$(".login_btn").click(function(){
			alert("로그인 버튼 작동");
		});
	</script> -->

<%@ include file="../layout/adminFooter.jsp" %>