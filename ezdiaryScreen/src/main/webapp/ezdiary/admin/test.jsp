<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
    $(function() {
    	  $("#fadeInBtn").on("click", function() {
    	    $("#divBox").fadeIn("slow");      
    	  });
    	   

    	  $("#fadeOutBtn").on("click", function() {
    	    $("#divBox").fadeOut("fast");      
    	  });
    	});
    </script>
</head>
<body>
<div id="divBox">
   divBox
</div>
<button id="fadeInBtn">fadein</button>
<button id="fadeOutBtn">fadeout</button>
<!-- 테스트입니다. -->
</div>
</body>
</html>