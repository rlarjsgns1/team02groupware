package com.team02.groupware.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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
	 
		
	 /*
	  * @method selectEaDocumentForm()
	  * @brief 양식함관리 페이지 내 문서양식 테이블 조회 method
	  * @author 김건훈
	  */
	 public List<ElectronicApprovalDocument> selectEaDocumentForm(){
		
		 List<ElectronicApprovalDocument> eaDocumentForm = eaMapper.selectEaDocumentForm();
		 return eaDocumentForm;
	 };
	 
	 /*
	  * @method ajaxSetDocumentCodeFormat()
	  * @brief 관리자용 전자결재 기본설정 화면 문서번호 처리 service method
	  * @author 김건훈
	  */	
	 public String ajaxSetDocumentCodeFormat(Map<String,Object> checkRadioMap) {
		 
		//System.out.println(checkRadioMap.toString());
		 
		String companyCode =(String)checkRadioMap.get("companyCode");
		String companyCodeRadioVal =(String)checkRadioMap.get("companyCodeRadioVal");
		String unitRadioVal =(String)checkRadioMap.get("unitRadioVal");
		String registerDateRadioVal =(String)checkRadioMap.get("registerDateRadioVal");
		String serialNumRadioVal =(String)checkRadioMap.get("serialNumRadioVal");
		
		/*
		 * System.out.println(companyCode); 
		 * System.out.println(companyCodeRadioVal);
		 * System.out.println(unitRadioVal); 
		 * System.out.println(registerDateRadioVal);
		 * System.out.println(serialNumRadioVal);
		 */
		String result = "";
		
		//회사코드 사용 여부에 따른 문서번호에 포함 여부
		if(companyCodeRadioVal.equals("A")) {
			result+=companyCode+"-";
		}
		
		//약칭 및 소속 사용 여부에 따른 문서번호에 포함 여부
		if(unitRadioVal.equals("A")) {
			result+="개발-";
		}else if(unitRadioVal.equals("B")) {
			result+="프로젝트사업-";
		}else if(unitRadioVal.equals("C")) {
			result+="개발-프로젝트사업-";
		}
		
		//문서 등록 시점에 따른 문서번호 형식
		  SimpleDateFormat sdf = null;
	      Calendar calender = Calendar.getInstance();
	      String strToday=null;
	 
		if(registerDateRadioVal.equals("A")) {
			sdf = new SimpleDateFormat("yyyyMMdd");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("B")) {
			sdf = new SimpleDateFormat("yyMMdd");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("C")) {
			sdf = new SimpleDateFormat("yyyyMM");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("D")) {
			sdf = new SimpleDateFormat("yyMM");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("E")) {
			sdf = new SimpleDateFormat("yyyy");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("F")) {
			sdf = new SimpleDateFormat("yy");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}
		
		//일련 번호 형식에 따른 문서번호 양식
		if(serialNumRadioVal.equals("A")) {
			result+="01";
		}else if(serialNumRadioVal.equals("B")) {
			result+="001";
		}else if(serialNumRadioVal.equals("C")) {
			result+="0001";
		}
		
		//System.out.println("문서 번호 가공 후 결과값------>"+result);
		 return result;
	 };
}
