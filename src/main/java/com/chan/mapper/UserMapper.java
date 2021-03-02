package com.chan.mapper;

import com.chan.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {
    public List<UserInfoDto> getUserList() throws Exception;

    public List<UserInfoDto> getUserInfo(Long id) throws Exception;

    public Map<String, UserInfoDto> getUserDetail(UserInfoDto userInfoDto) throws Exception;

    @Transactional
    public Integer insertUserInfo(UserInfoDto userInfoDto) throws Exception;

    /**
     * @package : com.chan.mappergetUserCount
     * @method : getUserCount
     * @comment : 회원 존재 유무
     * @date : 2021-02-26 오후 5:28
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public Integer getUserCount(@Param("id") String id, @Param("password") String password) throws Exception;
}
