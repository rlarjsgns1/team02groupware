package com.team02.groupware.controller;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team02.groupware.dto.Project;
import com.team02.groupware.service.ProjectService;


/*
 * @file ProjectController.java
 * @brief project controller
 * @author kimyeonji
 */

@Controller
public class ProjectController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private ProjectService projectService;

	
	
	
	//내 업무 조회 메서드
	@GetMapping("/myTasks")
	public String myTasks() {
		return "project/myTasks";
	}
	
	//캘린더 조회 메서드
	@GetMapping("/taskCalendar")
	public String taskCalendar() {
		return "project/taskCalendar";
	}
	//업무리스트 추가 ajax 메서드
 
	@PostMapping("/tasklistInsert")
	@ResponseBody
	public String tasklistInsert(@RequestParam(value="projectCode")Project project, String tasklistName, RedirectAttributes model){
		System.out.println("------------tasklistInsert");
		int result = projectService.tasklistInsert(project);
		String projectCode = project.getProjectCode();
		System.out.println(result);
		
		if(result > 0 ) {
			model.addAttribute("projectCode", projectCode);
			model.addAttribute("tasklistName", tasklistName);
			return "redirect:/taskList";
		}
		return "redirect:/taskList";
	}
	//업무리스트 조회 메서드
	@GetMapping("/taskList")
	public String taskList(	Model model, @RequestParam(value="projectCode",required = false) String projectCode,
							@RequestParam(value="projectTitle",required = false) String projectTitle,
							@RequestParam(value="tasklistCode",required = false) String tasklistCode,
							HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		//System.out.println("binding test: " + projectCode);
		System.out.println("binding test: " + projectTitle);
		List<Project> taskList = new ArrayList<Project>();
		taskList = projectService.selectTasklist(projectCode);
		List<Project> taskDetail = new ArrayList<Project>();
		taskDetail= projectService.getTaskdetail(projectCode);
		System.out.println(taskDetail);
		model.addAttribute("taskList", taskList);
		model.addAttribute("projectTitle", projectTitle);
		model.addAttribute("taskDetail", taskDetail);
		return "project/taskList";
	}
	
	//프로젝트 삭제 메서드
	@PostMapping("/projectDelete")
	@ResponseBody
	public String projectDelete(@RequestParam(value="projectCode")String projectCode) {
		System.out.println(projectCode+"projectCode-------------------");
		int result = projectService.projectDelete(projectCode);
		if(result>0) {
			return "redirect:/projectList";
		}
		return "redirect:/projectList";
	}
	
	
	//프로젝트 수정 메서드 포스트 맵핑
	public String projectUpdate(Project project) {
		System.out.println(project.toString());
		int result = projectService.projectUpdate(project);
		if(result>0) {
			return "redirect:/projectList";
		}
		return "redirect:/projectList";
	}
	
	//프로젝트 수정 메서드 겟 맵핑
	@GetMapping("/projectUpdate")
	public String projectUpdate() {
		
		return "project/projectList";
		
	}
	
	//프로젝트 수정을 위한 1개정보 불러오는 ajax 메서드 겟 맵핑
		@GetMapping("/ajaxProjectSelectForUpdate")
		@ResponseBody
		public Map<String, Object> projectSelectForUpdate(@RequestParam(value="projectCode") String projectCode, Model model) {
			System.out.println("binding test=" + projectCode);
			Project resultProject=projectService.selectForProUpdate(projectCode);
			
			System.out.println("binding test2=" + resultProject.toString());
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("code", resultProject.getProjectCode());
			resultMap.put("title", resultProject.getProjectTitle());
			resultMap.put("desc", resultProject.getProjectDesc());
			resultMap.put("start", resultProject.getProjectStart());
			resultMap.put("dead", resultProject.getProjectDeadline());
			resultMap.put("end", resultProject.getProjectEnd());
			model.addAttribute("resultMap", resultMap);
			return resultMap;
		}
	
	
	
	//프로젝트 추가 메서드
	@PostMapping("/projectInsert")
	public String projectInsert(Project project, RedirectAttributes model){

		System.out.println(project.getProjectTitle()+"<------------프로젝트 추가시 넘길때 필요한 프로젝트 제목");
		int result = projectService.projectInsert(project);
		String projectTitle = project.getProjectTitle();
		System.out.println(result);
		
		if(result > 0 ) {
			model.addAttribute("projectTitle", projectTitle);
			return "redirect:/taskList";
		}
		return "redirect:/projectInsert";
	}
	
	//프로젝트  리스트 조회 메서드
	@GetMapping("/projectList")
	public String getProjectList(@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage
			,Model model) {
		logger.info("currentPage :: {}", currentPage);
		Map<String, Object> map = projectService.getProjectlist(currentPage);
		model.addAttribute("projectList", map.get("projectList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("endPageNum", map.get("endPageNum"));
		//System.out.println(boardService.getBoardlist().toString());
		return "project/projectList";
	}
	
	
	@GetMapping("/projectUpdateModal")
	public String modalHtml(Model model
			, @RequestParam(value="projectCode") String projectCode
	) {
		
		
		System.out.println("binding test=" + projectCode);
		Project resultProject=projectService.selectForProUpdate(projectCode);
		
		System.out.println("binding test2=" + resultProject.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", resultProject.getProjectCode());
		resultMap.put("title", resultProject.getProjectTitle());
		resultMap.put("desc", resultProject.getProjectDesc());
		resultMap.put("start", resultProject.getProjectStart());
		resultMap.put("dead", resultProject.getProjectDeadline());
		resultMap.put("end", resultProject.getProjectEnd());
		model.addAttribute("resultMap", resultMap);
		System.out.println("위치테스트");
		return "project/modal/projectUpdateModal";
	}
	
}
