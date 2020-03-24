package com.team02.groupware.controller;






import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;



/*
 * @file MainController.java
 * @brief 포트폴리오, index view,login 가는 컨트롤러 모음
 * @author team02 (김건훈,김정훈,김연지,이원준)
 */

@Controller
public class MainController {

	 /*
	  * @method login()
	  * @brief login 화면
	  * @author 김정훈
	  */
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "ksmart34");		
		return "login";
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
	
	 /*
	  * @method portfolio()
	  * @brief 포트폴리오 화면
	  * @author team02 (김건훈,김정훈,김연지,이원준)
	  */
	@GetMapping("/")
	public String portfolio() {
		return "portfolio.html";
	}
	
	
	 /*
	  * @method mainGet()
	  * @brief index 화면 (로그인 성공시 세션에 값 담고 index 화면으로 이동)
	  * @author 김정훈
	  */
	@PostMapping("/index")
	public String mainGet(Model model, HttpSession session) {
		model.addAttribute("title", "ksmart34");
		return "index";
	}
	
	 /*
	  * @method forgotPassword()
	  * @brief 비밀번호 찾기 method
	  * @author 김정훈
	  */
	@GetMapping("/employee/forgot-password")
	public String forgotPassword(Model model) {
		return "employee/forgot-password";
	}


}
