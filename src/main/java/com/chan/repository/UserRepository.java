package com.chan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chan.common.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long>{	
}
