/**
 * 채팅
 */
	
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
		console.log(chatRoom);
		var chatRoomBody = chatRoom.find('.chat-room-body');
		var sendChatClone = chatRoom.find('.send-chat-clone').clone();
		
		sendChatClone.find('.msg p').text(msg);
		sendChatClone.removeClass('send-chat-clone');
		sendChatClone.css('display', 'block');
		chatRoomBody.append(sendChatClone);
	}
	
	
	
	/*var wsUri = "wss://echo.websocket.org/";
	var output;
	
	function init()
	{
	    output = document.getElementById("output");
	    testWebSocket();
	}

	function testWebSocket()
	{
		websocket = new WebSocket(wsUri);
	   	websocket.onopen = function(evt) { onOpen(evt) };
	   	websocket.onclose = function(evt) { onClose(evt) };
	   	websocket.onmessage = function(evt) { onMessage(evt) };
	   	websocket.onerror = function(evt) { onError(evt) };
	}
	function onOpen(evt)
	{
		writeToScreen("CONNECTED");
	   	doSend("소켓 테스트");
	}

	function onClose(evt)
	{
		writeToScreen("DISCONNECTED");
	}

	function onMessage(evt)
	{
		writeToScreen('<span style="color: blue;">RESPONSE: ' + evt.data+'</span>');
		websocket.close();
	}

	function onError(evt)
	{
		writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
	}

	function doSend(message)
	{
		writeToScreen("SENT: " + message);
		websocket.send(message);
	}

	function writeToScreen(message)
	{
		var pre = document.createElement("p");
		pre.style.wordWrap = "break-word";
		pre.innerHTML = message;
		output.appendChild(pre);
	}

	window.addEventListener("load", init, false);*/
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
