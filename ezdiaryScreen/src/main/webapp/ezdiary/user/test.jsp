<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 제이쿼리 ===================================================================================== -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- ============================================================================================ -->
<title>Insert title here</title>

</head>
<body>
	<button id="btnfadeOut"> Fade Out</button>
	<button id="btnfadeIn"> Fade In</button>
	<div id="img1">글자가 이쁘게 사라진다.</div>
	<!-- TEST -->
	<!-- TEST2 -->
</body>

<script type="text/javascript">
	var opacity =0;
	var intervalID=0;
	 

	//순수 자바스크립트 클릭 이벤트 Fsade out 실행
	document.getElementById('btnfadeOut').addEventListener('click', function() {
		intervalID = setInterval(hide,100);
	});
    
	//순수 자바스크립트 클릭 이벤트 Fade in
	document.getElementById('btnfadeIn').addEventListener('click', function() {
		intervalID = setInterval(show,100);
	});
 
	function hide(){
		var div = document.getElementById("img1");
		opacity = Number(window.getComputedStyle(div).getPropertyValue("opacity"));
		
		if(opacity>0){
            //Fade out 핵심 부분
			opacity = opacity-0.1;
			div.style.opacity=opacity;
			//img.style.opacity=opacity;
		}
		else{
			clearInterval(intervalID);
		}
	}
	
	function show(){
		var div = document.getElementById("img1");
		opacity = Number(window.getComputedStyle(div).getPropertyValue("opacity"));
		
		if(opacity<1){
        	//Fade in 핵심 부분
			opacity = opacity+0.1;
			div.style.opacity=opacity;
			//img.style.opacity=opacity;
		}
		else{
			clearInterval(intervalID);
		}
	}	 
       
    </script>
</html>