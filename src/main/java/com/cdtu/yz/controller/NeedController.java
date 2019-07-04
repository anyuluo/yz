package com.cdtu.yz.controller;


import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Need;
import com.cdtu.yz.entity.User;
import com.cdtu.yz.service.NeedService;
import com.cdtu.yz.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;



/**
 * NeedController 类
 */
@Controller
@RequestMapping("/need")
public class NeedController {

    @Autowired
    NeedService needService;
    @Autowired
    SchoolService schoolService;


    /**
     * 前往需求首页
     * @param model
     * @param pageUtil
     * @return
     */
    @RequestMapping("/list/{currPage}")
    public String toIindex(Model model, PageUtil pageUtil){
        // 查询当前页内容
        PageUtil needPage = needService.getNeedPage(pageUtil);
        // 将数据绑定到model中
        model.addAttribute("needPage", needPage);
        return "Need/index";
    }
    /**
     * 添加需求
     */
    @RequestMapping(value = "/to-add")
    public String toAdd(Model model){
        model.addAttribute("schools", schoolService.getSchoolAll());
        return "Need/add";
    }

    /**
     * 判断title是否已经存在
     */
    @RequestMapping("/exist")
    @ResponseBody
    public String needIsExist(String title){
        return needService.isExist(title) ? "true" : "false";
    }
    /**
     * 添加需求信息到数据库中
     *
     * @param need
     * @return
     */
    @RequestMapping("/add-need")
    @ResponseBody
    public String addNeed(Need need, HttpSession session){
        // 设置编辑者
        need.setEditor(((User) session.getAttribute("loginUser")).getUserName());
        if (needService.addNeed(need)){
            return "true";
        }
        return "false";
    }

    /**
     * 查询
     * @param model
     * @param title
     * @return
     */
    @RequestMapping("/search")
    public String needSearch(Model model, String title){
        Need need = needService.getNeedByTitle(title);
        if (null != need){
            model.addAttribute("need", need);
        }else {
            model.addAttribute("message", " "+ title );
        }
        return "Need/show";
    }

    /**
     * 跳转到修改页面
     * @return
     */
    @RequestMapping("/to-edit/{id}")
    public String toEdit(Model model,Need need){
        model.addAttribute("need", needService.getNeedById(need.getId()));
        model.addAttribute("schools",schoolService.getSchoolAll());
        return "Need/edit";
    }

    /**
     * 修改需求信息
     * @return
     */
    @RequestMapping("/edit-need")
    @ResponseBody
    public String editNeed(Need need){
        if (null != need){
            needService.editNeed(need);
            return "true";
        }
        return "false";
    }
    /**
     * 查看需求详细信息
     * @param model
     * @param need
     * @return
     */
    @RequestMapping("/show/{id}")
    public String show(Model model, Need need){
        // 查询需要显示的学校信息
        model.addAttribute("need", needService.getNeedById(need.getId()));
        return "Need/show";
    }
    /**
     * 通过id删除需求
     * @param id
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public String delNeed(Integer id){
//        System.out.println(id);
        if (needService.delNeed(id)){
            return "success";
        }
        return "false";
    }
}

