package com.team02.groupware.dto;

public class Project {

	private String pCode;	// 프로젝트코드
	private String eCode;	// 사원번호
	private String pTitle;	// 프로젝트제목
	private String pDesc;	// 프로젝트설명
	private String pAccess;	// 프로젝트공개범위
	private String pStatus;	// 프로젝트상태
	private String pStart;	// 프로젝트시작일
	private String pEnd;	// 프로젝트실제완료일
	private String pDeadline;	// 프로젝트마감일
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String geteCode() {
		return eCode;
	}
	public void seteCode(String eCode) {
		this.eCode = eCode;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public String getpAccess() {
		return pAccess;
	}
	public void setpAccess(String pAccess) {
		this.pAccess = pAccess;
	}
	public String getpStatus() {
		return pStatus;
	}
	public void setpState(String pStatus) {
		this.pStatus = pStatus;
	}
	public String getpStart() {
		return pStart;
	}
	public void setpStart(String pStart) {
		this.pStart = pStart;
	}
	public String getpEnd() {
		return pEnd;
	}
	public void setpEnd(String pEnd) {
		this.pEnd = pEnd;
	}
	public String getpDeadline() {
		return pDeadline;
	}
	public void setpDeadline(String pDeadline) {
		this.pDeadline = pDeadline;
	}
	
	
}
