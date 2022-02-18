<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/userHeader.jsp" %>
	<div class="resultPage_wrapper">
		<div class="resultContent_wrapper">
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
					<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart"></canvas>
					</div>
				</div>
			</div>
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
					<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart2"></canvas>
					</div>
				</div>
			</div>
		</div>
		<div class="resultContent_wrapper">
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
					<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart3"></canvas>
				</div>
			</div>
			</div>
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
					<div class="chart_field">
					<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart4"></canvas>
					</div>
					</div>
				</div>
			</div>
		</div>
		<div class="resultContent_wrapper">
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
				<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart5"></canvas>
				</div>
				</div>
			</div>
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
					<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart6"></canvas>
				</div>
			</div>
		</div>
	</div>
		<div class="resultContent_wrapper">
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
				<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart7"></canvas>
				</div>
				</div>
			</div>
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
					<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart8"></canvas>
				</div>
			</div>
		</div>
	</div>
		<div class="resultContent_wrapper">
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
				<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart9"></canvas>
				</div>
				</div>
			</div>
			<div class="result_chart">		
				<div class="chart_title">해당 차트에 대한 제목</div>
				<div class="chart_field">
					<div style="width: 400px; height: 200px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart10"></canvas>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
            /* var context = document
                .getElementById('myChart')
                .getContext('2d');
            var myChart = new Chart(context, {
                type: 'bar', // 차트의 형태
                data: { // 차트에 들어갈 데이터
                    labels: [
                        //x 축
                        '1','2','3'
                    ],
                    datasets: [
                        { //데이터
                            label: '질문 1에 대한 통계', //차트 제목
                            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                            data: [
                                //19,25,20,23,26,25 //x축 label에 대응되는 데이터 값 -> ajax로 조회된 카운팅 쿼리 내용을 가져온다(콤마형태)
                            	'${answerCnt[0]}','${answerCnt[1]}','${answerCnt[2]}'
                            ],
                            backgroundColor: [
                                //색상
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                //경계선 색상
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1 //경계선 굵기
                        },
                        {
                            label: 'test2',
                            fill: false,
                            data: [
                                8, 34, 12, 24
                            ],
                            backgroundColor: 'rgb(157, 109, 12)',
                            borderColor: 'rgb(157, 109, 12)'
                        } 
                    ]
                },
                options: {
                    scales: {
                        yAxes: [
                            {
                                ticks: {
                                    beginAtZero: true,
                                    stepSize : 1
                                }
                            }
                        ]
                    }
                }
            });
            
            var context = document
                .getElementById('myChart2')
                .getContext('2d');
            var myChart2 = new Chart(context, {
                type: 'bar', // 차트의 형태
                data: { // 차트에 들어갈 데이터
                    labels: [
                        //x 축
                    	'1','2','3'
                    ],
                    datasets: [
                        { //데이터
                            label: '질문 2에 대한 통계', //차트 제목
                            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                            data: [
                                //19,25,20,23,26,25 //x축 label에 대응되는 데이터 값 -> ajax로 조회된 카운팅 쿼리 내용을 가져온다(콤마형태)
                            	'${answerCnt[3]}','${answerCnt[4]}','${answerCnt[5]}'
                            ],
                            backgroundColor: [
                                //색상
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                //경계선 색상
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1 //경계선 굵기
                        },
                         {
                            label: 'test2',
                            fill: false,
                            data: [
                                8, 34, 12, 24
                            ],
                            backgroundColor: 'rgb(157, 109, 12)',
                            borderColor: 'rgb(157, 109, 12)'
                        }
                    ]
                },
                options: {
                    scales: {
                        yAxes: [
                            {
                                ticks: {
                                    beginAtZero: true,
                                    stepSize : 1
                                }
                            }
                        ]
                    }
                }
            });
             */
             
            /* console.log(1);
            console.log(2);
            console.log(3); */
//             '${answerCnt[2]}'

			chartTest('myChart','${answerCnt[0]}','${answerCnt[1]}','${answerCnt[2]}');
			chartTest('myChart2','${answerCnt[3]}','${answerCnt[4]}','${answerCnt[5]}');
			chartTest('myChart3','${answerCnt[6]}','${answerCnt[7]}','${answerCnt[8]}');
			chartTest('myChart4','${answerCnt[9]}','${answerCnt[10]}','${answerCnt[11]}');
			chartTest('myChart5','${answerCnt[12]}','${answerCnt[13]}','${answerCnt[14]}');
			chartTest('myChart6','${answerCnt[15]}','${answerCnt[16]}','${answerCnt[17]}');
			chartTest('myChart7','${answerCnt[18]}','${answerCnt[19]}','${answerCnt[20]}');
			chartTest('myChart8','${answerCnt[21]}','${answerCnt[22]}','${answerCnt[23]}');
			chartTest('myChart9','${answerCnt[24]}','${answerCnt[25]}','${answerCnt[26]}');
			chartTest('myChart10','${answerCnt[27]}','${answerCnt[28]}','${answerCnt[29]}');
            
            function chartTest(id, data1, data2, data3){
            	var context = document
                .getElementById(id)
                .getContext('2d');
            var myChart = new Chart(context, {
                type: 'bar', // 차트의 형태
                data: { // 차트에 들어갈 데이터
                    labels: [
                        //x 축
                        '1','2','3'
                    ],
                    datasets: [
                        { //데이터
                            label: '질문 1에 대한 통계', //차트 제목
                            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                            data: [
                                //19,25,20,23,26,25 //x축 label에 대응되는 데이터 값 -> ajax로 조회된 카운팅 쿼리 내용을 가져온다(콤마형태)
                            	data1, data2, data3
                            ],
                            backgroundColor: [
                                //색상
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                //경계선 색상
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1 //경계선 굵기
                        },
                        /* {
                            label: 'test2',
                            fill: false,
                            data: [
                                8, 34, 12, 24
                            ],
                            backgroundColor: 'rgb(157, 109, 12)',
                            borderColor: 'rgb(157, 109, 12)'
                        } */
                    ]
                },
                options: {
                    scales: {
                        yAxes: [
                            {
                                ticks: {
                                    beginAtZero: true,
                                    stepSize : 1
                                }
                            }
                        ]
                    }
                }
            });
            }
        </script>
<%@ include file="../layout/userFooter.jsp" %>