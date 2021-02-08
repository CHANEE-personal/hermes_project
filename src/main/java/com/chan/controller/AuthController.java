package com.chan.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.*;

import com.chan.common.UserInfo;
import com.chan.dto.UserInfoDto;
import com.chan.repository.UserRepository;
import com.chan.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/auth")
@Api(tags="인증 API")
public class AuthController {
	
	private UserService userService;
	private UserRepository userRepository;
	
	@ApiOperation(value="회원 로그인", notes="회원을 로그인한다.")
	@PostMapping(value="/signin")
	public List<UserInfo> findAllUser(@ApiParam(value="회원아이디",required=true) @RequestParam String email,
									  @ApiParam(value="비밀번호",required=true) @RequestParam String password) {
		return userRepository.findAll();
	}

	@CrossOrigin(origins="http://localhost:8080", maxAge=3600)
	@ApiOperation(value="회원 등록", notes = "회원을 등록한다.")
	@PostMapping(value="/signup")
	public void save(UserInfoDto userInfoDto) {
		userService.joinUser(userInfoDto);
	}
}
