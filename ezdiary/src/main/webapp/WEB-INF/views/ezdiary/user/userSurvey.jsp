<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <div class="usermain_wrapper_survey survey">
      <div class="content_wrapper" id="divBox">
<!-- 		    <div class="prog"> -->
<!-- 		        <div class="progs" id="progressing">5%</div> -->
<!-- 		    </div> -->
<!-- 	      	<button onClick="moveBtn()">클릭해주세요</button> -->
<!-- 	      	<div> -->
<!-- 	 		 	<progress max="10" id="lb"></progress> -->
<!-- 			</div> -->
		<div class="progress-bar">
			<div class="index">
				<img src="${path}/resources/image/ball.png">
				<span class="ball-num">1</span>
			</div>
		</div>
         <div class="upper_title">
                  <!-- items = ${ask} ->컨트롤러에서 정한 model.addAttribute("ask", askDTO); 의 "ask" -->
            <c:forEach var="ask" items="${ask}">
               <p><c:out value="${ask.ask_cntnt}"/></p>
               <input id="ask_idx" type="hidden" value="${ask.ask_idx}"/>  
            </c:forEach>
         </div>

         <c:forEach var="answer" items="${answer}" varStatus="status">
	         <div class="select_items">
	            <button class="btn items_btn" id="start_btn${status.count }" type="button" name="answer_idx"><c:out value="${answer.answer_cntnt }"/></button>
<%-- 	            <input id="answer_idx" type="hidden" value="${answer.answer_idx }"/> --%>
	         </div>
	     </c:forEach>
         
         <div class="prev_btn" id="prev_btn_fadeout">
            <button type="button" onclick="location.href='regist'">이 전</button>
         </div>
         <input id="answer_idx1" type="hidden" value="${answer[0].answer_idx }"/>
         <input id="answer_idx2" type="hidden" value="${answer[1].answer_idx }"/>
         <input id="answer_idx3" type="hidden" value="${answer[2].answer_idx }"/>
 
<%--     <input id="ask_idx" type="hidden" value="${ask[0].ask_idx }"/> --%>
         
      </div>
   </div>
   
<script type="text/javascript">
$(document).ready(function(){

	$("#start_btn1").click(function(){
		   
		   var form = {
					ask_idx  : $('#ask_idx').val()
		       }
		   
		   console.log(form);
		   
		   $.ajax({
		        type: "post", 
		        url: "answer1", 
		        dataType: "json", 
		        data: form,
		        success : function() {
		        },
		        error : function() {
		          alert("error발생1");
		       }
		    });
		   
		});
		$("#start_btn2").click(function(){
		   
		   var form = {
				ask_idx  : $('#ask_idx').val()
		       }
		   
		   console.log(form);
		   
		   $.ajax({
		        type: "post", 
		        url: "answer2", 
		        dataType: "json", 
		        data: form,
		        success : function() {
		        },
		        error : function() {
		          alert("error발생2");
		       }
		    });
		   
		});
		$("#start_btn3").click(function(){
		   
		   var form = {
				ask_idx  : $('#ask_idx').val()
		       }
		   
		   console.log(form);
		   
		   $.ajax({
		        type: "post", 
		        url: "answer3", 
		        dataType: "json", 
		        data: form,
		        success : function() {
		        	
		        },
		        error : function() {
		          alert("error발생3");
		       }
		    });
		   
		});

var px = 0;
$(".index").css('left', px);
//         if(px < 430) {
//       	  px += 43;
//         	  $(".index").css('left', px);
//          }
//           console.log(px+px);		
	
$(".items_btn").click(function(){
	$('.index').each(function(index, item){
		$(".index").css('left', (px+=43)+'px');
		return false;
	});

        // json 형식으로 데이터 set
        var params = {
            ask_idx  : $('#ask_idx').val()
        }
        
        var params2 = {
                ask_idx  : $('#ask_idx').val()
            }
        $.ajax({
            type: "post", 
            url: "bar", 
            dataType: "json", 
            data: params2,
            success : function(res) {
   	            $.each(res.ajaxAsk,function(key,val){		// 반복문  
	       			$(".ball-num").text(val.ask_idx);
	       			
	            });
            },
            error : function() {
              alert("progress error");
           }
        });
        // ajax 통신
        $.ajax({
            type : "POST",            // HTTP method type(GET, POST) 형식이다.
            url : "survey2",      // 컨트롤러에서 대기중인 URL 주소이다.
            data : params,           // Json 형식의 데이터이다.
            dataType : "json",
            success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
//             	console.log("----------ajaxAsk.status-------" , res.ajaxAsk.status);
//                 console.log(res.ajaxAsk.length);
                console.log("res.ajaxAnswer.length 값 : " , res.ajaxAnswer.length);
                console.log("$('input#ask_idx').val() 값 : " , $('input#ask_idx').val());
                console.log("res.ajaxAsk.length 값 : " , res.ajaxAsk.length);
//                 console.log(res.ajaxAnswer);
//                	$(".items_btn").click(function(){
					
             		if(res.ajaxAnswer.length == 0) {
             			location.href = "loading";
             		}

//                	});	
                $('input#ask_idx').val(res.ajaxAsk[0].ask_idx);	// 컨트롤러에서 ajaxAsk이름으로 put 해준 첫번째의 ask_idx를 <input id="ask_idx">태그에 그 값을 넣어준다 (2)
//             	console.log( $('input#ask_idx').val());	

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
//                 $("#divBox").fadeOut(1000);
//                    console.log("key : " + key + " val.ask_cntnt : " + val.ask_cntnt );
                   $('.upper_title > p').eq(key).text(val.ask_cntnt);	// class가 upper_title 안에있는 p태그에 val.ask_cntnt의 내용을 텍스트로 넣어준다. 여기서 val = res.ajaxAsk
                  });
              
                $.each(res.ajaxAnswer,function(key,val){
//                    console.log("key : " + key + " val.ask_cntnt : " + val.answer_cntnt );
//                    console.log(key);
                   $('.items_btn').eq(key).text(val.answer_cntnt);	// class가 items_btn인 .eq(key)에 해당하는 태그에 val.answer_cntnt = res.ajaxAnswer[0].answer_cntnt,
                   													//															  res.ajaxAnswer[1].answer_cntnt, 
                   													//															  res.ajaxAnswer[2].answer_cntnt
                   													//															 text 내용을 바꿔준다
                });
//                 $("#divBox").fadeIn(500);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
               console.log(2);
                alert("code = "+ XMLHttpRequest.textStatus + " message = " + XMLHttpRequest.responseText + " error = " + errorThrown); // 실패 시 처리

            }
        });
    });
});
</script>