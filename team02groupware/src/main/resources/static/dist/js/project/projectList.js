/*
 * 프로젝트리스트 관련 제이쿼리
 * 김연지
 * */


$(
				function() {
				//http://localhost/projectList?currentPage=2
				//주소값에?짤라서 currentPage (indexOf)>-1
				//display = 1:none, 2:block
					         
				//프로젝트 리스트 뷰 전환
					$('.view-list').click(function(){
						var url = $(location).attr('href');
						var sub = url.substring(29);
						
						var spl = sub.split('=');
						console.log(url);
						console.log(spl);
						console.log(sub)
						
						var str = spl.indexOf('currentPage');
						if(str>-1){
							$('.project-card').css('display','none');
							$('.pr-table-list').css('display','block');
						}
						
					});
					$('.view-grid').click(function(){
						$('.project-card').css('display','flex');
						$('.pr-table-list').css('display','none');
					})
							
					
				//프로젝트 추가 모달
					//submit 버튼 클릭시 프로젝트제목 유효성검사
					$(".pr-submit-btn").click(function(checkInput) {
								if ($('[name="projectTitle"]').val() == '') {
									$('[name="projectTitle"]').css("border",
											"1px solid red");
									$('[name="projectTitle"]').focus();
									return false;
								}
								
								projectAddForm.action = "/projectInsert";
								projectAddForm.submit();

							})
					//멤버추가버튼 클릭시 셀렉트 활성화
					$(".member-add-btn").click(function() {
						$('#add-select2').select2('open');
					})

				//프로젝트 클릭시 /taskList로 이동
					$(".project-list").on('click',function(projectListClick) {
								var projectCode = $(this).find(
										'.project-code-input').val();
								var projectTitle = $(this).find('h3').text();
								
								console.log(projectCode);
								console.log(projectTitle);
								location.href = '/taskList?projectCode='
										+ projectCode + '&projectTitle='
										+ projectTitle + '';

							})

				//프로젝트 수정 모달
					$(".pr-setting-btn").on('click', function() {
						//console.log('프로젝트 수정 버튼 클릭')
					//프로젝트 모달 바깥 영역 클릭X
						event.stopPropagation();
						/*$('#editLayoutItem').modal({
							backdrop : 'static'
						});*/
						var delProject = $(this).parents('.project-list-wrap');
						var projectCode = $(this).parents(".pr-header").find('.project-code-input').val();
						console.log(projectCode);
						
						var request = $.ajax({
							url: "/projectUpdateModal",
							method:"GET",
							data: {
								'projectCode' : projectCode
							},
							dataType: "html"
						})
								request.done(function(data) {
									//console.log('성공');
									console.log(data);
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
						                    title: "해당 프로젝트를 삭제하시겠습니까?",
						                    icon: "warning",
						                    buttons: ["취소", "삭제"],
						                    dangerMode: true,
						                })
						                .then((willDelete) => {
						                    if (willDelete) {
						                    	console.log('삭제버튼클릭');
						                    	var request = $.ajax({
						                    	  url: "/projectDelete",
						                    	  method: "POST",
						                    	  data: { 'projectCode' : projectCode },
						                    	  dataType: "html"
						                    	});
						                    	 
						                    	request.done(function( data ) {
						                    		console.log('삭제');
						                    		$('.close').click();
						                    		delProject.remove();
						                    		
						                    	});
						                    	 
						                    	request.fail(function( jqXHR, textStatus ) {
						                    	  alert( "Request failed: " + textStatus );
						                    	});
						                    	
						                        swal({
						                            title: "프로젝트가 삭제되었습니다.",
						                            icon: "success",
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
					
					})
					
					
					
					
				

				})