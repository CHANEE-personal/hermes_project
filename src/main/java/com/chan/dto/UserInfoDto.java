package com.chan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserInfoDto {

	private Long id;
	private String email;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

/*public UserInfo toEntity() {
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
	}*/
		
}
