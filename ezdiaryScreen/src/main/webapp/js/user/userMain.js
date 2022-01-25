// 엔터키 이벤트(닉네임 페이지) && 유효성검사  userNick.jsp에서 사용
function enter(){
    if($("#nick").val() == ""){
 	    alert("닉네임을 입력해주세요.");
   	    $("#nick").focus();
    return false;
	} else if(event.keyCode==13) {
		location.href="userSurvey.jsp";
	}
}

function click(){
	var link = 'userResultloading.jsp';
		location.href=link;
}



// 글자 수 세기
$(document).ready(function() {
    $('#test').on('keyup', function() {
        $('#test_cnt').html("("+$(this).val().length+" / 1000)");
 
        if($(this).val().length > 1000) {
            $(this).val($(this).val().substring(0, 1000));
            $('#test_cnt').html("(1000 / 1000)");
        }
    });
});


$(function() { 
	$("#start_btn1").on("click", function() { 
		// id가 "divBox"인 요소를 0.5초에 걸쳐 사라지게 하고 
		// 1초의 지연시간 뒤에 다시 2초에 걸쳐 나타나게 함. 
		$("#divBox").fadeOut(2000).delay(1000).$("#divBox2").fadeIn(2000); 
	}); 
	$("#start_btn2").on("click", function() { 
		// id가 "divBox"인 요소를 0.5초에 걸쳐 사라지게 하고 
		// 1초의 지연시간 뒤에 다시 2초에 걸쳐 나타나게 함. 
		$("#divBox2").fadeOut(2000).delay(1000).$("#divBox3").fadeIn(2000); 
	}); 
});


$(function() { 
	$("#fadeToggleBtn").on("click", function() { 
	// id가 "divBox"인 요소를 1초에 걸쳐 점점 나타나게 하거나 사라지게 함. 
	$("#divBox").fadeToggle(1000); 
	}); 
});
