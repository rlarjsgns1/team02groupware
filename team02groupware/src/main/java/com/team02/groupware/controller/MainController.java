package com.team02.groupware.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team02.groupware.dto.EmployeeDto;
import com.team02.groupware.service.LoginService;
import com.team02.groupware.service.MessengerService;


/*
 * @file MainController.java
 * @brief 포트폴리오, index view 가는 컨트롤러 모음
 * @author team02 (김건훈,김정훈,김연지,이원준)
 */

@Controller
public class MainController {
	
	@Autowired
	private LoginService loginService;
	
	 /*
	  * @method portfolio()
	  * @brief 포트폴리오 화면
	  * @author 김건훈
	  */
	@GetMapping("/")
	public String portfolio() {
		
		return "portfolio";
	}

	 /*
	  * @method index()
	  * @brief index 화면
	  * @author team02 (김건훈,김정훈,김연지,이원준)
	  */
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		
		return "loginPage";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/loginPage";
	}
	
	@PostMapping("/loginCheck")
	public String loginCheck(Model model, HttpSession session, EmployeeDto eDto, RedirectAttributes redirectA) {
		
		EmployeeDto empDto = new EmployeeDto();
		System.out.println("로그인체크"+eDto.toString());
		
		empDto = loginService.selectEmployee(eDto);
		System.out.println("로그인 체크 후" + empDto.toString());
		session.setAttribute("userId", empDto.getUserId());
		session.setAttribute("userName", empDto.getUserName());
		session.setAttribute("userNickName", empDto.getUserNickName());
		model.addAttribute("userId", empDto.getUserId());
		model.addAttribute("userName", empDto.getUserName());
		model.addAttribute("userNickName", empDto.getUserNickName());
		
		
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		
		return "test";
	}
	
	
	
	

}
