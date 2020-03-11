package com.team02.groupware.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team02.groupware.dto.BoardDto;
import com.team02.groupware.dto.PagingDto;
import com.team02.groupware.dto.SearchDto;
import com.team02.groupware.service.BoardService;



@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	
	
	@GetMapping("/boardList")
	public String boardList(Model model, BoardDto bDto, PagingDto pDto, SearchDto sDto ) {
		
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		
		System.out.println(" 컨트롤러 진입시기 boardDto.toString() : "+bDto.toString() );
		System.out.println(" 컨트롤러 진입시기 PagingDto.toString() : "+pDto.toString() );
		System.out.println(" 컨트롤러 진입시기 searchDto.toString() : "+sDto.toString() );
		boardMap = boardService.getBoardList(bDto, pDto, sDto);
		System.out.println("");
		System.out.println(" 컨트롤러에서 겟보드리스트 후 : "+boardMap.toString());
		model.addAttribute("boardList", boardMap.get("boardList"));
		model.addAttribute("pagingDto", boardMap.get("pagingDto"));
		model.addAttribute("searchDto", boardMap.get("searchDto"));
		model.addAttribute("departList", boardMap.get("departList"));
		model.addAttribute("boardNoticeList", boardMap.get("boardNoticeList"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 보드리스트 : "+boardMap.get("boardList"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 페이징dto: "+boardMap.get("pagingDto"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 서치dto: "+boardMap.get("searchDto"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 디파트리스트: "+boardMap.get("departList"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 보드노티스리스트: "+boardMap.get("boardNoticeList"));
		return "board/boardList";
	}
	
	
	@GetMapping("/boardWriteForm")
	public String boardWriteForm(Model model ) {
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap = boardService.getDepartList();
		model.addAttribute("departList", boardMap.get("departList"));
		
		return "board/boardWriteForm";
	}
	@PostMapping("/boardInsert")
	public String boardWrite(Model model, BoardDto bDto, RedirectAttributes redirectA ) {
		
		System.out.println("보드인서트 비디티오 확인 : "+bDto.toString());
		Map<String, Object> boardMap = new HashMap<String, Object>();
		
		boardMap = boardService.boardInsert(bDto);
		
		redirectA.addAttribute("boardNum", boardMap.get("boardNum"));
		
		return "redirect:/boardDetailView";
	}

	@GetMapping("/boardDetailView")
	public String BoardDetailView(Model model, BoardDto bDto, PagingDto pDto, SearchDto sDto, @RequestParam(value="boardNum", required = false) Object boardNum) {
		
		if(boardNum != null) System.out.println("test:" + boardNum.toString());
		System.out.println("보드디테일뷰 bDto 투스트링 : "+bDto.toString());
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap = boardService.selectBoardDetailView(bDto);
		System.out.println("보드디테일뷰 컨트롤러 보드리스트 : " + boardMap.get("boardList"));
		
		model.addAttribute("boardList", boardMap.get("boardList"));
		model.addAttribute("commentList", boardMap.get("commentList"));
		model.addAttribute("pagingDto", pDto);
		model.addAttribute("searchDto", sDto);
		
		return "board/boardDetailView";
	}
	
	@GetMapping("/boardUpdateForm")
	public String boardUpdateForm(Model model) {
		
		model.addAttribute("title", "boardUpdateForm");
		
		return "board/boardUpdateForm";
	}
	
	@GetMapping("/boardUpdate")
	public String boardUpdate(Model model) {
		
		model.addAttribute("title", "boardUpdate");
		
		return "index";
	}
	
	@GetMapping("/boardDelete")
	public String boardDelete(Model model) {
		
		model.addAttribute("title", "boardDelete");
		
		return "index";
	}
	
	@GetMapping("/commentWrite")
	public String commentWrite(Model model) {
		
		model.addAttribute("title", "commentWrite");
		
		return "index";
	}
	
	@GetMapping("/commentUpdate")
	public String commentUpdate(Model model) {
		
		model.addAttribute("title", "commentUpdate");
		
		return "index";
	}
	
	@GetMapping("/commentDelete")
	public String commentDelete(Model model) {
		
		model.addAttribute("title", "commentDelete");
		
		return "index";
	}
	
	@PostMapping("/ajaxResponse")
	public @ResponseBody List<String> ajaxResponse(Model model, @RequestBody BoardDto map) {
		
		System.out.println("ajax로 보내진 배열의 값 : {}" + map);
		System.out.println(map.getBoardCategory());
		System.out.println(map.getBoardTitle());
		model.addAttribute("title", "ajaxResponse");
		List<String> list = new ArrayList<String>();
		return list;
	}

}
