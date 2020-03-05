package com.team02.groupware.controller;



import java.util.List;

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
		return "index";
	}
	

}
