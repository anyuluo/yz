package com.cdtu.yz.controller;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Recruit;
import com.cdtu.yz.entity.School;
import com.cdtu.yz.entity.User;
import com.cdtu.yz.service.AdverService;
import com.cdtu.yz.service.SchoolService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 10:18
 * @Version 1.0
 */
@Controller
@RequestMapping("/adver")
public class AdverController {

    @Autowired
    AdverService adverService;

    // 自动注入一个schoolService
    @Autowired
    SchoolService schoolService;

    /**
     * 前往学校首页
     * @param model
     * @param pageUtil
     * @return
     */
    @RequestMapping("/list/{currPage}")
    public String toIndex(Model model, PageUtil pageUtil){
        // 查询当前页内容
        PageUtil adverPage = adverService.getAdverPage(pageUtil);
        // 将数据绑定到model中
        model.addAttribute("adverPage", adverPage);

        return "Adver/index";
    }


    /**
     * 跳转到添加人才引进页面
     * @return
     */
    @RequestMapping("/to-edit/{id}")
    public String toEdit(Model model, Recruit recruit){
        // 查询所有的高校信息
        List<School> schools = schoolService.getSchoolAll();

        model.addAttribute("schools", schools);

        // 查询人才引进相关信息
        model.addAttribute("recruit", adverService.getRecruitById(recruit.getId()));

        return "Adver/edit";
    }


    @RequestMapping("/edit-recruit")
    @ResponseBody
    public String edit(Model model, Recruit recruit){


        return adverService.updateRecruit(recruit) ? "true" : "false";
    }

    /**
     * 跳转到添加高校页面
     * @return
     */
    @RequestMapping("/to-add")
    public String toAdd(Model model){

        // 查询所有的高校信息
        List<School> schools = schoolService.getSchoolAll();
        model.addAttribute("schools", schools);

        return "Adver/add";
    }

    /**
     * 添加高校信息到数据库中
     *
     * @param recruit
     * @return
     */
    @RequestMapping("/add-adver")
    @ResponseBody
    public String addSchool(Recruit recruit, HttpSession session){
        User user = (User)session.getAttribute("loginUser");
        recruit.setEditor(user.getUserName());

        if (adverService.addAdver(recruit)){
            return "true";
        }

        return "false";
    }

    /**
     * 搜索人才引进信息
     * @param model
     * @param param
     * @return
     */
    @RequestMapping("/search")
    public String search(Model model, String param){
        Recruit recruit = adverService.getAdverByParam(param);
        if (null != recruit){
            model.addAttribute("recruit", recruit);
        }else {
            model.addAttribute("message", " "+ param );
        }
        return "Adver/show";
    }


    /**
     * 显示人才引进的详细信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/show/{id}")
    public String show(Model model, @RequestParam("id") String id){
        // 通过id查询人才引进文章的详细信息
        Recruit recruit = adverService.getRecruitById(Integer.parseInt(id));

        model.addAttribute("recruit", recruit);

        return "Adver/show";
    }

    /**
     * 通过id删除人才引进信息
     * @param id
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public String delRecruit(Integer id){

        if (adverService.delRecruit(id)){
            return "success";
        }
        return "false";
    }

}
