package com.team02.groupware.controller;



import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	
	@GetMapping("/taskList")
	public String taskList() {
		return "project/taskList";
	}
	
	@PostMapping("/projectInsert")
	public String projectInsert(Project project) {
		System.out.println(project.toString());
		int result = projectService.projectInsert(project);
		System.out.println(result);
		if(result > 0 ) {
			return "redirect:/projectList";
		}
		return "redirect:/projectInsert";
	}
	
	
	@GetMapping("/projectInsert")
	public String projectInsert() {
		System.out.println(" ------GetMapping  /projectInsert");
		return "/projectInsert";
	}
	
	
	
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
