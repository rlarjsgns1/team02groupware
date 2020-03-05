package com.team02.groupware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team02.groupware.dto.ElectronicApprovalDocument;
import com.team02.groupware.mapper.ElectronicApprovalMapper;

/*
 * @file ElectronicApprovalService.java
 * @brief 전자결재 서비스 로직
 * @author 김건훈
 */

@Service
@Transactional
public class ElectronicApprovalService {
	
	 @Autowired //ElectronicApprovalMapper 의존성 주입
	 private ElectronicApprovalMapper eaMapper;
	 
	 
	//결재라인 조회 method
	 public List<ElectronicApprovalDocument> approvalLine(){
		
		 List<ElectronicApprovalDocument> approvalLine = eaMapper.approvalLine();
		 return approvalLine; 
	 };
	 
	//임시삭제문서 조회 method 
	 public List<ElectronicApprovalDocument> deleteDocument(){
		
		 List<ElectronicApprovalDocument> deleteDocument = eaMapper.deleteDocument();
		 return deleteDocument; 
	 };
	
	//참조자 조회 method 
	 public List<ElectronicApprovalDocument> eaReferrer(){
		
		 List<ElectronicApprovalDocument> eaReferrer = eaMapper.eaReferrer();
		 return eaReferrer;
	 };
		
	//보안등급 조회 method 
	 public List<ElectronicApprovalDocument> eaSecurity(){
		
		 List<ElectronicApprovalDocument> eaSecurity = eaMapper.eaSecurity();
		 return eaSecurity;
	 };

}
