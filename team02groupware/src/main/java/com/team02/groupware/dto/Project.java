package com.team02.groupware.dto;

import java.util.Date;

public class Project {

	//프로젝트
	private String projectCode;	// 프로젝트코드
	private String employeeCode;	// 사원번호
	private String projectTitle;	// 프로젝트제목
	private String projectDate;	// 프로젝트작성일
	private String projectDesc;	// 프로젝트설명
	private String projectAccess;	// 프로젝트공개범위
	private String projectStatus;	// 프로젝트상태
	private Date projectStart;	// 프로젝트시작일
	private Date projectEnd;	// 프로젝트실제완료일
	private Date projectDeadline;	// 프로젝트마감일
	
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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
	public Date getProjectStart() {
		return projectStart;
	}
	public void setProjectStart(Date projectStart) {
		this.projectStart = projectStart;
	}
	public Date getProjectEnd() {
		return projectEnd;
	}
	public void setProjectEnd(Date projectEnd) {
		this.projectEnd = projectEnd;
	}
	public Date getProjectDeadline() {
		return projectDeadline;
	}
	public void setProjectDeadline(Date projectDeadline) {
		this.projectDeadline = projectDeadline;
	}
	public String getProjectDate() {
		return projectDate;
	}
	public void setProjectDate(String projectDate) {
		this.projectDate = projectDate;
	}
	
	
	
	//업무리스트 정보
	private String tasklistCode;
	private String tasklistName;
	
	//업무상세정보
	private String taskCode;
	private String taskTitle;
	private String taskDesc;
	private String taskDate;
	private String taskDeadline;
	private String taskStart;
	private String taskEnd;
	private String taskStatus;

	public String getTasklistCode() {
		return tasklistCode;
	}
	public void setTasklistCode(String tasklistCode) {
		this.tasklistCode = tasklistCode;
	}
	public String getTasklistName() {
		return tasklistName;
	}
	public void setTasklistName(String tasklistName) {
		this.tasklistName = tasklistName;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
	public String getTaskDeadline() {
		return taskDeadline;
	}
	public void setTaskDeadline(String taskDeadline) {
		this.taskDeadline = taskDeadline;
	}
	public String getTaskStart() {
		return taskStart;
	}
	public void setTaskStart(String taskStart) {
		this.taskStart = taskStart;
	}
	public String getTaskEnd() {
		return taskEnd;
	}
	public void setTaskEnd(String taskEnd) {
		this.taskEnd = taskEnd;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [projectCode=");
		builder.append(projectCode);
		builder.append(", employeeCode=");
		builder.append(employeeCode);
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
		builder.append(", tasklistCode=");
		builder.append(tasklistCode);
		builder.append(", tasklistName=");
		builder.append(tasklistName);
		builder.append(", taskCode=");
		builder.append(taskCode);
		builder.append(", taskTitle=");
		builder.append(taskTitle);
		builder.append(", taskDesc=");
		builder.append(taskDesc);
		builder.append(", taskDate=");
		builder.append(taskDate);
		builder.append(", taskDeadline=");
		builder.append(taskDeadline);
		builder.append(", taskStart=");
		builder.append(taskStart);
		builder.append(", taskEnd=");
		builder.append(taskEnd);
		builder.append(", taskStatus=");
		builder.append(taskStatus);
		builder.append("]");
		return builder.toString();
	}
	
	
}
