package com.team02.groupware.dto;

public class Project {

	private String projectCode;	// 프로젝트코드
	private String employeeNum;	// 사원번호
	private String projectTitle;	// 프로젝트제목
	private String projectDate;	// 프로젝트작성일
	private String projectDesc;	// 프로젝트설명
	private String projectAccess;	// 프로젝트공개범위
	private String projectStatus;	// 프로젝트상태
	private String projectStart;	// 프로젝트시작일
	private String projectEnd;	// 프로젝트실제완료일
	private String projectDeadline;	// 프로젝트마감일
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getEmployeeNum() {
		return employeeNum;
	}
	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public String getProjectAccess() {
		return projectAccess;
	}
	public void setProjectAccess(String projectAccess) {
		this.projectAccess = projectAccess;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getProjectStart() {
		return projectStart;
	}
	public void setProjectStart(String projectStart) {
		this.projectStart = projectStart;
	}
	public String getProjectEnd() {
		return projectEnd;
	}
	public void setProjectEnd(String projectEnd) {
		this.projectEnd = projectEnd;
	}
	public String getProjectDeadline() {
		return projectDeadline;
	}
	public void setProjectDeadline(String projectDeadline) {
		this.projectDeadline = projectDeadline;
	}
	public String getProjectDate() {
		return projectDate;
	}
	public void setProjectDate(String projectDate) {
		this.projectDate = projectDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [projectCode=");
		builder.append(projectCode);
		builder.append(", employeeNum=");
		builder.append(employeeNum);
		builder.append(", projectTitle=");
		builder.append(projectTitle);
		builder.append(", projectDate=");
		builder.append(projectDate);
		builder.append(", projectDesc=");
		builder.append(projectDesc);
		builder.append(", projectAccess=");
		builder.append(projectAccess);
		builder.append(", projectStatus=");
		builder.append(projectStatus);
		builder.append(", projectStart=");
		builder.append(projectStart);
		builder.append(", projectEnd=");
		builder.append(projectEnd);
		builder.append(", projectDeadline=");
		builder.append(projectDeadline);
		builder.append("]");
		return builder.toString();
	}
	
}
