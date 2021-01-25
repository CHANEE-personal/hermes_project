package com.chan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chan.dto.UserInfoDto;
import com.chan.repository.UserRepository;
import com.chan.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void joinUser(UserInfoDto userInfoDto) {
					
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
								
		userRepository.save(userInfoDto.toEntity());
	}	
}
