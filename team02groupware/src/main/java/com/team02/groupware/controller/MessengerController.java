package com.team02.groupware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.team02.groupware.service.MessengerService;


@Controller
public class MessengerController {
	
	@Autowired
	private MessengerService messengerService;
	
	
	@GetMapping("/messengerHome")
	public String messengerHome() {
		
		
		
		return "messenger/messengerHome";
	}

}
