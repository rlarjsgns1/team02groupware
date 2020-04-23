//myTask.html 도넛 차트 제이쿼리 

(function($) {

	
	var c3DonutChart = c3.generate({
		bindto : '#task-status-chart',
		data : {
			columns : [
					[ "완료", 25.0 ],
					[ "마감일 지남", 25.0 ],
					[ "계획됨", 25.0 ],
					[ "마감일 없음", 25.0 ],
			],
			type : 'donut',
			onclick : function(d, i) {
				console.log("onclick", d, i);
			},
			onmouseover : function(d, i) {
				console.log("onmouseover", d, i);
			},
			onmouseout : function(d, i) {
				console.log("onmouseout", d, i);
			}
		},
		color : {
			pattern : [ 'rgba(88,216,163,1)',
					'rgba(237,28,36,0.6)',
					'rgba(4,189,254,0.6)',
					'rgba(193,196,200, 0.8)'
					]
		},
		padding : {
			top : 0,
			right : 0,
			bottom : 30,
			left : 0,
		},
		donut : {
			title : "전체 업무"
		}
		
	});
	setInterval(function() {
		    c3DonutChart.load({
		      columns: [
		    	  [ "완료", 25.0 ],
					[ "마감일 지남", 25.0 ],
					[ "계획됨", 25.0 ],
					[ "마감일 없음", 25.0 ],
		      ]
		    });
		  }, 3000);

	

})(jQuery);
