/**
 * 채팅
 */
'use strict'

var stompClient = null;
var stmopTest = null;
var userNickName = sessionStorage.getItem("userNickName");
var userId = sessionStorage.getItem("userId");
var socketRoomCode = 0;
var newMessage = sessionStorage.getItem("newMessage");
console.log(userNickName, userId);

	if(newMessage == "true"){
		$('.new-message-notice').text('!')
	}

	fn_connect();
	function fn_test(event) {
		
		console.log('fn_test')
	    var socket = new SockJS('/test');
	    
	    stmopTest = Stomp.over(socket);
	    stmopTest.connect({}, fn_test2, fn_onError);
	    
	    //event.preventDefault();
	}
	
	function fn_test2() {
	    // Subscribe to the Public Topic
		console.log('fn_test2')
	    stmopTest.subscribe('/topic/public/'+userId+'', fn_test3);
	
	}
	function fn_test3(payload) {
	    
	    var message = JSON.parse(payload.body);
	    console.log('fn_test3',message)
	    $('.new-message-notice').text('!')
	    sessionStorage.setItem("newMessage", "true");
	
	}
	
	function fn_test4(msg, chatRoom){
		
		console.log('fn_test4')
	    var chatMessage = {
	        userId: userId,
	        userNickName: userNickName
	        
	    };
	    stmopTest.send("/app/chat.test/id004", {}, JSON.stringify(chatMessage));
	    stmopTest.send("/app/chat.test/id003", {}, JSON.stringify(chatMessage));
	    
	}

	

	// 채팅방 클릭
	$(document).on('click','.chat-list-room',function(obj){
		
		$('.chat-list-room').css('background-color','#fff');
		$(this).css('background-color','#cfe8fc');
		
		if($(this).hasClass('active')){
			
			$(this).removeClass('active')
			$(this).css('background-color','#fff');
			
			fn_chatRoomClose();
			
		}else{
			
			$('.chat-room').remove();
			//fn_disconnect();
			
			$('.chat-list-room').removeClass('active')
			$(this).addClass('active')
			
			var roomCode = $(this).find('.chat-room-code').val();
			socketRoomCode = roomCode;
			
			var roomInfo = {};
			
			roomInfo.title = $(this).find('.chat-list-title').text();
			roomInfo.user = $(this).find('.chat-list-room-user').text();
			
			var obj = 1;
			//fn_connect(event);
			fn_chatRoomView(roomCode, userId, roomInfo);
			//fn_test4();
			if($(this).hasClass('new')){
				$(this).removeClass('new');
				$(this).find('.chat-list-room-badge').text('')
				if($('.chat-list-room').hasClass('new') == false){
					$('.new-message-notice').text('')
				}
			}
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
				
				$('.chat-room-body').scrollTop(1000000);
				
				
			});
			 
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			}); 
		
		/*$('.chat-room-body').scrollTop($('.chat-room-body')[0].scrollHeight);*/
		
	}
	// 소켓 접속
	function fn_connect(event, obj) {
		console.log('fn_connect')
		
        var socket = new SockJS('/ws');
        console.log('소켓테스트 위치 확인2', obj)
        
        stompClient = Stomp.over(socket);
        stompClient.connect({}, fn_onConnected, fn_onError);
        
	    //event.preventDefault();
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
	    console.log('fn_onConnected')
	    stompClient.subscribe('/topic/public/'+userId+'', fn_onMessageReceived);

	    // Tell your username to the server
	    stompClient.send("/app/chat.addUser",
	        {},
	        JSON.stringify({userId: userId, type: 'JOIN', content: '새로운 유저가 참가 하였습니다.'})
	    )

	}
	// 메시지 수신
	function fn_onMessageReceived(payload) {
		console.log('fn_onMessageReceived')
		
	    var message = JSON.parse(payload.body);
		var msgType = message.type;
		var msgContent = message.content;
		var msgUserId = message.userId;
		var msgUserNickName = message.userNickName;
		var msgRoomCode = message.chatRoomCode;
		var chatRoom = $('body').find('.chat-room-'+msgRoomCode+'');
		var chatListRoom = $('body').find('.chat-list-room-'+msgRoomCode+'');
		console.log(message)
		
		switch(msgType){
		
		case 'CREATE' :
			fn_drawReceiveMsg(chatRoom, message)
			break;
		
		case 'JOIN' :
			console.log('JOIN')
			break;
			
		case 'LEAVE' :
			console.log('LEAVE')
			break;
			
		case 'CHAT' :
			
			if(userId != msgUserId){
				
				console.log('CHAT');
				console.log(message);
				console.log(chatRoom);
				if(chatRoom.css('display') == 'block'){
					
					fn_drawReceiveMsg(chatRoom, message)
					
				}else{
					
					$('.new-message-notice').text('!')
					//sessionStorage.setItem("newMessage", "true");
					chatListRoom.find('.chat-list-room-badge').text('new')
					chatListRoom.addClass('new');
					
				}
				
				
				
			}
			
			fn_drawChatListMsg(chatRoom, message)
			
			
			break;
			
		default : break;
			
		}

	}
	
	// 수신 메시지 채팅방에 그리기
	function fn_drawReceiveMsg(chatRoom, message){
		
		var chatRoomBody = chatRoom.find('.chat-room-body');
		var receivedChatClone = chatRoom.find('.received-chat-clone').clone();
		
		var msgContent = message.content;
		var msgUserNickName = message.userNickName;
		var msgUserId = message.userId;
		var msgType = message.type;
		var msgRoomCode = message.chatRoomCode;
		var currentTime = fn_getTimeStamp();
		
		switch(msgType){
				
				case 'CREATE' :
					
					
					
					break;
				
				case 'JOIN' :
					
					break;
					
				case 'LEAVE' :
					console.log('LEAVE')
					break;
					
				case 'CHAT' :
					
					receivedChatClone.find('.msg p').text(msgContent);
					receivedChatClone.find('.chat-room-name').text(msgUserNickName);
					receivedChatClone.find('.msg-user img').attr('src','/img/users/'+msgUserId+'.jpg');
					receivedChatClone.find('.msg-time').text(currentTime);
					receivedChatClone.removeClass('received-chat-clone');
					receivedChatClone.css('display', 'block');
					chatRoomBody.append(receivedChatClone);
					$('.chat-room-body').scrollTop(1000000);
					
					break;
					
				default : break;
					
				}
		
	}
	
	// 수신메시지 채팅방리스트에 그리기
	function fn_drawChatListMsg(chatRoom, message){
		
		var msgContent = message.content;
		var msgUserNickName = message.userNickName;
		var msgUserId = message.userId;
		var msgType = message.type;
		var msgRoomCode = message.chatRoomCode;
		var currentTime = fn_getTimeStamp();
		
		$('.chat-list-room-'+msgRoomCode+'').find('.text-muted').text(msgContent)
		$('.chat-list-room-'+msgRoomCode+'').find('.chat-list-time').text(currentTime)
	}
	
	// 채팅방 input 버튼 클릭시
	$(document).on('click','.chat-room-input-btn', function(){
		var msgInput = $(this).closest('.chat-room-input').find('.chat-room-msg-input');
		var msg = msgInput.val();
		var chatRoom = $(this).closest('.chat-room');
			
		fn_doSend(msg, chatRoom);
		msgInput.val('');
		$('.chat-room-body').scrollTop(1000000);
	})
	
	// 채팅방 input 엔터 클릭시
	$(document).on('keydown','.chat-room-msg-input', function(key){
		if(key.keyCode == 13){
			
			$('.chat-room-input-btn').click();
		}
		
	})
	
	// 메시지 전송
	function fn_doSend(msg, chatRoom){
		
		var chatRoomCode = chatRoom.find('.chat-room-view-code').val();
		var chatRoomBody = chatRoom.find('.chat-room-body');
		var sendChatClone = chatRoom.find('.send-chat-clone').clone();
		var currentTime = fn_getTimeStamp();
		var chatRoomMember = chatRoom.find('.chat-room-member');
		
		sendChatClone.find('.msg p').text(msg);
		sendChatClone.find('.msg-time').text(currentTime);
		sendChatClone.removeClass('send-chat-clone');
		sendChatClone.css('display', 'block');
		chatRoomBody.append(sendChatClone);
		
        var chatMessage = {
            userId: userId,
            userNickName: userNickName,
            content: msg,
            type: 'CHAT',
            chatRoomCode: chatRoomCode
        };
        
        // 채팅방에 속한 멤버들에게만 메시지 발신
        chatRoomMember.each(function(){
        	
        	var memberId = $(this).val();
        	stompClient.send("/app/chat.sendMessage/"+memberId+"", {}, JSON.stringify(chatMessage));
        })
        
        console.log('fn_doSend')
	}
	
	
	// 현재시간
	function fn_getTimeStamp() {
		  var d = new Date();
		  var s =
			  fn_leadingZeros(d.getFullYear(), 4) + '-' +
			  fn_leadingZeros(d.getMonth() + 1, 2) + '-' +
			  fn_leadingZeros(d.getDate(), 2) + ' ' +
	
			  fn_leadingZeros(d.getHours(), 2) + ':' +
			  fn_leadingZeros(d.getMinutes(), 2)

		  return s;
		}

	function fn_leadingZeros(n, digits) {
	  var zero = '';
	  n = n.toString();

	  if (n.length < digits) {
	    for (var i = 0; i < digits - n.length; i++)
	      zero += '0';
	  }
	  return zero + n;
	}


	
	
	
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
