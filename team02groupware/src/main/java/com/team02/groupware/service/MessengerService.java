package com.team02.groupware.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team02.groupware.mapper.MessengerMapper;

@Service
@Transactional
public class MessengerService {
	
	@Autowired
	private MessengerMapper messengerMapper;
	
	
	public List<Map<String,Object>> selectChatRoomList(String userId) {
		
		List<Map<String,Object>> chatRoomListMap = new ArrayList<Map<String,Object>>();
		chatRoomListMap = messengerMapper.selectChatRoomList(userId);
		
		return chatRoomListMap;
	}
	
	public List<Map<String,Object>> chatRoomView(String roomCode) {
			
		List<Map<String,Object>> chatRoomLog = new ArrayList<Map<String,Object>>();
		chatRoomLog = messengerMapper.selectChatRoomView(roomCode);
		
		return chatRoomLog;
	}
	

}
