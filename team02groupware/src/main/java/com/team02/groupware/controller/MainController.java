package com.team02.groupware.controller;






import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/*
 * @file MainController.java
 * @brief 포트폴리오, index view 가는 컨트롤러 모음
 * @author team02 (김건훈,김정훈,김연지,이원준)
 */

@Controller
public class MainController {
	
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
	
	
	
	

}
