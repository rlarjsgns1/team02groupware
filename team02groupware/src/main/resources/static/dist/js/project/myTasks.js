/*
 * 내 업무 관련 제이쿼리
 * 김연지
 * */

$(function() {
	// 업무 체크박스 클릭시 사라짐
	$(document).on('click','.task-checkbox',function(){
		var taskCode = $(this).siblings('input[name="taskCode"]').val();
		var delTask = $(this).parents('.mytask-item');
		console.log('체크박스 클릭');
		console.log(taskCode);
		var request = $.ajax({
			url: "/taskSuccess",
			method: "GET",
			data: { 'taskCode' : taskCode
			},
			dataType: "json"
		});
		
		request.done(function( data ) {
			console.log("done");
			if(data.result==1){
				delTask.slideUp();
			}
		});
		
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
	})

	
	
	
	// 업무 수정 모달
	
	var delTask;
	var taskCode;
	var taskModal = function(){
		
		var request = $.ajax({
				url: "/taskModalopen",
				method:"GET",
				data: {
					'taskCode' : taskCode
				},
				dataType: "html"
			})
			request.done(function(data) {
				console.log('성공');
				
				if($('#editLayoutItem').length > 0){				
					$('#editLayoutItem').remove();
					
				}
				
				$('body').append(data);
				
				$('.select2').select2();
					
				$(".member-update-btn").click(function() {
					$('#update-select2').select2('open');
				})
				
				$('#editLayoutItem').modal({
					backdrop : 'static'
	
				})
			
				var listDelete = $('.project-delete-btn');
	            listDelete.on('click', function() {
	                swal({
	                    title: "해당 업무를 삭제하시겠습니까?",
	                    icon: "warning",
	                    buttons: ["취소", "삭제"],
	                    dangerMode: true,
	                })
	                .then((willDelete) => {
	                    if (willDelete) {
	                    	console.log('삭제버튼클릭');
	                    	var request = $.ajax({
	                    	  url: "/taskDelete",
	                    	  method: "POST",
	                    	  data: { 'taskCode' : taskCode },
	                    	  dataType: "json"
	                    	});
	                    	 
	                    	request.done(function( data ) {
	                    		console.log('삭제');
	                    		console.log(data.result);
	                    		if(data.result==1){
	                    			delTask.remove();
	                    		}
	                    		$('.close').click();
	                    		 swal({
			                            title: "업무가 삭제되었습니다.",
			                            icon: "success",
			                        });
	                    		
	                    	});
	                    	 
	                    	request.fail(function( jqXHR, textStatus ) {
	                    	  alert( "Request failed: " + textStatus );
	                    	});
	                    	
	                       
	                    } else {
	                        swal("삭제가 취소되었습니다.");
	                    }
	                });
	            });
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			}); 
	}
	
	
			
	$(document).on('click','.list-modal-btn',function(){
		delTask = $(this).parents('.mytask-item');
		taskCode = $(this).parents('.mytask-item').find('input[name="taskCode"]').val();
	
		taskModal();
			
	})
	
	
	$(document).on('click', '.task-title',function() {
			
		delTask = $(this).parents('.mytask-item');
		taskCode = $(this).parents('.mytask-item').find('input[name="taskCode"]').val();
		
		console.log(taskCode);
		taskModal();
	})
		
});