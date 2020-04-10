package com.team02.groupware.controller;




import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team02.groupware.dto.ElectronicApprovalDocument;
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
	  * @method selectOngoingDocumentDetail()
	  * @brief 전자결재 진행중인 문서 detail view method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectOngoingDocumentDetail")
	 public String selectOngoingDocumentDetail(@RequestParam(value="docType", required = false) String docType, Model model) {
		 	logger.info("결재 진행 중인 문서 목록에서 넘어온 문서 구분 값 :: {}", docType);
		 	
		 	model.addAttribute("docType", docType);
		 	
			return "eaDocument/ongoingDocumentList/ongoingDocumentDetail.html";
	}
	 
	 
	 /*
	  * @method selectAllDoneDocumentList()
	  * @brief 결재 후 "전체" 문서 목록 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectAllDoneDocumentList")
	 public String selectAllDoneDocumentList() {
			return "eaDocument/doneDocumentList/allDoneDocumentList.html";
	}
	 
	 /*
	  * @method selectDraftDoneDocumentList()
	  * @brief 결재 후 "기안" 문서 목록 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectDraftDoneDocumentList")
	 public String selectDraftDoneDocumentList() {
			return "eaDocument/doneDocumentList/draftDoneDocumentList.html";
	}
	 
	 /*
	  * @method selectApprovalDoneDocumentList()
	  * @brief 결재 후 "결재" 문서 목록 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectApprovalDoneDocumentList")
	 public String selectApprovalDoneDocumentList() {
			return "eaDocument/doneDocumentList/approvalDoneDocumentList.html";
	}
	 
	 /*
	  * @method selectReceiveDoneDocumentList()
	  * @brief 결재 후 "수신" 문서 목록 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectReceiveDoneDocumentList")
	 public String selectReceiveDoneDocumentList() {
			return "eaDocument/doneDocumentList/receiveDoneDocumentList.html";
	}
	 
	 /*
	  * @method selectPassAndReferDoneDocumentList()
	  * @brief 결재 후 "회람/참조" 문서 목록 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectPassAndReferDoneDocumentList")
	 public String selectPassAndReferDoneDocumentList() {
			return "eaDocument/doneDocumentList/passAndReferDoneDocumentList.html";
	}
	 
	 /*
	  * @method selectReturnDoneDocumentList()
	  * @brief 결재 후 "반려" 문서 목록 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectReturnDoneDocumentList")
	 public String selectReturnDoneDocumentList() {
			return "eaDocument/doneDocumentList/returnDoneDocumentList.html";
	}
	 
	 
	 /*
	  * @method selectTemporarySaveDocumentList()
	  * @brief 임시저장 문서 목록 method
	  * @author 김건훈
	  */	
	 @GetMapping("/selectTemporarySaveDocumentList")
	 public String selectTemporarySaveDocumentList() {
			return "eaDocument/doneDocumentList/temporarySaveDocumentList.html";
	}
	 
	 
	 /*
	  * @method selectDocumentFormList()
	  * @brief 관리자용 양식함 리스트 method
	  * @author 김건훈
	  */
	 @GetMapping("/selectDocumentFormList")
	 public String selectDocumentFormList(Model model) {
		 Map<String, Object> eaDocumentFormListMap = eaService.selectEaDocumentForm();
		 List<ElectronicApprovalDocument> eaDocumentFormTypeList = eaService.selectEaDocumentFormType();
		 List<ElectronicApprovalDocument> eaDocumentSetting = eaService.selectEaDocumentSetting();
		 //logger.info("문서 양식 테이블 조회 결과값 :: {}", eaDocumentFormListMap.get("eaDocumentFormList"));
		 //logger.info("문서 양식 전체개수 결과값 :: {}", eaDocumentFormListMap.get("eaDocumentFormListCount"));
		 //logger.info("문서 양식 분류 테이블 조회 결과값 :: {}", eaDocumentFormTypeList);
		 //logger.info("전자결재 기본설정 테이블 조회 결과값 :: {}", eaDocumentSetting.toString());
		 model.addAttribute("eaDocumentFormList", eaDocumentFormListMap.get("eaDocumentFormList"));
		 model.addAttribute("eaDocumentFormListCount", eaDocumentFormListMap.get("eaDocumentFormListCount"));
		 model.addAttribute("eaDocumentFormTypeList", eaDocumentFormTypeList);
		 model.addAttribute("eaDocumentSetting", eaDocumentSetting);
		 return "eaDocument/eaDocumentForSupervisor/documentFormList.html";
	 }
	 
	 /*
	  * @method insertDocumentForm()
	  * @brief 관리자용 문서 양식 생성 폼
	  * @author 김건훈
	  */
	 @GetMapping("/insertDocumentForm")
	 public String insertDocumentForm(Model model) {
		 List<ElectronicApprovalDocument> eaDocumentFormTypeList = eaService.selectEaDocumentFormType();
		 //logger.info("문서 양식 분류 테이블 조회 결과값 :: {}", eaDocumentFormTypeList);
		 model.addAttribute("eaDocumentFormTypeList", eaDocumentFormTypeList);
		 
		 return "eaDocument/eaDocumentForSupervisor/documentForm.html";
	 }
	 
	 
	 /*
	  * @method insertDocumentFormPro()
	  * @brief 관리자용 문서 양식 생성 method
	  * @author 김건훈
	  */	
	 	@PostMapping(value="/insertDocumentFormPro",produces = "application/json")
	 	@ResponseBody
		public Map<String,Object> insertDocumentFormPro(@ModelAttribute ElectronicApprovalDocument eadto){
	
	 		//logger.info("ajax로 보내진 문서양식생성 입력값  :: {}", eadto.toString());

	 		int result=eaService.insertDocumentForm(eadto);
	 		
	 		Map<String,Object> resultMap = new HashMap<String,Object>();
	 		resultMap.put("result", result);
	 		return resultMap;
		}
	 	
	 	
	 	 /*
		  * @method deleteDocumentFormPro()
		  * @brief 관리자용 문서 양식 삭제 method
		  * @author 김건훈
		  */	
		 	@PostMapping(value="/deleteDocumentFormPro",produces = "application/json")
		 	@ResponseBody
			public Map<String,Object> deleteDocumentFormPro(@RequestBody List<String> eaDocumentFormListCodeArr ){
		 		logger.info("문서 양식 삭제하기위한 문서양식코드 리스트 :: {}", eaDocumentFormListCodeArr);
		 		
		 		int result = eaService.deleteDocumentForm(eaDocumentFormListCodeArr);
		 		
		 		Map<String,Object> resultMap = new HashMap<String,Object>();
		 		resultMap.put("result", result);
		 		return resultMap;
			}
	 
	 
	 /*
	  * @method selectDocumentFormDetail()
	  * @brief 관리자용 양식 상세보기
	  * @author 김건훈
	  */
	 @GetMapping("/selectDocumentFormDetail")
	 public String selectDocumentFormDetail() {
		 return "eaDocument/eaDocumentForSupervisor/documentFormDetail.html";
	 }
	 
	 /*
	  * @method updateDocumentForm()
	  * @brief 관리자용 양식 수정 화면
	  * @author 김건훈
	  */
	 @GetMapping("/updateDocumentForm")
	 public String updateDocumentForm() {
		 return "eaDocument/eaDocumentForSupervisor/updateDocumentForm.html";
	 }
	 
	 
	 /*
	  * @method approvalFormat()
	  * @brief 결재라인 포맷  sample view
	  * @author 김건훈
	  */
	 @GetMapping("/approvalFormat")
	 public String approvalFormat() {
		 return "eaDocument/eaFormat/approvalFormat.html";
	 }
	 
	 /*
	  * @method insertDocumentDraft()
	  * @brief 문서 기안하기 method
	  * @author 김건훈
	  */
	 @GetMapping("/insertDocumentDraft")
	 public String insertDocumentDraft() {
		 return "eaDocument/draftDocument/documentDraft.html";
	 }
	 
	
	 /*
	  * @method selectAllDocumentListForSupervisor()
	  * @brief 전자결재 관리자용 전체문서 리스트
	  * @author 김건훈
	  */	
	 @GetMapping("/selectAllDocumentListForSupervisor")
	 public String selectAllDocumentListForSupervisor() {
			return "eaDocument/eaDocumentForSupervisor/documentListForSupervisor.html";
	}
	 
	 /*
	  * @method selectAllDocumentListForSupervisor()
	  * @brief 전자결재 관리자용 임시 삭제문서 보관함 리스트
	  * @author 김건훈
	  */	
	 @GetMapping("/deleteDocumentList")
	 public String deleteDocumentList() {
			return "eaDocument/eaDocumentForSupervisor/deleteDocumentList.html";
	}	 
	 
	 
	 /*
	  * @method insertEaGeneralSettings()
	  * @brief 전자결재 관리자용 기본설정 세팅
	  * @author 김건훈
	  */	
	 @GetMapping("/insertEaGeneralSettings")
	 public String insertEaGeneralSettings() {
			return "eaDocument/eaDocumentForSupervisor/eaGeneralSettings.html";
	}
	 
	 /*
	  * @method ajaxSetDocumentCodeFormat()
	  * @brief 관리자용 전자결재 기본설정 화면 문서번호 method
	  * @author 김건훈
	  */	
	 	@PostMapping(value="/ajaxSetDocumentCodeFormat",produces = "application/json")
	 	@ResponseBody
		public Map<String,Object> ajaxSetDocumentCodeFormat(@RequestBody Map<String,Object> checkRadioMap){
	 		
	 		//logger.info("ajax로 보내진 check된 radio map :: {}", checkRadioMap.toString());
	 		
	 		String result = eaService.ajaxSetDocumentCodeFormat(checkRadioMap);
	 		
	 		//logger.info("문서 번호 가공 후 결과값 :: {}", result);
	 		
	 		Map<String,Object> resultMap = new HashMap<String,Object>();
	 		resultMap.put("result", result);
	 		return resultMap;
		}
	 	
	 	 /*
		  * @method ajaxUpdateEaRule()
		  * @brief 사내 전자결재 규정 update method
		  * @author 김건훈
		  */	
		 	@PostMapping(value="/ajaxUpdateEaRule",produces = "application/json")
		 	@ResponseBody
			public Map<String,Object> ajaxUpdateEaRule(@RequestParam(value = "eaRuleVal") String eaRuleVal){
		 		
		 		//logger.info("ajax로 보내진 사내전자결재규정 text editor 값 :: {}", eaRuleVal);
		 		int result = eaService.updateEaRule(eaRuleVal);
		 		//logger.info("사내 전자결재 규정 UPDATE METHOD 정상 처리 여부 :: {}", result);
		 		
		 		Map<String,Object> resultMap = new HashMap<String,Object>();
		 		resultMap.put("result", result);
		 		return resultMap;
			}
		 	
		 	 /*
			  * @method ajaxInsertDocumentFormType()
			  * @brief 문서 양식 분류 insert method
			  * @author 김건훈
			  */	
			 	@PostMapping(value="/ajaxInsertDocumentFormType",produces = "application/json")
			 	@ResponseBody
				public Map<String,Object> ajaxInsertDocumentFormType(@RequestParam(value = "inputDocumentFormTypeVal") String inputDocumentFormTypeVal){
			 		
			 		//logger.info("ajax로 보내진 입력한 문서 양식 분류 value:: {}", inputDocumentFormTypeVal); 	
			 		ElectronicApprovalDocument eaDto = new ElectronicApprovalDocument();
			 		eaDto.setdFormType(inputDocumentFormTypeVal);
			 		//logger.info("문서양식분류 insert 처리 결과:: {}", result); 	
			 		Map<String,Object> resultMap = new HashMap<String,Object>();
			 		resultMap = eaService.insertDocumentFormType(eaDto);
			 		
			 		return resultMap;
				}
			 	
		 	 /*
			  * @method ajaxDeleteDocumentFormType()
			  * @brief 문서 양식 분류 Delete method
			  * @author 김건훈
			  */	
			 	@PostMapping(value="/ajaxDeleteDocumentFormType",produces = "application/json")
			 	@ResponseBody
				public Map<String,Object> ajaxDeleteDocumentFormType(@RequestParam(value = "deleteFormTypeCode") String deleteFormTypeCode){
			 		
			 		//logger.info("ajax로 보내진 삭제할 문서분류코드값:: {}", deleteFormTypeCode); 	
			 		
			 		int result = eaService.deleteDocumentFormType(deleteFormTypeCode);
			 		
			 		Map<String,Object> resultMap = new HashMap<String,Object>();
			 		resultMap.put("result", result);
			 		
			 		return resultMap;
				}
			 	
			 	/*
				  * @method ajaxUpdateDocumentFormType()
				  * @brief 문서 양식 분류 update method
				  * @author 김건훈
				  */	
				 	@PostMapping(value="/ajaxUpdateDocumentFormType",produces = "application/json")
				 	@ResponseBody
					public Map<String,Object> ajaxUpdateDocumentFormType(	@RequestParam(value = "updateDocumentFormCode") String updateDocumentFormCode,
																			@RequestParam(value = "updateDocumentFormInputVal") String updateDocumentFormInputVal){
				 		
				 		logger.info("ajax로 보내진 수정 관련 문서분류코드값:: {}", updateDocumentFormCode); 	
				 		logger.info("ajax로 보내진 수정할 문서분류변경값:: {}", updateDocumentFormInputVal); 	
				 		
				 		ElectronicApprovalDocument eaDto = new ElectronicApprovalDocument();
				 		eaDto.setdFormTypeCode(updateDocumentFormCode);
				 		eaDto.setdFormType(updateDocumentFormInputVal);
				 		int result = eaService.updateDocumentFormType(eaDto);
				 		Map<String,Object> resultMap = new HashMap<String,Object>();
				 		resultMap.put("result", result);
				 		
				 		return resultMap;
					}
}
