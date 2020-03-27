/*
 * 프로젝트리스트 관련 제이쿼리
 * 김연지
 * */


$(
				function() {
				//프로젝트 추가 모달
					//submit 버튼 클릭시 프로젝트제목 유효성검사
					$(".pr-submit-btn").click(
							function(checkInput) {
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
					$(".project-list").on('click',
							function(projectListClick) {
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
					//프로젝트 모달 바깥 영역 클릭X
						event.stopPropagation();
						$('#editLayoutItem').modal({
							backdrop : 'static'
						});
						
						var projectCode = $(this).parents(".pr-header").find('.project-code-input').val();
						console.log(projectCode);
						
						var request = $.ajax({
							url: "/ajaxProjectSelectForUpdate",
							method:"GET",
							data: {
								'projectCode' : projectCode
							},
							dataType: "json"
						})
								request.done(function(data) {
									
									$('#updateTitle').val(data.title);
									$('#updateDesc').val(data.desc);
									$('#datepicker1').val(data.start);
									$('#datepicker2').val(data.dead);
									$('#datepicker3').val(data.end);
									
								});
								request.fail(function( jqXHR, textStatus ) {
									alert( "Request failed: " + textStatus );
								}); 
					
					})
					
					
					//멤버수정버튼 클릭시 셀렉트 활성화
					$(".member-update-btn").click(function() {
						$('#update-select2').select2('open');
					})
					
				

				})