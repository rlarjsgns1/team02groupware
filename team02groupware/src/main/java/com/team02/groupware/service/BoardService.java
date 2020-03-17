package com.team02.groupware.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team02.groupware.dto.BoardDto;
import com.team02.groupware.dto.CommentDto;
import com.team02.groupware.dto.PagingDto;
import com.team02.groupware.dto.SearchDto;
import com.team02.groupware.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public Map<String, Object> getBoardList(BoardDto bDto, PagingDto pDto, SearchDto sDto){
		// default값 설정
		int viewNum;
		int selectPage;
		
		viewNum = pDto.getViewNum();
		selectPage = pDto.getSelectPage();
		
		System.out.println("보드서비스 겟보드 카운트 전");
		
		/* 페이징 로직 시작부분 */
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap.put("boardDto", bDto);
		boardMap.put("searchDto", sDto);
		int boardCount = boardMapper.selectBoardCount(boardMap);
		System.out.println("보드서비스 겟보드 카운트 후");
		System.out.println("보드카운트 : "+ boardCount);
		
		boolean isPrevBtn;			// 이전 버튼 생성 유무 위한 boolean 변수
		boolean isNextBtn;			// 다음 버튼 생성 유무 위한 boolean 변수
		
		int pageFirstNum;			// 현재 페이지의 첫번째 페이징넘버
		int pageLastNum;			// 현재 페이지의 마지막 페이징 넘버
		
		int maxPage = 0;
		
		if(boardCount % viewNum == 0) maxPage = boardCount / viewNum;		// 최대 페이지수 구하기 위한 조건문
		if(boardCount % viewNum != 0) maxPage = boardCount / viewNum + 1;	// 전체 게시글수 / 게시글보기갯수 = 최대 페이지 갯수, else 나머지가 있을경우 +1
		
		
		if(selectPage % 5 == 0) {								// 맨 왼쪽 페이징넘버 구하기 위한 로직
			pageFirstNum = ((selectPage / 5) -1) * 5 + 1;		
		}else {
			pageFirstNum = (selectPage / 5) * 5 + 1;
		}
		
		pageLastNum = pageFirstNum + 4;							// 맨 오른쪽 페이징넘버 구하기 위한 로직
		if(pageLastNum > maxPage) pageLastNum = maxPage;		// 최대 페이지수보다 커지기 않게 제한 걸기
		
		
		if(maxPage <= 5) {						// 현재 선택된 페이지에 따른 이전버튼, 다음버튼 생성 유무 구하기 위한 로직
												// 둘다 false일 경우, maxPage가 5 이하일 경우
			isPrevBtn = false;
			isNextBtn = false;
		}else if(selectPage <= 5) {				// 이전버튼 false, 다음버튼 true인 경우, 선택페이지가 5 이하일 경우
			
			isPrevBtn = false;
			isNextBtn = true;
		}else if(maxPage-pageFirstNum < 5){		// 이전버튼 true, 다음버튼 false일 경우, 최대페이지수가 현재 페이징 첫번째 수와의 차이가 5보다 낮을 경우
			
			isPrevBtn = true;
			isNextBtn = false;
		}else {									// 그외에는 모두 true
			
			isPrevBtn = true;
			isNextBtn = true;
		}
		System.out.println("보드서비스 겟보드리스트 전");

		pDto.setLimitNum((selectPage-1) * viewNum);
		pDto.setSelectPage(selectPage);
		pDto.setViewNum(viewNum);
		
		boardMap.put("pagingDto", pDto);
		System.out.println(boardMap.get("pagingDto").toString());
		System.out.println(boardMap.get("boardDto").toString());
		System.out.println(boardMap.get("searchDto").toString());
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		boardList = boardMapper.selectBoardList(boardMap);
		System.out.println("보드서비스 겟보드리스트 후");
		System.out.println("보드리스트 : " + boardList.toString());
		/* 페이징 값 셋팅 */
		
		pDto.setPageFirstNum(pageFirstNum);
		pDto.setPageLastNum(pageLastNum);
		pDto.setPrevBtn(isPrevBtn);
		pDto.setNextBtn(isNextBtn);
		
		List<String> departList = new ArrayList<String>();
		departList = boardMapper.selectDepartList();
		System.out.println("디파트리스트 투스트링 : "+departList.toString());
		
		List<BoardDto> boardNoticeList = new ArrayList<BoardDto>();
		boardNoticeList = boardMapper.selectBoardNoticeList();
		System.out.println("겟보드 노티스 리스트 : "+boardNoticeList.toString());
		
		
		System.out.println(sDto.getIsSearchCheck()+ "******************검색중*******************");
		if("true".equals(sDto.getIsSearchCheck())) {
			System.out.println("겟서치체크 트루");
			String boardTitle = null;
			String searchWord = sDto.getSearchInput();
			String subSearchWord = null;
			for(BoardDto i : boardList) {
				System.out.println(i.getBoardTitle());
				boardTitle = i.getBoardTitle();
				if(boardTitle.indexOf(searchWord) != -1) {
					
					subSearchWord = boardTitle.substring(boardTitle.indexOf(searchWord), boardTitle.indexOf(searchWord)+searchWord.length());
					
					System.out.println("인덱스오브 : "+boardTitle.indexOf(searchWord));
					System.out.println("문자열 길이 서치워드  : " + searchWord.length());
					System.out.println("섭스트링 : "+ boardTitle.substring(boardTitle.indexOf(searchWord), boardTitle.indexOf(searchWord)+searchWord.length()));
					System.out.println("리플레이스 : " + boardTitle.replace(subSearchWord,"<p id=\"searchWord\">"+subSearchWord+"</p>"));
					i.setBoardSearchWord(boardTitle.replace(subSearchWord,"<em class=\"searchWord\">"+subSearchWord+"</em>"));
				}else {
					i.setBoardSearchWord(boardTitle);
				}
			}
		}
		
		boardMap.put("boardList", boardList);
		boardMap.put("pagingDto", pDto);
		boardMap.put("searchDto", sDto);
		boardMap.put("departList", departList);
		boardMap.put("boardNoticeList", boardNoticeList);
		
		return boardMap;
	}
	
	
	public Map<String, Object> getDepartList(){

		List<String> departList = new ArrayList<String>();
		departList = boardMapper.selectDepartList();
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		
		boardMap.put("departList", departList);

		return boardMap;
	}
	
	public Map<String, Object> boardInsert(BoardDto bDto){

		boardMapper.insertBoard(bDto);
		
		int maxBoardNum = boardMapper.selectMaxBoardNum();
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap.put("boardNum", maxBoardNum);
		
		return boardMap;
	}
	
	public Map<String, Object> selectBoardDetailView(BoardDto bDto){
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		List<CommentDto> commentList = new ArrayList<CommentDto>();
		
		boardMapper.updateBoardViewCount(bDto);
		boardList = boardMapper.selectBoardDetailView(bDto);
		commentList = boardMapper.selectCommentList(bDto);
		
		boardMap.put("boardList", boardList);
		boardMap.put("commentList", commentList);
		System.out.println("보드디테일뷰 보드리스트 : " + boardList.toString());
		System.out.println("보드디테일뷰 코멘트리스트 : " + commentList.toString());
		
		return boardMap;
	}
	
	
	public Map<String, Object> selectBoardUpdateForm(BoardDto bDto){
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		
		boardList = boardMapper.selectBoardDetailView(bDto);
		
		boardMap.put("boardList", boardList);
		
		return boardMap;

	}
	
	public void updateBoard(BoardDto bDto) {
		
		boardMapper.updateBoard(bDto);
		
	}
	
	public void deleteBoard(BoardDto bDto) {
		
		boardMapper.deleteBoard(bDto);
		
	}
	
	public Map<String, Object> commentInsert(BoardDto bDto, CommentDto cDto){
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");	
		Date time = new Date();	
		String currentTime = format1.format(time);
		
		boardMap.put("commentDto", cDto);
		boardMap.put("currentTime", currentTime);
		boardMap.put("boardDto", bDto);
		boardMap.put("isCommentCount", "true");
		boardMapper.insertComment(boardMap);
		boardMapper.updateCommentCount(boardMap);
		
		int commentNum = boardMapper.selectMaxCommentNum();
		System.out.println("커멘트 인서트 커멘트넘 : " + commentNum);
		boardMap.put("commentNum", commentNum);
		
		return boardMap;
	}
	
	public void commentUpdate(CommentDto cDto){
		
		boardMapper.updateComment(cDto);

	}


	public void commentDelete(BoardDto bDto, CommentDto cDto) {
		
		boardMapper.deleteComment(cDto);
		boardMapper.deleteCommentCount(bDto);
		
	}
	
	
	
}
