package com.cdtu.yz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: An
 * @Date: 2019/6/27 19:41
 * @Version 1.0
 */
@Controller
public class DefaultController {

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping({"", "main"})
    public String main(){
        return "main";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping({"login.html"})
    public String toLogin(){
        return "login";
    }


}
