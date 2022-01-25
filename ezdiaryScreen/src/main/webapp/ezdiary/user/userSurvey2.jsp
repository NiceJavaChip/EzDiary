<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 제이쿼리 ===================================================================================== -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- ============================================================================================ -->

<!-- css파일 ===================================================================================== -->
<link href="../../css/user/userMain.css?after" rel="stylesheet"/>
<!-- ============================================================================================ -->

<!--js파일 ======================================================================================= -->
<script type="text/javascript" src="../../js/user/userMain.js?after"></script>
<!-- ============================================================================================ -->

<title>설문조사</title>
</head>
<body>
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
	

</body>
</html>