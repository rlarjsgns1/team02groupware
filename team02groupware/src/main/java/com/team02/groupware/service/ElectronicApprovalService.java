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
	 public List<ElectronicApprovalDocument> selectApprovalLine(){
		
		 List<ElectronicApprovalDocument> approvalLine = eaMapper.selectApprovalLine();
		 return approvalLine; 
	 };
	 
	//임시삭제문서 조회 method 
	 public List<ElectronicApprovalDocument> selectDeleteDocument(){
		
		 List<ElectronicApprovalDocument> deleteDocument = eaMapper.selectDeleteDocument();
		 return deleteDocument; 
	 };
	
	//참조자 조회 method 
	 public List<ElectronicApprovalDocument> selectEaReferrer(){
		
		 List<ElectronicApprovalDocument> eaReferrer = eaMapper.selectEaReferrer();
		 return eaReferrer;
	 };
		
	//보안등급 조회 method 
	 public List<ElectronicApprovalDocument> selectEaSecurity(){
		
		 List<ElectronicApprovalDocument> eaSecurity = eaMapper.selectEaSecurity();
		 return eaSecurity;
	 };

}
