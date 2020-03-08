package com.team02.groupware.mapper;

/*
* @file ElectronicApprovalMapper.java
* @brief 전자결재 mapper interface
* @author 김건훈
*/
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.team02.groupware.dto.ElectronicApprovalDocument;

@Mapper
public interface ElectronicApprovalMapper {
	
	
	 	//결재라인 조회 method 
	 public List<ElectronicApprovalDocument> selectApprovalLine();
		
		//임시삭제문서 조회 method 
	 public List<ElectronicApprovalDocument> selectDeleteDocument();
		 
	 	//참조자 조회 method 
	 public List<ElectronicApprovalDocument> selectEaReferrer();
		
	 	//보안등급 조회 method 
	 public List<ElectronicApprovalDocument> selectEaSecurity();
		 
}
