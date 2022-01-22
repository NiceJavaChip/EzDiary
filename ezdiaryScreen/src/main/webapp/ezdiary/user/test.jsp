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
<title>Insert title here</title>
	<script type="text/javascript">
	$(document).ready(function() {
	    $('#test').on('keyup', function() {
	        $('#test_cnt').html("("+$(this).val().length+" / 100)");
	 
	        if($(this).val().length > 100) {
	            $(this).val($(this).val().substring(0, 100));
	            $('#test_cnt').html("(100 / 100)");
	        }
	    });
	});
	</script>
</head>
<body>
	<textarea id="test" name="test" cols="30" rows="10"></textarea>
	<div id="test_cnt">(0 / 100)</div>
</body>
</html>