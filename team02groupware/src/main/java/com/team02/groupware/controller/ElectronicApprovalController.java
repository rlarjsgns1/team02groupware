package com.team02.groupware.controller;




import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	  * @brief 전자결재 진행중인 "전체" 문서 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectAllOngoingDocumentList")
	 public String selectAllOngoingDocumentList() {
		
			return "eaDocument/ongoingDocumentList/allOngoingDocumentList";
	}
	 
	 /*
	  * @method selectWaitOngoingDocumentList()
	  * @brief 전자결재 진행중인 "대기" 문서 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectWaitOngoingDocumentList")
	 public String selectWaitOngoingDocumentList() {
		
			return "eaDocument/ongoingDocumentList/waitOngoingDocumentList.html";
	}
	 
	 /*
	  * @method selectCheckOngoingDocumentList()
	  * @brief 전자결재 진행중인 "확인" 문서 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectCheckOngoingDocumentList")
	 public String selectCheckOngoingDocumentList() {
		
			return "eaDocument/ongoingDocumentList/checkOngoingDocumentList.html";
	}
	 
	 /*
	  * @method selectWillOngoingDocumentList()
	  * @brief 전자결재 진행중인 "예정" 문서 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectWillOngoingDocumentList")
	 public String selectWillOngoingDocumentList() {
		
			return "eaDocument/ongoingDocumentList/willOngoingDocumentList.html";
	}
	 
	 /*
	  * @method selectAfterOngoingDocumentList()
	  * @brief 전자결재 진행중인 "진행" 문서 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectAfterOngoingDocumentList")
	 public String selectAfterOngoingDocumentList() {
		
			return "eaDocument/ongoingDocumentList/afterOngoingDocumentList.html";
	}
	 
	 
	 /*
	  * @method selectDocumentFormList()
	  * @brief 관리자용 양식함 리스트 method
	  * @author 김건훈
	  */
	 @GetMapping("/selectDocumentFormList")
	 public String selectDocumentFormList() {
		 return "eaDocument/eaDocumentForSupervisor/documentFormList";
	 }
	 
	 /*
	  * @method insertDocumentForm()
	  * @brief 관리자용 양식 생성 method
	  * @author 김건훈
	  */
	 @GetMapping("/insertDocumentForm")
	 public String insertDocumentForm() {
		 return "eaDocument/eaDocumentForSupervisor/documentForm";
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
		 return "eaDocument/draftDocument/documentDraft";
	 }
	 
	
	 /*
	  * @method selectAllDocumentListForSupervisor()
	  * @brief 전자결재 관리자용 전체문서 리스트
	  * @author 김건훈
	  */	
	 @GetMapping("/selectAllDocumentListForSupervisor")
	 public String selectAllDocumentListForSupervisor() {
			return "eaDocument/eaDocumentForSupervisor/documentListForSupervisor";
	}
	 
	 /*
	  * @method selectAllDocumentListForSupervisor()
	  * @brief 전자결재 관리자용 임시 삭제문서 보관함 리스트
	  * @author 김건훈
	  */	
	 @GetMapping("/deleteDocumentList")
	 public String deleteDocumentList() {
			return "eaDocument/eaDocumentForSupervisor/deleteDocumentList";
	}	 
	 
	 
	 /*
	  * @method insertEaGeneralSettings()
	  * @brief 전자결재 관리자용 기본설정 세팅
	  * @author 김건훈
	  */	
	 @GetMapping("/insertEaGeneralSettings")
	 public String insertEaGeneralSettings() {
			return "eaDocument/eaDocumentForSupervisor/eaGeneralSettings";
	}
	 
	 /*
	  * @method ajaxSetDocumentCodeFormat()
	  * @brief 관리자용 전자결재 기본설정 화면 문서번호 method
	  * @author 김건훈
	  */	
	 	@PostMapping(value="/ajaxSetDocumentCodeFormat",produces = "application/json")
	 	@ResponseBody
		public Map<String,Object> ajaxSetDocumentCodeFormat(@RequestBody Map<String,Object> checkRadioMap){
	 		
	 		logger.info("ajax로 보내진 check된 radio map :: {}", checkRadioMap.toString());
	 		
	 		String result = eaService.ajaxSetDocumentCodeFormat(checkRadioMap);
	 		
	 		logger.info("문서 번호 가공 후 결과값 :: {}", result);
	 		
	 		Map<String,Object> resultMap = new HashMap<String,Object>();
	 		resultMap.put("result", result);
	 		return resultMap;
		}
}
