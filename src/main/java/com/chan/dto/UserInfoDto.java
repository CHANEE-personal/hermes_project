package com.chan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserInfoDto {

	@JsonProperty("id")
	private String id;
	@JsonProperty("email")
	private String email;
	@JsonProperty("password")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
