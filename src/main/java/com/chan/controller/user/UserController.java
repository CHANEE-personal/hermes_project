package com.chan.controller.user;

import com.chan.dto.UserInfoDto;
import com.chan.service.UserService;
import com.chan.common.StringUtil;
import io.swagger.models.Model;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;

    /**
     * @package : com.chan.controller
     * @method : login
     * @comment : 로그인 페이지
     * @date : 2021-02-26 오후 3:36
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    @GetMapping("/login")
    public String login() throws Exception {
        return "user/login";
    }

    /**
     * @package : com.chan.controller
     * @method : loginProcess
     * @comment : 로그인 체크
     * @date : 2021-02-26 오후 4:52
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    @PostMapping("/loginProcess")
    public ModelAndView loginProcess(@Param("id") String id, @Param("password") String password) throws Exception {

        ModelAndView mv = new ModelAndView();
        if(StringUtil.getInt(userService.getUserCount(id, password)) > 0) {
            mv.addObject("msg","로그인되었습니다.");
            mv.setViewName("index");
        }else {
            mv.addObject("msg","존재하는 아이디가 없습니다");
            mv.setViewName("index");
        }

        return mv;
    }

    /**
     * @package : com.chan.controller
     * @method : insertUserInfo
     * @comment : 회원가입
     * @date : 2021-02-26 오후 3:24
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    @PostMapping("/register")
    public String insertUserInfo(UserInfoDto userInfoDto) throws Exception
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        if(StringUtil.getInt(userService.insertUserInfo(userInfoDto))>0) {
            return "index";
        }else {
            return "index";
        }
    }
}
