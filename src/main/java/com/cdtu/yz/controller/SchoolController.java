package com.cdtu.yz.controller;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.School;
import com.cdtu.yz.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author: An
 * @Date: 2019/6/28 23:28
 * @Version 1.0
 */
@RequestMapping("/school")
@Controller
public class SchoolController {

    // 注入SchoolService接口
    @Autowired
    SchoolService schoolService;

    /**
     * 前往学校首页
     * @param model
     * @param pageUtil
     * @return
     */
    @RequestMapping("/list/{currPage}")
    public String toIindex(Model model, PageUtil pageUtil){
        // 查询当前页内容
        PageUtil userPage = schoolService.getSchoolPage(pageUtil);
        // 将数据绑定到model中
        model.addAttribute("userPage", userPage);

        return "School/index";
    }

    /**
     * 跳转到编辑页面
     * @return
     */
    @RequestMapping("/to-edit/{id}")
    public String edit(Model model, School school){

        model.addAttribute("school", schoolService.getSchoolById(school.getId()));

        return "School/edit";
    }

    /**
     * 编辑学校信息
     *
     * @param school
     * @return
     */
    @RequestMapping("/edit-school")
    @ResponseBody
    public String editSchool(School school){

        school = schoolService.editSchool(school);
        if (null != school){
            return "true";
        }
        return "false";
    }

    /**
     * 跳转到添加高校页面
     * @return
     */
    @RequestMapping("/to-add")
    public String toAdd(){
        return "School/add";
    }

    /**
     * 添加高校信息到数据库中
     *
     * @param school
     * @return
     */
    @RequestMapping("/add-school")
    @ResponseBody
    public String addSchool(School school){
        if (schoolService.addSchool(school)){
            return "true";
        }

        return "false";
    }

    /**
     * 查看学校详细信息
     * @param model
     * @param school
     * @return
     */
    @RequestMapping("/show/{id}")
    public String show(Model model, School school){
        // 查询需要显示的学校信息
        model.addAttribute("school", schoolService.getSchoolById(school.getId()));

        return "School/show";
    }

    /**
     * 判断高校是否存在
     * @param schoolName
     * @return
     */
    @RequestMapping("/exist")
    @ResponseBody
    public String schoolIsExist(String schoolName){
        return schoolService.isExist(schoolName) ? "true" : "false";
    }

    /**
     * 高校搜索
     * @param param
     * @return
     */
    @RequestMapping("/search")
    public String schoolSearch(Model model, String param){
        School school = schoolService.getSchoolByName(param);
        if (null != school){
            model.addAttribute("school", school);
        }else {
            model.addAttribute("message", " "+ param );
        }
        return "School/show";
    }



}
