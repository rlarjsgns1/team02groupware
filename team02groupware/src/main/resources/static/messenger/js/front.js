/**
 * 채팅방 스크립트 작업
 */
$(function(){
			
	// 채팅방 리스트 더블클릭, 채팅방 상세보기
	$('.chat-list-room').dblclick(function(){
		
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
	$(document).on('click','.menu-btn',function(){
		
		var menuItem = $('.menu-item')
		
		if(menuItem.css('display') == 'none'){
			menuItem.css('display', 'block')
		}else if(menuItem.css('display') == 'block'){
			menuItem.css('display', 'none')
		}
		
	})
	
	// 채팅방 close 클릭
	$(document).on('click','.chat-room-close',function(){
		
		fn_chatRoomClose();
	})
	
	// 채팅방 상세보기
	function fn_chatRoomView(n){
		
		var chatRoom = $('.chat-room');
		chatRoom.find('.chat-room-title').text(n.title);
		chatRoom.find('.chat-room-user').text(n.user);
		chatRoom.css('display', 'block');
		
	}
	
	// 채팅방 close
	function fn_chatRoomClose(){
		
		var chatRoom = $('.chat-room');
		chatRoom.css('display', 'none')
		
	}
			
			
			
});