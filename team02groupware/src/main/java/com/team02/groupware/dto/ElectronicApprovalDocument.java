package com.team02.groupware.dto;

/*
 * @file ElectronicApprovalDocument.java
 * @brief 전자결재 관련 DTO
 * @author 김건훈
 */
public class ElectronicApprovalDocument {

	/**
	 * @brief 문서양식 테이블 컬럼별 전역변수
	 * @author 김건훈
	 */
	private String dFormCode; //문서 양식 코드
	private char dSecurityLevel; //보안등급 레벨
	private String dFormTypeCode; //문서 양식 분류 코드
	private String dApprovalFormatCode; //결재양식 포맷 코드
	private String dFormName; //문서 양식 명
	private String dFormAbbreviation; //문서 양식 약칭
	private String dFormDetailExplanation; //문서 양식 상세설명
	private String dSecurityLevelChangeable; //보안등급 변경가능여부
	private String dExpiryDate; //문서 최초 보존연한
	private String dExpiryDateChangeable; //보존연한 변경가능여부
	private String dFormDetailContent; //문서 양식 상세내용
	
	/**
	 * @brief 문서양식 테이블 컬럼별 전역변수 getters&setters
	 * @author 김건훈
	 */
	public String getdFormCode() {
		return dFormCode;
	}
	public void setdFormCode(String dFormCode) {
		this.dFormCode = dFormCode;
	}
	public char getdSecurityLevel() {
		return dSecurityLevel;
	}
	public void setdSecurityLevel(char dSecurityLevel) {
		this.dSecurityLevel = dSecurityLevel;
	}
	public String getdFormTypeCode() {
		return dFormTypeCode;
	}
	public void setdFormTypeCode(String dFormTypeCode) {
		this.dFormTypeCode = dFormTypeCode;
	}
	public String getdApprovalFormatCode() {
		return dApprovalFormatCode;
	}
	public void setdApprovalFormatCode(String dApprovalFormatCode) {
		this.dApprovalFormatCode = dApprovalFormatCode;
	}
	public String getdFormName() {
		return dFormName;
	}
	public void setdFormName(String dFormName) {
		this.dFormName = dFormName;
	}
	public String getdFormAbbreviation() {
		return dFormAbbreviation;
	}
	public void setdFormAbbreviation(String dFormAbbreviation) {
		this.dFormAbbreviation = dFormAbbreviation;
	}
	public String getdFormDetailExplanation() {
		return dFormDetailExplanation;
	}
	public void setdFormDetailExplanation(String dFormDetailExplanation) {
		this.dFormDetailExplanation = dFormDetailExplanation;
	}
	public String getdSecurityLevelChangeable() {
		return dSecurityLevelChangeable;
	}
	public void setdSecurityLevelChangeable(String dSecurityLevelChangeable) {
		this.dSecurityLevelChangeable = dSecurityLevelChangeable;
	}
	public String getdExpiryDate() {
		return dExpiryDate;
	}
	public void setdExpiryDate(String dExpiryDate) {
		this.dExpiryDate = dExpiryDate;
	}
	public String getdExpiryDateChangeable() {
		return dExpiryDateChangeable;
	}
	public void setdExpiryDateChangeable(String dExpiryDateChangeable) {
		this.dExpiryDateChangeable = dExpiryDateChangeable;
	}
	public String getdFormDetailContent() {
		return dFormDetailContent;
	}
	public void setdFormDetailContent(String dFormDetailContent) {
		this.dFormDetailContent = dFormDetailContent;
	}
	
	/**
	 * @brief 문서양식 테이블 컬럼별 전역변수 toString
	 * @author 김건훈
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ElectronicApprovalDocument [dFormCode=");
		builder.append(dFormCode);
		builder.append(", dSecurityLevel=");
		builder.append(dSecurityLevel);
		builder.append(", dFormTypeCode=");
		builder.append(dFormTypeCode);
		builder.append(", dApprovalFormatCode=");
		builder.append(dApprovalFormatCode);
		builder.append(", dFormName=");
		builder.append(dFormName);
		builder.append(", dFormAbbreviation=");
		builder.append(dFormAbbreviation);
		builder.append(", dFormDetailExplanation=");
		builder.append(dFormDetailExplanation);
		builder.append(", dSecurityLevelChangeable=");
		builder.append(dSecurityLevelChangeable);
		builder.append(", dExpiryDate=");
		builder.append(dExpiryDate);
		builder.append(", dExpiryDateChangeable=");
		builder.append(dExpiryDateChangeable);
		builder.append(", dFormDetailContent=");
		builder.append(dFormDetailContent);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
