/**
 * 메신저 화면단 스크립트 작업
 */
$(function(){
			
	// 채팅방 리스트 더블클릭, 채팅방 상세보기
	$('.chat-list-room').click(function(){
		
		$('.chat-list-room').css('background-color','#fff');
		$(this).css('background-color','#cfe8fc');
		
		if($(this).hasClass('active')){
			
			$(this).removeClass('active')
			$(this).css('background-color','#fff');
			
			fn_chatRoomClose();
			
		}else{
			
			$('.chat-list-room').removeClass('active')
			$(this).addClass('active')
			
			var chatRoom = {};
			chatRoom.title = $(this).find('.chat-list-title').text();
			chatRoom.user = $(this).find('.chat-list-room-user').text();
			
			fn_chatRoomView(chatRoom);
		}

	});
	
	// 채팅방 메뉴바 클릭
	$(document).on('click','.menu-btn',function(e){
		
		e.preventDefault();
		
		var menuItem = $('.menu-item')
		
		if(menuItem.css('display') == 'none'){
			menuItem.css('display', 'block')
		}else if(menuItem.css('display') == 'block'){
			menuItem.css('display', 'none')
		}
		
	})
	
	// 채팅방 close 클릭
	$(document).on('click','.chat-room-close',function(e){
		
		e.preventDefault();
		$('.chat-list-room').css('background-color','#fff');
		fn_chatRoomClose();
	})
	
	// 새로운 대화방 생성시 참여자 라디오버튼 클릭, 네임태그 추가
	$(document).on('click','input.chat-radio-btn',function(){
		
		var index = $(this).parent().index('label')
		var checkNum = $(this).siblings('input.radio-check-num')
		var userInfo = $(this).closest('label')
		
		if(checkNum.val() == index) {
 
			checkNum.val('-1')
			$(this).prop("checked", false);
			fn_nameTag(userInfo, 'remove');
			
         }else{
 
        	checkNum.val(''+index+'');
        	fn_nameTag(userInfo, 'add');
        	
         }
	})
	
	// 네임태그 클릭시 제거
	$(document).on('click','.name-tag',function(){
		
		var tagCheckNum = $(this).find('.tag-check-num').val();
		var radioBtn = $('.chat-radio-btn[name='+tagCheckNum+'')
		var checkNum = radioBtn.siblings('input.radio-check-num')
		
		checkNum.val('-1')
		radioBtn.prop("checked", false);
		
		$(this).remove();
	})
	
	// 채팅방 상세보기
	function fn_chatRoomView(e){
		
		var chatRoom = $('.chat-room');
		chatRoom.find('.chat-room-title').text(e.title);
		chatRoom.find('.chat-room-user').text(e.user);
		chatRoom.css('display', 'block');
		
	}
	
	// 채팅방 close
	function fn_chatRoomClose(){
		
		var chatRoom = $('.chat-room');
		chatRoom.css('display', 'none')
		
	}
	
	// 채팅방 생성시 네임태그 추가,제거
	function fn_nameTag(userInfo, action){
		
		
		var nameTagClone = $('.name-tag-clone').clone();
		var userName = userInfo.find('.chat-radio-user-name').text();
		var userImage = userInfo.find('.chat-radio-user-image').attr('src');
		var tagCheckName = userInfo.find('.chat-radio-btn').attr('name');
		
		switch(action){
		
		case "add" :
			
			nameTagClone.find('.tag-user-image').attr('src',userImage);
			nameTagClone.find('.tag-user-name').text(userName);
			nameTagClone.find('.tag-check-num').val(tagCheckName)
			
			nameTagClone.addClass(tagCheckName);
			nameTagClone.removeClass('name-tag-clone');
			nameTagClone.css('display','inline-block');
			
			$('.name-tag-area').append(nameTagClone);
			
			break;
			
		case "remove" :
			
			$('.'+tagCheckName+'').remove();
			
			break;
		
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
			
			
			
});