package com.team02.groupware.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.team02.groupware.dto.BoardDto;
import com.team02.groupware.dto.CommentDto;


@Mapper
public interface BoardMapper {
	
	public List<BoardDto> selectBoardList(Map<String, Object> map);
	
	public int selectBoardCount(Map<String, Object> map);
	
	public List<String> selectDepartList();
	
	public List<BoardDto> selectBoardNoticeList();
	
	public int selectMaxBoardNum();
	
	public void insertBoard(BoardDto bDto);
	
	public List<BoardDto> selectBoardDetailView(BoardDto bDto);
	
	public void updateBoardViewCount(BoardDto bDto);
	
	public void updateBoard(BoardDto bDto);
	
	public void deleteBoard(BoardDto bDto);
	
	
	
	public List<CommentDto> selectCommentList(BoardDto bDto);
	
	public void insertComment(Map<String, Object> map);
	
	public int selectMaxCommentNum();
	
	public void updateCommentCount(Map<String, Object> map);
	
	public void updateComment(CommentDto cDto);
	
	
}
