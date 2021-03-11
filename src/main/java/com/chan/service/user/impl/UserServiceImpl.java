package com.chan.service.user.impl;

import com.chan.dto.UserInfoDto;
import com.chan.mapper.user.UserMapper;
import com.chan.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @package : com.chan.service.impl
* @name : UserServiceImpl.java
* @date : 2021-02-26 오후 2:55
* @author : User
* @version : 1.0.0
* @modifyed :
**/
@Service("UserService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
    * @package : UserServiceImpl.java
    * @method : 
    * @date : 2021-02-26 오후 3:46
    * @author : User
    * @version : 1.0.0
    * @modifyed :
    **/
    public List<UserInfoDto> getUserList() throws Exception {
        return userMapper.getUserList();
    }
    
    /**
    * @package : UserServiceImpl.java
    * @method : 
    * @date : 2021-02-26 오후 3:03
    * @author : User
    * @version : 1.0.0
    * @modifyed :
    **/
    public List<UserInfoDto> getUserInfo(Long id) throws Exception {
        return userMapper.getUserInfo(id);
    }

    public Map<String, UserInfoDto> getUserDetail(UserInfoDto userInfoDto) throws Exception {
        return userMapper.getUserDetail(userInfoDto);
    }

    public Integer insertUserInfo(UserInfoDto userInfoDto) throws Exception {

        return userMapper.insertUserInfo(userInfoDto);
    }

    /**
     * @package : com.chan.service.impl
     * @method : getUserCount
     * @comment : 회원 존재 유무
     * @date : 2021-02-26 오후 5:27
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public Integer getUserCount(String id, String password) throws Exception {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String bCyptPassword = bCryptPasswordEncoder.encode(password);
        return userMapper.getUserCount(id, bCyptPassword);
    }

    /**
     * @package : com.chan.service.impl
     * @method : getUserIdCheck
     * @comment : 회원 아이디 조회
     * @date : 2021-03-03 오후 5:19
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public Integer getUserIdCheck(String id) throws Exception {
        return userMapper.getUserIdCheck(id);
    }

    /**
     * @package : com.chan.service.impl
     * @method : getUserPassword
     * @comment : 회원 패스워드 조회
     * @date : 2021-03-03 오후 5:03
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public String getUserPassword(String id) throws Exception {
        return userMapper.getUserPassword(id);
    }
}
