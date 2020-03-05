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
	  * @method allOngoingDocumentList()
	  * @brief 전자결재 진행중인 전체문서 method
	  * @author 김건훈
	  */	
	 @GetMapping("/allOngoingDocumentList")
	 public String allOngoingDocumentList(Model model) {
		
		model.addAttribute("approvalLine", eaService.approvalLine());
		model.addAttribute("deleteDocument", eaService.deleteDocument());
		model.addAttribute("eaReferrer", eaService.eaReferrer());
		model.addAttribute("eaSecurity", eaService.eaSecurity());
		
		 //logger.info("approvalLine :: {}", eaService.approvalLine().toString());
		 //logger.info("deleteDocument :: {}", eaService.deleteDocument());
		 //logger.info("eaReferrer :: {}", eaService.eaReferrer());
		 //logger.info("eaReferrer :: {}", eaService.eaSecurity());
		 
			return "eaDocument/allOngoingDocumentList";
	}
	 
	 /*
	  * @method documentFormList()
	  * @brief 양식함 리스트 method
	  * @author 김건훈
	  */
	 @GetMapping("/documentFormList")
	 public String documentFormList() {
		 return "eaDocument/documentFormList";
	 }
	 
	
}
