package com.chan.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
* @package : com.chan.controller.index
* @name : indexController.java
* @date : 2021-02-26 오후 3:46
* @author : chanee
* @version : 1.0.0
* @modifyed :
**/
@Controller
public class indexController {

    /**
     * @package : com.chan.controller.index
     * @method : hermes_main
     * @comment : 관리자 메인화면
     * @date : 2021-02-26 오후 3:46
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    @RequestMapping(value="/")
    public String hermes_main() throws Exception {
        return "user/login";
    }
}
