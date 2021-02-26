package com.chan.controller;

import com.chan.dto.UserInfoDto;
import com.chan.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
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
    public String loginProcess(@RequestParam(value="id") Long id,
                               @RequestParam(value="password") String password) throws Exception {
        System.out.println("===start loginProcess===");
        System.out.println(id);
        System.out.println(password);
        if(userService.getUserCount(id, password) > 0) {
            return "/index";
        }else {
            return "/index";
        }
    }

    /**
     * @package : com.chan.controller
     * @method : join
     * @comment : 회원가입 페이지
     * @date : 2021-02-26 오후 3:38
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    @GetMapping("/join")
    public ModelAndView join() throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("/user/join");

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
    public void insertUserInfo(UserInfoDto userInfoDto) throws Exception
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        userService.insertUserInfo(userInfoDto);
    }
}
