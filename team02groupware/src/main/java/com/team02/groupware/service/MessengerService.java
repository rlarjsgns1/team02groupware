package com.team02.groupware.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team02.groupware.dto.ChatMessage;
import com.team02.groupware.mapper.MessengerMapper;

@Service
@Transactional
public class MessengerService {
	
	@Autowired
	private MessengerMapper messengerMapper;
	
	// 채팅방 리스트 조회
	public List<Map<String,Object>> selectChatRoomList(String userId) {
		
		List<Map<String,Object>> chatRoomListMap = new ArrayList<Map<String,Object>>();
		chatRoomListMap = messengerMapper.selectChatRoomList(userId);
		System.out.println("시간 테스트 서비스단 : " + chatRoomListMap.get(0).get("chatMsgDate"));
		return chatRoomListMap;
	}
	
	// 채팅방 상세보기
	public List<Map<String,Object>> chatRoomView(String roomCode) {
			
		List<Map<String,Object>> chatRoomLog = new ArrayList<Map<String,Object>>();
		chatRoomLog = messengerMapper.selectChatRoomView(roomCode);
		
		return chatRoomLog;
	}
	
	// 채팅 메시지 전송
	public void insertChatMessage(ChatMessage chatMessage) {
		
		messengerMapper.insertChatMessage(chatMessage);
		
	}
	
	

}
