/**
 * 채팅
 */
'use strict'

var stompClient = null;
var userName = sessionStorage.getItem("userNickName");
var userId = sessionStorage.getItem("userId");

console.log(userName, userId);

	// 채팅방 클릭
	$(document).on('click','.chat-list-room',function(){
		
		$('.chat-list-room').css('background-color','#fff');
		$(this).css('background-color','#cfe8fc');
		
		if($(this).hasClass('active')){
			
			$(this).removeClass('active')
			$(this).css('background-color','#fff');
			
			fn_chatRoomClose();
			
		}else{
			
			$('.chat-room').remove();
			fn_disconnect();
			$('.chat-list-room').removeClass('active')
			$(this).addClass('active')
			
			var roomCode = $(this).find('.chat-room-code').val();
			
			var roomInfo = {};
			
			roomInfo.title = $(this).find('.chat-list-title').text();
			roomInfo.user = $(this).find('.chat-list-room-user').text();
			
			fn_connect(event);
			fn_chatRoomView(roomCode, userId, roomInfo);
		}

	});
	
	// 채팅방 상세보기
	function fn_chatRoomView(roomCode, userId, roomInfo){
		
		console.log(roomCode, userId)
		var request = $.ajax({
			  url: '/chatRoomView',
			  method: "GET",
			  data: {roomCode : roomCode,
				  	userId : userId},
			  dataType: "html"
			});
			
			request.done(function( data ) {
				console.log(data)
				$('body').append(data)
				var chatRoom = $('.chat-room');
				chatRoom.find('.chat-room-title').text(roomInfo.title);
				chatRoom.find('.chat-room-user').text(roomInfo.user);
				chatRoom.find('.chat-room-menu .menu-item').css('display', 'none');

				chatRoom.css('display', 'block');
				
				
				setTimeout(function(){
					
					$('.chat-room-body').scrollTop($('.chat-room-body').height());
					
				}, 200);
				
				
			});
			 
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			}); 
		
		/*$('.chat-room-body').scrollTop($('.chat-room-body')[0].scrollHeight);*/
		
	}
	// 소켓 접속
	function fn_connect(event) {
		console.log('소켓테스트 위치 확인1')
		
        var socket = new SockJS('/ws');
        console.log('소켓테스트 위치 확인2')
        
        stompClient = Stomp.over(socket);
        stompClient.connect({}, fn_onConnected, fn_onError);
	       
	    event.preventDefault();
	}
	
	// 소켓 연결 끊기
	function fn_disconnect() {
		
		if (stompClient !== null) {
		    stompClient.disconnect();
		}
	}
	
	// 에러 체크
	function fn_onError(error) {
		console.log('error체크')
	}
	
	// 소켓 접속 후
	function fn_onConnected() {
	    // Subscribe to the Public Topic
	    stompClient.subscribe('/topic/public2', fn_onMessageReceived);

	    // Tell your username to the server
	    stompClient.send("/app/chat.addUser",
	        {},
	        JSON.stringify({sender: userId, type: 'JOIN', content: '새로운 유저가 참가 하였습니다.'})
	    )

	}
	// 메시지 수신
	function fn_onMessageReceived(payload) {
		console.log('위치 확인')
	    var message = JSON.parse(payload.body);
		var msgType = message.type;
		var msgContent = message.content;
		var msgSender = message.sender;
		
		switch(msgType){
		
		case 'JOIN' :
			console.log('JOIN')
			break;
			
		case 'LEAVE' :
			console.log('LEAVE')
			break;
			
		case 'CHAT' :
			
			if(userId != msgSender){
				
				var chatRoom = $('body').find('.chat-room');
				console.log('CHAT');
				console.log(message);
				console.log(chatRoom);
				fn_drawReceiveMsg(chatRoom, message)
			}
		
			break;
			
		default : break;
			
		}

	}
	
	// 수신 메시지 채팅방에 그리기
	function fn_drawReceiveMsg(chatRoom, message){
		
		var chatRoomBody = chatRoom.find('.chat-room-body');
		var receivedChatClone = chatRoom.find('.received-chat-clone').clone();
		
		var msgContent = message.content;
		var msgSender = message.sender;
		
		receivedChatClone.find('.msg p').text(msgContent);
		receivedChatClone.find('.chat-room-name').text(msgSender);
		receivedChatClone.removeClass('received-chat-clone');
		receivedChatClone.css('display', 'block');
		chatRoomBody.append(receivedChatClone);
		
	}
	
	
	// 채팅방 input 버튼 클릭시
	$(document).on('click','.chat-room-input-btn', function(){
		var msgInput = $(this).closest('.chat-room-input').find('.chat-room-msg-input');
		var msg = msgInput.val();
		var chatRoom = $(this).closest('.chat-room');
			
		fn_doSend(msg, chatRoom);
		msgInput.val('');
		
	})
	
	// 채팅방 input 엔터 클릭시
	$(document).on('keydown','.chat-room-msg-input', function(key){
		if(key.keyCode == 13){
			
			$('.chat-room-input-btn').click();
		}
		
	})
	
	// 메시지 전송 함수
	function fn_doSend(msg, chatRoom){
		
		var chatRoomCode = chatRoom.find('.chat-room-view-code').val();
		var chatRoomBody = chatRoom.find('.chat-room-body');
		var sendChatClone = chatRoom.find('.send-chat-clone').clone();
		
		sendChatClone.find('.msg p').text(msg);
		sendChatClone.removeClass('send-chat-clone');
		sendChatClone.css('display', 'block');
		chatRoomBody.append(sendChatClone);
		
        var chatMessage = {
            sender: userId,
            content: msg,
            type: 'CHAT',
            chatRoomCode: chatRoomCode
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
	}
	
	
	
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
