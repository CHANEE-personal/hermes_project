package com.chan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chan.dto.UserInfoDto;
import com.chan.service.UserService;

@Controller
public class loginController {
	
	private UserService userService;	
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/member/join")
	public String showJoin() {
		return "/member/join";
	}
			
	@PostMapping("/member/join")
	public String showJoin(UserInfoDto userInfoDto) {				
			
		userService.joinUser(userInfoDto);
		
		return "redirect:/";
	}
		
	
	@RequestMapping("/member/login")
	public String showLogin() {
		return "/member/login";
	}	
}
