<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/userHeader.jsp" %>
   <div class="usermain_wrapper survey">
      <div class="content_wrapper" id="divBox">
         <div class="upper_title">
         			<!-- items = ${ask} ->컨트롤러에서 정한 model.addAttribute("ask", askDTO); 의 "ask" -->
	         <c:forEach var="ask" items="${ask}">
	            <p><c:out value="${ask.ask_cntnt}"/></p>
	            <input id="ask_idx" type="hidden" value="${ask.ask_idx}"/>  
	         </c:forEach>
         </div>

         <c:forEach var="answer" items="${answer}" varStatus="status">
	         <div class="select_items">
	         	<input id="answer_idx" value="${answer.answer_idx }">
	         	<%-- <input id="answer_cntnt" value="${answer.answer_cntnt }"> --%>
	            <button class="btn items_btn" id="start_btn${status.count }" type="button"><c:out value="${answer.answer_cntnt }"/></button>
	         </div>
	     </c:forEach>
	     
         <div class="prev_btn" id="prev_btn_fadeout">
            <button type="button" onclick="location.href='regist'">이 전</button>
         </div>
         
         <%-- <input id="ask_idx" type="hidden" value="${ask[0].ask_idx }"/> --%>
         <!-- TEST  -->
      </div>
   </div>
   
<script type="text/javascript">

/* const answer_cntnt = document.querySelector(".select_items #answer_cntnt");

function loginButtonClick() {
	
	for (var i = 1; i <= 3; i++) {
		console.log(answer_cntnt.value[i]);
	  }

};

answer_cntnt.addEventListener("click", loginButtonClick); */

$(document).ready(function(){
$("#start_btn1").click(function(){
	
	var form = {
			ask_idx : $('#ask_idx').val(),
	    }
	
	console.log(form);
	
	$.ajax({
        type: "post", 
        url: "survey2", 
        dataType: "json", 
        data: form,
        success : function() {
        	alert("success!");
        },
        error : function() {
    		alert("error발생1");
    	}
    });
	
});

$("#start_btn2").click(function(){
	
	var form = {
			answer_idx : $('#answer_idx').val(),
	    }
	
	console.log(form);
	
	$.ajax({
        type: "post", 
        url: "survey3", 
        dataType: "json", 
        data: form,
        success : function() {
        	alert("success!");
        },
        error : function() {
    		alert("error발생2");
    	}
    });
	
});
$("#start_btn3").click(function(){
	
	var form = {
			answer_idx : $('#answer_idx').val(),
	    }
	
	console.log(form);
	
	$.ajax({
        type: "post", 
        url: "survey4", 
        dataType: "json", 
        data: form,
        success : function() {
        	alert("success!");
        },
        error : function() {
    		alert("error발생3");
    	}
    });
	
});






}); 
	

        /* // json 형식으로 데이터 set
        var params = {
              ask_idx  : $('#ask_idx').val()
        }
        console.log("ask_idx  = " + $('#ask_idx').val());		//1
        console.log("====================");
        console.log(ask_idx);
        console.log("====================");
        
        
        
        

        var idx = $('answer_idx').val();
        
        console.log("answer_idx  = " +  $('answer_idx').val());
        
        // ajax 통신
        $.ajax({
            type : "POST",            // HTTP method type(GET, POST) 형식이다.
            url : "survey2",      // 컨트롤러에서 대기중인 URL 주소이다.
            data : params,            // Json 형식의 데이터이다.
            dataType : "json",
            success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                
                $('input#ask_idx').val(res.ajaxAsk[0].ask_idx);	// 컨트롤러에서 ajaxAsk이름으로 put 해준 첫번째의 ask_idx를 <input id="ask_idx">태그에 그 값을 넣어준다 (2)
            	console.log( $('input#ask_idx').val());	//2

// 				 console.log(res.ajaxAsk[0].ask_cntnt);
// 				 $('.upper_title > p').text(res.ajaxAsk[0].ask_cntnt);
//                  $('.upper_title > p').eq(0).text(res.ajaxAsk[0].ask_cntnt);
//                  console.log(res.ajaxAsk[0].ask_cntnt);
//                  console.log(res.ajaxAsk[0].ask_idx);
                 
//                  console.log(res.ajaxAsk);
//                  console.log(res.ajaxAnswer);
//                  $('.upper_title > p').eq(0).text(res.ajaxAsk[0].ask_cntnt);
//                  console.log(res.ajaxAsk[0].ask_idx);
                 
//                  console.log(res.ajaxAnswer[0].answer_cntnt);
//                  console.log(res.ajaxAnswer[1].answer_cntnt);
//                  console.log(res.ajaxAnswer[2].answer_cntnt);
//                  $('.items_btn').eq(0).text(res.ajaxAnswer[0].answer_cntnt);
//                  $('.items_btn').eq(1).text(res.ajaxAnswer[1].answer_cntnt);
//                  $('.items_btn').eq(2).text(res.ajaxAnswer[2].answer_cntnt);
                
                $.each(res.ajaxAsk,function(key,val){		// 반복문  
                   console.log("key : " + key + " val.ask_cntnt : " + val.ask_cntnt );
                   $('.upper_title > p').eq(key).text(val.ask_cntnt);	// class가 upper_title 안에있는 p태그에 val.ask_cntnt의 내용을 텍스트로 넣어준다. 여기서 val = res.ajaxAsk
                  });
              
                $.each(res.ajaxAnswer,function(key,val){
                   console.log("key : " + key + " val.ask_cntnt : " + val.answer_cntnt );
                   console.log(key);
                   $('.items_btn').eq(key).text(val.answer_cntnt);	// class가 items_btn인 .eq(key)에 해당하는 태그에 val.answer_cntnt = res.ajaxAnswer[0].answer_cntnt,
                   													//															  res.ajaxAnswer[1].answer_cntnt, 
                   													//															  res.ajaxAnswer[2].answer_cntnt
                   													//															 text 내용을 바꿔준다
                 	console.log("마지막 선택지 내용 : " + val.ask_cntnt);
                   	$(".items_btn").click(function(){
                   		if(val.ask_cntnt === "") {
                   			location.href = "loading";
                   		} else {
                   			return false;
                   		}
                   	});												
                   
                   $('.items_btn').eq(key).data('seq',key);													
                   console.log("내용 : " + val.answer_cntnt);
                });
                
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
               console.log(2);
                alert("code = "+ XMLHttpRequest.textStatus + " message = " + XMLHttpRequest.responseText + " error = " + errorThrown); // 실패 시 처리

            }
        }); */

</script>
<%@ include file="../layout/userFooter.jsp" %>