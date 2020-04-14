/**
 * 메신저 화면단 스크립트 작업
 */

			
	
	
	// 채팅방 메뉴바 클릭
	$(document).on('click','.menu-btn',function(e){
		var menuItem = $(this).next('.menu-item');
		if(menuItem.is(':hidden')){
			menuItem.css('display', 'block')
		}else{
			menuItem.css('display', 'none')
		}
	})
	
	// 채팅방 close 클릭
	$(document).on('click','.chat-room-close',function(e){
		
		e.preventDefault();
		$('.chat-list-room').css('background-color','#fff');
		fn_chatRoomClose();
	})
	
	// 새로운 대화방 생성 Modal에서 참여자 버튼 클릭
	$(document).on('click','input.chat-check-btn',function(){
		
		var userInfo = $(this).closest('label')
		var index = $('.chat-radio-user').index($(this).closest('.chat-radio-user'))
		console.log(index)
		if($(this).prop('checked')) { 
			fn_nameTag(userInfo, index,'add');        	
         }else{
        	 fn_nameTag(userInfo, index,'remove');			
         }
	})
	
	// fn_nameTag: 새로운 채팅방 유저 체크버튼 클릭시 네임태그 추가,제거
	function fn_nameTag(userInfo, index, action){
		
		switch(action){
		
		case "add" :
			
			var nameTagClone = $('.name-tag-clone').clone();
			var userName = userInfo.find('.chat-radio-user-name').text();
			var userImage = userInfo.find('.chat-radio-user-image').attr('src');
			
			nameTagClone.find('.tag-user-image').attr('src',userImage);
			nameTagClone.find('.tag-user-name').text(userName);
			nameTagClone.find('.tag-index').val(index);
			
			nameTagClone.removeClass('name-tag-clone');
			nameTagClone.css('display','inline-block');
			
			$('.name-tag-area').append(nameTagClone);
			
			break;
			
		case "remove" :
			
			var nameTag = $('.name-tag-area').find('.tag-index[value='+index+']')
			nameTag.closest('.name-tag').remove();
			
			break;
		
		}
		
	}
	
	// 네임태그 클릭시 제거
	$(document).on('click','.name-tag',function(){
		
		var index = $(this).find('.tag-index').val();
		console.log(index)
		$('.chat-radio-user').eq(index).find('.chat-check-btn').prop("checked", false);
		
		$(this).remove();
	})
	
	
	// 채팅방 close
	function fn_chatRoomClose(){
		
		var chatRoom = $('.chat-room');
		chatRoom.css('display', 'none')
		
	}
	
	
	// 모달창 생성 클릭 이벤트
	$(document).on('click','.modal-request', function(){
		
		if($(this).hasClass('chat-list-create-room')){
			
			fn_modalRequest('/createChatRoomModal', '#create-chat-room-modal');
			
		}else if($(this).hasClass('invite-user')){
			
			fn_modalRequest('/inviteUserModal', '#invite-user-modal');
			
		}
		
	})
	
	// 모달 리퀘스트 함수
	function fn_modalRequest(modalUrl, title, param){
		
		//param 변수가 undefined 라면 
		if(param == undefined) param = {};
		
		var request = $.ajax({
		  url: modalUrl,
		  method: "GET",
		  data: param,
		  dataType: "html"
		});
		
		request.done(function( data ) {
			
			$('body').append(data)
			
			//html 렌더링이 완료될때까지 대기
			setTimeout(function(){
				
				$(title).on('hidden.bs.modal', function (e) {
									
					$('form').each(function() {
					      this.reset();
					});
					$('.name-tag').remove();
					
				})
				$(title).modal('show');
				
			}, 200);
			
		});
		 
		request.fail(function( jqXHR, textStatus ) {
		  alert( "Request failed: " + textStatus );
		}); 
	
	}
	
	
	
	
