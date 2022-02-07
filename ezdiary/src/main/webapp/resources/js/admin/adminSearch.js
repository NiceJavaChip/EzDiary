
/*페이지 이동하기 버튼*/
$(document).ready(function() {
    $('.login_btn').on('click', function() {
        $('#frmLogin').attr("action","login");
        $('#frmLogin').submit();
    });
});

/*질문지 List 정보 가져오기 -> 이것은 무엇인가... */
/*$(document).ready(function() {
    let result = '<c:out value="${result}"/>';
    checkAlert(result);
});*/

function search(){
	if(event.keyCode==13){
		location.href="../user/userSurvey.jsp";
	}
}

/*AdminQuesList 상세보기 페이지 넘어가기*/
let moveForm = $("#moveForm");

$(".move").on("click",function(e){
	e.preventDefault();
	
	moveForm.append("<input type='hidden' name='ask_idx' value='"+ $(this).attr("href")+"'>");
	moveForm.attr("action", "${path}/adminQuesView");
	moveForm.submit();
});

let moveModForm = $("#moveModForm");

$("#moveModFormBtn").on("click",function(e){
	e.preventDefault();
	
	moveModForm.append("<input type='hidden' name='ask_idx' value='"+ $(this).attr("href")+"'>");
	moveModForm.attr("action", "${path}/adminQuesModPage");
	moveModForm.submit();
});

