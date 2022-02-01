
// 엔터키 이벤트(닉네임 페이지) && 유효성검사  userNick.jsp에서 사용
function enter() {
	if(event.keyCode==13) {	
		if($("#nick").val() == "") {
	 	    alert("닉네임을 입력해주세요.");
	   	    $("#nick").focus();
	  	  return false;
	  	  //location.href="/user/regist";	
		}
		location.href="/ezdiary/user/userSurvey.jsp";
	}
}

function click() {
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

// userSurvey.jsp div fade in fade out 기능
$(function () {
	$(".items_btn").on("click", function() { 
		$("#divBox").fadeOut(2000);
			if ($("#divBox2").css("display") == "none") {
				$("#divBox2").delay(2000).fadeIn(2000);
			}
	});
	$(".items_btn2").on("click", function() { 
		$("#divBox2").fadeOut(2000);
			if ($("#divBox3").css("display") == "none") {
				$("#divBox3").delay(2000).fadeIn(2000);
			}
	});
	$(".items_btn3").on("click", function() { 
		$("#divBox3").fadeOut(2000);
			if ($("#divBox4").css("display") == "none") {
				$("#divBox4").delay(2000).fadeIn(2000);
			}
	});
});


$(function() { 
	$("#fadeToggleBtn").on("click", function() { 
	// id가 "divBox"인 요소를 1초에 걸쳐 점점 나타나게 하거나 사라지게 함. 
	$("#divBox").fadeToggle(1000); 
	}); 
});
