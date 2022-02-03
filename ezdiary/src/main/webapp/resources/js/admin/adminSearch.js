
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


