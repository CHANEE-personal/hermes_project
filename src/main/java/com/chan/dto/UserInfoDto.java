package com.chan.dto;

import com.chan.common.UserInfo;

import lombok.*;

@Data
public class UserInfoDto {
	private Long id;
	private String email;
	private String password;	
		
	public UserInfo toEntity() {
		return UserInfo.builder()
				.id(id)				
				.email(email)
				.password(password)
				.build();
	}
	
	@Builder
	public UserInfoDto(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
		
}
