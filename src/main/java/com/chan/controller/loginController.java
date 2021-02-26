package com.chan.controller;

import com.chan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chan.dto.UserInfoDto;

@Controller
@RequiredArgsConstructor
public class loginController {

	private final UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/member/join")
	public String showJoin() {
		return "/member/join";
	}
			
	@PostMapping("/member/join")
	public void insertUserInfo(UserInfoDto userInfoDto) throws Exception{

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
		userService.insertUserInfo(userInfoDto);
	}
		
	
	@RequestMapping("/member/login")
	public String showLogin() {
		return "/member/login";
	}	
}
