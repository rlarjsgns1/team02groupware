package com.team02.groupware.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.team02.groupware.dto.BoardDto;


@Mapper
public interface BoardMapper {
	
	public List<BoardDto> getBoardList(Map<String, Object> map);
	
	public int getBoardCount(Map<String, Object> map);
	
	public List<String> getDepartList();
	
	public List<BoardDto> getBoardNoticeList();
	
	public void boardInsert(BoardDto bDto);
	
	public int getMaxBoardNum();
	
}
