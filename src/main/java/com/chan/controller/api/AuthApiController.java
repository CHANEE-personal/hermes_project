package com.chan.controller.api;

import com.chan.service.user.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.chan.dto.UserInfoDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/auth", method = {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequiredArgsConstructor
@Api(tags="회원관련 API")
public class AuthApiController {

    private final UserService userService;

    @ApiOperation(value="회원 조회", notes="회원을 조회한다.")
    @GetMapping(value="/user")
    public List<UserInfoDto> getUserList() throws Exception{
        return userService.getUserList();
    }

    @ApiOperation(value="회원 로그인", notes="회원을 로그인한다.")
    @GetMapping(value="/signin")
    @ApiResponses({
            @ApiResponse(code = 200, message = "로그인 성공"),
            @ApiResponse(code = 400, message = "잘못된 접근"),
            @ApiResponse(code = 500, message = "서버에러")
    })
    public Map<String, UserInfoDto> getUserDetail(UserInfoDto userInfoDto) throws Exception {

        return userService.getUserDetail(userInfoDto);
    }

    @ApiOperation(value="회원 등록", notes = "회원을 등록한다.")
    @PostMapping(value="/signup")
    public void insertUserInfo(UserInfoDto userInfoDto) throws Exception {

        //패스워드 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));

        userService.insertUserInfo(userInfoDto);
    }
}
