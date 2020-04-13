package com.team02.groupware.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;




@Mapper
public interface MessengerMapper {
	
	public List<Map<String, Object>> selectChatRoomList(String userId);
	
}
