package com.cdtu.yz.controller;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Need;
import com.cdtu.yz.entity.Recruit;
import com.cdtu.yz.service.AdverService;
import com.cdtu.yz.service.NeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/27 19:41
 * @Version 1.0
 */
@Controller
public class DefaultController {

    @Autowired
    AdverService adverService;

    @Autowired
    NeedService needService;

    /**
     * 跳转到首页
     * @param model
     * @return
     */
    @RequestMapping({"", "main"})
    public String main(Model model){

        List<Recruit> recruits =  adverService.getAdverList();
        List<Need> needs =  needService.getNeedList();

        model.addAttribute("recruits", recruits);
        model.addAttribute("needs", needs);

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
