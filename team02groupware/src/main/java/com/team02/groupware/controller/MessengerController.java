package com.team02.groupware.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team02.groupware.dto.ChatMessage;
import com.team02.groupware.service.MessengerService;


@Controller
public class MessengerController {
	
	@Autowired
	private MessengerService messengerService;
	
	// 대화방 생성 모달
	@GetMapping("/createChatRoomModal")
	public String createChatRoomModal(Model model){
		
		return "messenger/modal/createChatRoomModal";
	}
	
	// 채팅방 유저 초대 모달
	@GetMapping("/inviteUserModal")
	public String inviteUserModal(Model model){
		
		return "messenger/modal/inviteUserModal";
	}
	// 채팅방 리스트
	@GetMapping("/selectChatRoomList")
	public String selectChatRoomList(Model model, 
			@RequestParam(value="userId") String userId, HttpSession session){
		
		System.out.println("채팅방 리스트 유저아이디 : " + userId);
		List<Map<String,Object>> chatRoomListMap = new ArrayList<Map<String,Object>>();
		chatRoomListMap = messengerService.selectChatRoomList(userId);
		
		model.addAttribute("chatRoomListMap", chatRoomListMap);
		System.out.println(session.getAttribute("userId")+" : 채팅방리스트 세션 아이디 확인 ");
		return "messenger/chatRoomList";
	}
	// 채팅방 상세보기
	@GetMapping("/chatRoomView")
	public String chatRoomView(Model model,
			@RequestParam(value="userId") String userId,
			@RequestParam(value="roomCode") String roomCode){
		
		List<Map<String,Object>> chatRoomLog = new ArrayList<Map<String,Object>>();
		chatRoomLog = messengerService.chatRoomView(roomCode);
		System.out.println(chatRoomLog.toString());
		model.addAttribute("chatRoomLog", chatRoomLog);
		model.addAttribute("userId", userId);
		model.addAttribute("roomCode", roomCode);
		
		
		return "messenger/chatRoomView";
	}
	
	@GetMapping("/chatTest")
	public String chatTest(Model model) {
		
			
		return "messenger/chatTest";
	}
	
	@MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public2")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		System.out.println(chatMessage.getContent());
		System.out.println(chatMessage.getType());
		System.out.println(chatMessage.getSender());
		System.out.println(chatMessage.getChatRoomCode());
		
		messengerService.insertChatMessage(chatMessage);
		
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public2")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
    	
    	System.out.println(chatMessage.getSender());
		System.out.println(chatMessage.getType());
		System.out.println(chatMessage.getContent());
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
	
	

}
