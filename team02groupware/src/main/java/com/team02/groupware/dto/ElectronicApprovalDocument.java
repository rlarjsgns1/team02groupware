package com.team02.groupware.dto;

/*
 * @file ElectronicApprovalDocument.java
 * @brief 전자결재 관련 DTO
 * @author 김건훈
 */
public class ElectronicApprovalDocument {
	private String dCode; //문서코드
	private String dApprover; //결재자
	private String dApprovalOrder; //결재순서
	private String dApprovalStatus; //결재상태
	private String dDeleteReason; //삭제사유
	private String dReferrer; //참조자
	private String dSecurityLevel; //보안등급 레벨
	private String dViewLevel; // 열람 가능 직위
	
	
	public String getdCode() {
		return dCode;
	}
	public void setdCode(String dCode) {
		this.dCode = dCode;
	}
	public String getdApprover() {
		return dApprover;
	}
	public void setdApprover(String dApprover) {
		this.dApprover = dApprover;
	}
	public String getdApprovalOrder() {
		return dApprovalOrder;
	}
	public void setdApprovalOrder(String dApprovalOrder) {
		this.dApprovalOrder = dApprovalOrder;
	}
	public String getdApprovalStatus() {
		return dApprovalStatus;
	}
	public void setdApprovalStatus(String dApprovalStatus) {
		this.dApprovalStatus = dApprovalStatus;
	}
	public String getdDeleteReason() {
		return dDeleteReason;
	}
	public void setdDeleteReason(String dDeleteReason) {
		this.dDeleteReason = dDeleteReason;
	}
	public String getdReferrer() {
		return dReferrer;
	}
	public void setdReferrer(String dReferrer) {
		this.dReferrer = dReferrer;
	}
	public String getdSecurityLevel() {
		return dSecurityLevel;
	}
	public void setdSecurityLevel(String dSecurityLevel) {
		this.dSecurityLevel = dSecurityLevel;
	}
	public String getdViewLevel() {
		return dViewLevel;
	}
	public void setdViewLevel(String dViewLevel) {
		this.dViewLevel = dViewLevel;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ElectronicApprovalDocument [dCode=");
		builder.append(dCode);
		builder.append(", dApprover=");
		builder.append(dApprover);
		builder.append(", dApprovalOrder=");
		builder.append(dApprovalOrder);
		builder.append(", dApprovalStatus=");
		builder.append(dApprovalStatus);
		builder.append(", dDeleteReason=");
		builder.append(dDeleteReason);
		builder.append(", dReferrer=");
		builder.append(dReferrer);
		builder.append(", dSecurityLevel=");
		builder.append(dSecurityLevel);
		builder.append(", dViewLevel=");
		builder.append(dViewLevel);
		builder.append("]");
		return builder.toString();
	}

	
}
