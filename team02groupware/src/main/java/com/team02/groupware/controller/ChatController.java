package com.team02.groupware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

import com.team02.groupware.dto.ChatMessage;
import com.team02.groupware.service.MessengerService;

@RestController
public class ChatController {
	
	@Autowired
	private MessengerService messengerService;
	
	@MessageMapping("/chat.sendMessage/{socketRoomCode}")
    @SendTo("/topic/public/{socketRoomCode}")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage, @DestinationVariable String socketRoomCode) {
		
		System.out.println(chatMessage.getContent());
		System.out.println(chatMessage.getType());
		System.out.println(chatMessage.getUserId());
		System.out.println(chatMessage.getUserNickName());
		System.out.println(chatMessage.getChatRoomCode());
		
		messengerService.insertChatMessage(chatMessage);
		
        return chatMessage;
    }
	
	@MessageMapping("/chat.test/{userId}")
    @SendTo("/topic/public/{userId}")
    public ChatMessage sendMessage2(@Payload ChatMessage chatMessage, @DestinationVariable String userId) {
		
		System.out.println(chatMessage.getContent());
		System.out.println(chatMessage.getType());
		System.out.println(chatMessage.getUserId());
		System.out.println(chatMessage.getUserNickName());
		System.out.println(chatMessage.getChatRoomCode());
		
		
		
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public2")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
    	
    	System.out.println(chatMessage.getUserId());
		System.out.println(chatMessage.getUserNickName());
		System.out.println(chatMessage.getType());
		System.out.println(chatMessage.getContent());
        headerAccessor.getSessionAttributes().put("userid", chatMessage.getUserId());
        return chatMessage;
    }
    
    @MessageMapping("/chat.createChatRoom")
    @SendTo("/topic/public2")
    public ChatMessage createChatRoom(@Payload ChatMessage chatMessage){
    	
    	
    	
        return chatMessage;
    }

}
