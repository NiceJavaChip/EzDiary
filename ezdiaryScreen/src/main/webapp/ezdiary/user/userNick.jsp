<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 제이쿼리 ===================================================================================== -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script language="javascript" src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<!-- ============================================================================================ -->

<!-- css파일 ===================================================================================== -->
<link href="../../css/user/userMain.css" rel="stylesheet"/>
<!-- ============================================================================================ -->
<!--js파일 ======================================================================================= -->
<script type="text/javascript" src="../../js/user/userMain.js"></script>
<!-- ============================================================================================ -->
<title>닉네임 입력</title>
</head>
<body>
	<div class="usermain_wrapper">
		<div class="content_wrapper">
			<div class="upper_title">
				<p>설문조사를 위해
				닉네임을 입력해 주세요!
				(입력 후 엔터키를 눌러주세요)</p>
			</div>
			<div class="insert_nickname">
				<input class="nickname_field" id="nick" type="text" maxlength="10" placeholder="글자 제한 10자리" onkeypress="enter();"/>
			</div>
			<div class="bottom_title">
				<p>정범이 손 한번 흔들어줄래?</p>
			</div>
		</div>
	</div>
</body>
</html>