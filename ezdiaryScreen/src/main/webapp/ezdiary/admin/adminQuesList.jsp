<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 제이쿼리 ===================================================================================== -->
	<!-- ============================================================================================ -->
	
	<!-- css파일 ===================================================================================== -->
	<link href="../../css/admin/adminComponent.css?after" rel="stylesheet"/>
	<link href="../../css/admin/listView.css?after" rel="stylesheet"/>
	<!-- ============================================================================================ -->
	
	<!--js파일 ======================================================================================= -->
	<script
            src="https://kit.fontawesome.com/6478f529f2.js"
            crossorigin="anonymous">
    </script>
    <script type="text/javascript" src="../../js/admin/userMain.js"></script>
	<!-- ============================================================================================ -->
	<title>EZ DIARY 질문지 LIST</title>
</head>
<body>
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
					<tr>
						<td>2</td>
						<td><a onclick="location.href='adminQuesView.jsp'">취업이 안 되는 코로나...</a></td>
						<td>2022-02-18</td>
					</tr>
					<tr>
						<td>1</td>
						<td>질문 1</td>
						<td>2022-02-18</td>
					</tr>
				</table>
				<div class="pagging_tab">
					<a><<</a>
					<a><</a>
					<a>1</a>
					<a>></a>
					<a>>></a>
				</div>
				<div class="search_wrapper">
					<input type="text" class="search_input_box"
								placeholder="검색어 입력" name="searchText" onkeypress="search();"/>
				</div>
				<div class="content_btn_wrapper margin_top_less align_right">
					<button class="content_btn" onclick="location.href='quesWrite.jsp'">질문추가</button>
					<button class="content_btn" onclick="location.href='adminSelect.jsp'">이전</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>