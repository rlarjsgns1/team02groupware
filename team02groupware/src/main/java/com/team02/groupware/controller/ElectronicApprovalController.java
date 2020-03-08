package com.team02.groupware.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	  * @brief 양식함 리스트 method
	  * @author 김건훈
	  */
	 @GetMapping("/selectDocumentFormList")
	 public String selectDocumentFormList() {
		 return "eaDocument/documentFormList";
	 }
	 
	 /*
	  * @method insertDocumentForm()
	  * @brief 양식 생성 method
	  * @author 김건훈
	  */
	 @GetMapping("/insertDocumentForm")
	 public String insertDocumentForm() {
		 return "eaDocument/documentForm";
	 }
	 
	 
}
