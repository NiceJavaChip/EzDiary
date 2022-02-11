
/*페이지 이동하기 버튼*/
$(document).ready(function() {
    $('.login_btn').on('click', function() {
        $('#frmLogin').attr("action","login");
        $('#frmLogin').submit();
    });
});

$(document).ready(function() {
    $('.content input').on('keyup', function(key) {
        if(key.keyCode == 13){
       	$('#frmLogin').attr("action","login");
        $('#frmLogin').submit();
        }
    });
});



/*AdminQuesList 상세보기 페이지 넘어가기*/

let moveForm = $("#moveForm");



 $(document).ready(function() {
 
 let moveForm = $("#moveForm");
 
 $(".search_wrapper #search").keydown(function(key) {
      if (key.keyCode == 13) {
		
        let val = $("input[name='search']").val();
        console.log(val);
        moveForm.find("input[name='search']").val(val);
        moveForm.find("input[name='pageNum']").val(1);
        moveForm.submit();
                }
            });
	
        });

$(".move").on("click",function(e){
	e.preventDefault();
	
	moveForm.append("<input type='hidden' name='ask_idx' value='"+ $(this).attr("href")+"'>");
	moveForm.attr("action", "${path}/adminQuesView");
	moveForm.submit();
});

let moveModForm = $("#moveModForm");
let removeForm = $("#removeForm");

$("#moveModFormBtn").on("click",function(e){
	e.preventDefault();
	
	moveModForm.append("<input type='hidden' name='ask_idx' value='"+ $(this).attr("href")+"'>");
	moveModForm.attr("action", "${path}/adminQuesModPage");
	moveModForm.submit();
});

/*$("#quesRemoveBtn").on("click",function(e){
	e.preventDefault();
	
	removeForm.append("<input type='hidden' name='ask_idx' value='"+ $(this).attr("href")+"'>");
	removeForm.attr("action", "${path}/removeQues");
	removeForm.submit();
});*/

