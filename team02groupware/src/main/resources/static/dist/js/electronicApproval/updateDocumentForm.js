/*
 * @file updateDocumentForm.js
 * @brief 양식수정 페이지 관련 js
 * @author 김건훈
 */

		$(function(){
			/*
			  * @brief 옵션 선택 드롭다운 키워드 변경 이벤트
			  * @author 김건훈
			  */	
			$('.dropdown-item').on('click',function(){
				//console.log('드롭다운버튼클릭');
				var searchType = $(this).text();
				var tag = "<i class=\"ik ik-chevron-down mr-0 align-middle\"></i>";
				//console.log(searchType);
				$(this).parent().siblings('.dropdown-toggle').text(searchType);
				$(this).parent().siblings('.dropdown-toggle').append(tag);
			});
			
			
			/*
			  * @brief icheck plug-in 사용
			  * @author 김건훈
			  */

			$(".ea-icheck").iCheck({

				checkboxClass: 'icheckbox_square-blue'

			});
			 
			 //수정화면 로딩시 DB에서 꺼내온 체크박스 정보 바탕으로 체크 표시
			
			$(window).ready(function(){
			
				var dSecurityLevelChangeable = $('#document-form-security-value').val();
				var dExpiryDateChangeable = $('#document-form-expiry-value').val();
				var dFormCode = "[[${eaDto.dFormCode}]]";
				console.log(dSecurityLevelChangeable);
				console.log(dExpiryDateChangeable);
				console.log(dFormCode);
				
				if(dSecurityLevelChangeable=='Y'){
					$('#document-form-security-level-check-box').iCheck('check');
				}
				if(dExpiryDateChangeable=='Y'){
					
					$('#document-form-expiry-date-check-box').iCheck('check');
				}
				if(dFormCode=='EAF001'){
					$('#approval-format-1').prop('checked','checked');
					
				}
			});

			
			/*
			  * @brief 양식 수정 페이지 테이블 내 약칭,보존연한,보안등급 물음표 아이콘 Modal Event
			  * @author 김건훈
			  */	
			$('.ik-help-circle').on('mouseover',function(e){
				//console.log('마우스오버');
				var ruleTipType = $(this).siblings().text()
				console.log(ruleTipType)
				if(ruleTipType=='약칭'){
					$('#modal-content-type').text('약칭은 문서 번호에 쓰이기 때문에 간단할 수록 좋습니다. 중복하여 사용할 수 있지만 구분하는 것이 좋습니다.');	
				}else if(ruleTipType=='보존 연한'){
					$('#modal-content-type').text('문서의 초기값으로 설정 할 보존연한을 선택합니다. 변경 금지 선택 시 기안자와 결재자가 이를 수정할 수 없습니다. 보존 연한이 만료되면 삭제 문서 목록으로 이동합니다.');
				}else if(ruleTipType=='보안 등급'){
					$('#modal-content-type').text('문서의 초기값으로 설정 할 보안등급을 선택합니다. 변경 금지 선택 시 기안자와 결재자가 이를 수정할 수 없습니다. 보안 등급에 따라 열람 권한이 제한됩니다.');
				}
				
				var divLeft = e.pageX - 150
				var divTop = e.pageY - 50
				
				$('.ruletip').css({display:"block", "top": divTop, "left": divLeft});
				
				$(this).css("color","black");
				
			});
		
			$('.ik-help-circle').on('mouseleave',function(){
				
				$('.ruletip').css("display","none");
				$(this).css("color","#bcc8d8");
			});
			
			/* summernote plug-in */
			   $('#ea-summernote').summernote({
		             height: 300,                 
		             minHeight: null,             
		             maxHeight: null,             
		             focus: true,
		             lang: "ko-KR",
		             popover: {
		                 image: [],
		                 link: [],
		                 air: []
		               }
		     });
			
			   /* 뒤로가기 버튼 클릭시 팝업창 */
			   $(document).keyup(function() {
				  
				   //크롬 상위 버전 이라 custom messeage 지원 안함
				   $(window).on("beforeunload", function() {
					    return "";
					});
				   
				   //폼 제출후 바인딩 풀어주기
						/*    $("해당 폼").on("submit", function (e) {
				       		  $(window).off("beforeunload");
				              return true;
				    }); */
			   });
					
					   
				});