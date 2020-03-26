package com.team02.groupware.controller;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
	
	//업무리스트 조회 메서드
	@GetMapping("/taskList")
	public String taskList(	Model model, @RequestParam(value="projectCode",required = false) String projectCode,
							@RequestParam(value="projectTitle",required = false) String projectTitle,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		//System.out.println("binding test: " + projectCode);
		System.out.println("binding test: " + projectTitle);

		List<Project> taskList = new ArrayList<Project>();
		taskList = projectService.selectTasklist(projectCode);
		
		System.out.println("프로젝트 확인: "+taskList.toString());
		model.addAttribute("taskList", taskList);
		model.addAttribute("projectTitle", projectTitle);
		return "project/taskList";
	}
	
	
	//프로젝트 수정 메서드
	@GetMapping("/projectUpdate")
	public String projectUpdate(@RequestParam(value="projectCode") String projectCode, Model model) {
		System.out.println("binding test=" + projectCode);
		System.out.println("binding test2=" + projectService.selectForProUpdate(projectCode).toString());
		model.addAttribute("Project", projectService.selectForProUpdate(projectCode));
		return "project/projectList";
		
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
}
