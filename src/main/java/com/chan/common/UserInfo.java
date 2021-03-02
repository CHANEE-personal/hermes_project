package com.chan.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="hermes_user")
public class UserInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Builder
	public UserInfo(Long id, String email, String password) {		
		this.id = id;
		this.email = email;
		this.password = password;
	}
}