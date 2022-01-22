<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 제이쿼리 ===================================================================================== -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- ============================================================================================ -->

<!-- css파일 ===================================================================================== -->
<link href="../../css/user/userMain.css" rel="stylesheet"/>
<link href="../../css/user/userMsg.css" rel="stylesheet"/>
<!-- ============================================================================================ -->

<!--js파일 ======================================================================================= -->
<script type="text/javascript" src="../../js/user/userMain.js"></script>
<!-- ============================================================================================ -->

<title>설문조사</title>
</head>
<body>
	<div class="usermain_wrapper">
		<div class="content_wrapper">
			<div class="my_answer">
				<span>내가 한 답변</span>
			</div>
			<div class="my_questions">
				<p>1. 취업이 안 되는 코로나 시기... 
				아이러니 하게도 이 시기에 코딩 열풍이다
				현재 내 상태는?</p>
			</div>
			<div class="answer_items">
				<button class="answer_btn" type="button">코딩과 1도 관련 없는 비전공자 취준생</button>
			</div>
			<div class="my_questions">
				<p>1. 취업이 안 되는 코로나 시기... 
				아이러니 하게도 이 시기에 코딩 열풍이다
				현재 내 상태는?</p>
			</div>
			<div class="answer_items">
				<button class="answer_btn" type="button">코딩과 1도 관련 없는 비전공자 취준생</button>
			</div>
			<div class="my_questions">
				<p>1. 취업이 안 되는 코로나 시기... 
				아이러니 하게도 이 시기에 코딩 열풍이다
				현재 내 상태는?</p>
			</div>
			<div class="answer_items">
				<button class="answer_btn" type="button">코딩과 1도 관련 없는 비전공자 취준생</button>
			</div>
			<form action="">
				<div class="msg">
					<span>학원 & 강사님에게 하고 싶은 말</span>
				</div>
				<div>
					<textarea id="test" name="test" maxlength="1000" rows="13" cols="70" placeholder="글자제한 1000자리"></textarea>
					<div class="text_cnt" id="test_cnt">(0 / 1000)</div>	
					<input class="submit_btn" type="button" value="전 송">
				</div>
			</form>
		</div>
	</div>
</body>
</html>