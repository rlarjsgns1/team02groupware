package com.team02.groupware.controller;




import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team02.groupware.service.ElectronicApprovalService;

/*
 * @file ElectronicApprovalController.java
 * @brief 전자결재 컨트롤러
 * @author 김건훈
 */

@Controller
public class ElectronicApprovalController {
	
	  @Autowired //ElectronicApprovalService 의존성 주입
	  private ElectronicApprovalService eaService;

	private static final Logger logger = LoggerFactory.getLogger(ElectronicApprovalController.class);
	 
	
	 /*
	  * @method selectAllOngoingDocumentList()
	  * @brief 전자결재 진행중인 전체문서 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectAllOngoingDocumentList")
	 public String selectAllOngoingDocumentList(Model model) {
		
		model.addAttribute("approvalLine", eaService.selectApprovalLine());
		model.addAttribute("deleteDocument", eaService.selectDeleteDocument());
		model.addAttribute("eaReferrer", eaService.selectEaReferrer());
		model.addAttribute("eaSecurity", eaService.selectEaSecurity());
		
		 //logger.info("approvalLine :: {}", eaService.selectApprovalLine().toString());
		 //logger.info("deleteDocument :: {}", eaService.selectDeleteDocument().toString());
		 //logger.info("eaReferrer :: {}", eaService.selectEaReferrer().toString());
		 //logger.info("eaReferrer :: {}", eaService.selectEaSecurity().toString());
		 
			return "eaDocument/allOngoingDocumentList";
	}
	 
	 /*
	  * @method selectDocumentFormList()
	  * @brief 관리자용 양식함 리스트 method
	  * @author 김건훈
	  */
	 @GetMapping("/selectDocumentFormList")
	 public String selectDocumentFormList() {
		 return "eaDocument/documentFormList";
	 }
	 
	 /*
	  * @method insertDocumentForm()
	  * @brief 관리자용 양식 생성 method
	  * @author 김건훈
	  */
	 @GetMapping("/insertDocumentForm")
	 public String insertDocumentForm() {
		 return "eaDocument/documentForm";
	 }
	 
	 
	 /*
	  * @method approvalFormat()
	  * @brief 결재라인 포맷  sample view
	  * @author 김건훈
	  */
	 @GetMapping("/approvalFormat")
	 public String approvalFormat() {
		 return "eaDocument/eaFormat/approvalFormat";
	 }
	 
	 /*
	  * @method insertDocumentDraft()
	  * @brief 문서 기안하기 method
	  * @author 김건훈
	  */
	 @GetMapping("/insertDocumentDraft")
	 public String insertDocumentDraft() {
		 return "eaDocument/documentDraft";
	 }
	 
	
	 /*
	  * @method selectAllDocumentListForSupervisor()
	  * @brief 전자결재 관리자용 전체문서 리스트
	  * @author 김건훈
	  */	
	 @GetMapping("/selectAllDocumentListForSupervisor")
	 public String selectAllDocumentListForSupervisor() {
			return "eaDocument/documentListForSupervisor";
	}
	 
	 /*
	  * @method selectAllDocumentListForSupervisor()
	  * @brief 전자결재 관리자용 임시 삭제문서 보관함 리스트
	  * @author 김건훈
	  */	
	 @GetMapping("/deleteDocumentList")
	 public String deleteDocumentList() {
			return "eaDocument/deleteDocumentList";
	}	 
	 
	 
	 /*
	  * @method insertEaGeneralSettings()
	  * @brief 전자결재 관리자용 기본설정 세팅
	  * @author 김건훈
	  */	
	 @GetMapping("/insertEaGeneralSettings")
	 public String insertEaGeneralSettings() {
			return "eaDocument/eaGeneralSettings";
	}
	 
	 /*
	  * @method ajaxSetDocumentCodeFormat()
	  * @brief 관리자용 전자결재 기본설정 화면 문서번호 method
	  * @author 김건훈
	  */	
	 	@PostMapping(value="/ajaxSetDocumentCodeFormat",produces = "application/json")
	 	@ResponseBody
		public Map<String,Object> ajaxSetDocumentCodeFormat(@RequestBody Map<String,Object> checkRadioMap){
	 		
	 		//System.out.println(checkRadioMap.toString());
	 		//logger.info("ajax로 보내진 값 :: {}", checkRadioMap.toString());
	 		
	 		String result = eaService.ajaxSetDocumentCodeFormat(checkRadioMap);
	 		//System.out.println("문서 번호 가공 후 결과값------>"+result);
	 		
	 		Map<String,Object> resultMap = new HashMap<String,Object>();
	 		resultMap.put("result", result);
	 		return resultMap;
		}
}
