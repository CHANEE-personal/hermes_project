package com.chan.service.user;

import com.chan.dto.UserInfoDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * @package : com.chan.service
     * @method : gerUserList
     * @comment : 회원 리스트 조회
     * @date : 2021-02-26 오후 3:21
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public List<UserInfoDto> getUserList() throws Exception;

    /**
     * @package : com.chan.service
     * @method : getUserInfo
     * @comment : 회원 상세정보 조회
     * @date : 2021-02-26 오후 3:21
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public List<UserInfoDto> getUserInfo(Long id) throws Exception;

    /**
     * @package : com.chan.service
     * @method : insertUserInfo
     * @comment : 회원 등록
     * @date : 2021-02-26 오후 3:22
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public Integer insertUserInfo(UserInfoDto userInfoDto) throws Exception;

    public Map<String, UserInfoDto> getUserDetail(UserInfoDto userInfoDto) throws Exception;

    /**
     * @package : com.chan.service
     * @method : getUserCount
     * @comment : 회원 존재 유무
     * @date : 2021-02-26 오후 5:26
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public Integer getUserCount(String id, String password) throws Exception;

    /**
     * @package : com.chan.service
     * @method : getUserIdCheck
     * @comment : 회원 아이디 조회
     * @date : 2021-03-03 오후 5:18
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public Integer getUserIdCheck(String id) throws Exception;

    /**
     * @package : com.chan.service
     * @method : getUserPassword
     * @comment : 회원 비밀번호 조회
     * @date : 2021-03-03 오후 5:02
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public String getUserPassword(String id) throws Exception;
}
