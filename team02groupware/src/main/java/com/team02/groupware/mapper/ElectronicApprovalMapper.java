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
		
	 /*
	  * @method selectEaDocumentForm()
	  * @brief 양식함관리 페이지 내 문서양식 테이블 조회 method
	  * @author 김건훈
	  */
	 public List<ElectronicApprovalDocument> selectEaDocumentForm();
		 
}
