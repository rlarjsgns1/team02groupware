package com.team02.groupware.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * @file MainController.java
 * @brief main controller
 * @author ksmart34 HGD
 */

@Controller
public class MainController {
	
	
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "ksmart34");		
		return "login";
	}
	
	@PostMapping("/index")
	public String main(Model model, HttpSession session) {
		model.addAttribute("title", "ksmart34");
		return "index";
	}
	
	@GetMapping("/index")
	public String mainGet(Model model, HttpSession session) {
		model.addAttribute("title", "ksmart34");
		return "index";
	}
	
	@GetMapping("/employee/forgot-password")
	public String forgotPassword(Model model) {
		return "employee/forgot-password";
	}

}
