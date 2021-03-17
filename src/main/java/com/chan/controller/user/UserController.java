package com.chan.controller.user;

import com.chan.configuration.jwt.JwtTokenUtil;
import com.chan.dto.UserInfoDto;
import com.chan.service.user.UserService;
import com.chan.common.StringUtil;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;

    private final JwtTokenUtil jwtTokenUtil;

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
    public ModelAndView loginProcess(UserInfoDto userInfoDto) throws Exception {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        ModelAndView mv = new ModelAndView();

        // 아이디 존재 유무
        if(StringUtil.getInt(userService.getUserIdCheck(userInfoDto.getId())) > 0) {
            // 패스워드 조회
            String checkPw = userService.getUserPassword(userInfoDto.getId());
            // 패스워드 체크
            boolean matchPw = bCryptPasswordEncoder.matches(userInfoDto.getPassword(), checkPw);
            if(matchPw) {

                mv.addObject("msg","로그인되었습니다.");
                mv.addObject("result", "S00");
                mv.setViewName("/product/productList");
            }else {
                mv.addObject("msg","패스워드를 확인해주세요.");
                mv.addObject("result", "F01");
                mv.setViewName("index");
            }
        }else {
            mv.addObject("msg", "존재하는 아이디가 없습니다.");
            mv.addObject("result", "F00");
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
    public JSON insertUserInfo(@RequestBody UserInfoDto userInfoDto) throws Exception
    {
        JSONObject jsonObject = new JSONObject();

        //패스워드 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));

        if(userService.getUserCount(userInfoDto.getId(), userInfoDto.getPassword()) == 0) {
            if(userService.insertUserInfo(userInfoDto)>0) {
                jsonObject.put("result","S00");
                jsonObject.put("msg","회원가입을 축하합니다.");
                jsonObject.put("id",userInfoDto.getId());
            }
        } else {
            jsonObject.put("result","F00");
            jsonObject.put("msg","이미 존재하는 아이디입니다.");
        }

        return jsonObject;
    }
}
