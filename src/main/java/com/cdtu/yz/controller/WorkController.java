package com.cdtu.yz.controller;


import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.School;
import com.cdtu.yz.entity.User;
import com.cdtu.yz.entity.Work;
import com.cdtu.yz.service.SchoolService;
import com.cdtu.yz.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkService workService;

    @Autowired
    SchoolService schoolService;

    /**
     * 前往工作动态首页
     * @param model
     * @param pageUtil
     * @return
     */
    @RequestMapping("/list/{currPage}")
    public String toIindex(Model model, PageUtil pageUtil){
        // 查询当前页内容
        PageUtil userPage = workService.getWorkPage(pageUtil);
        // 将数据绑定到model中
        model.addAttribute("userPage", userPage);

        return "Work/index";
    }

    /**
     * 跳转到编辑页面
     * @return
     */
    @RequestMapping("/to-edit/{id}")
    public String edit(Model model, Work work){

        model.addAttribute("work", workService.getWorkById(work.getId()));
        model.addAttribute("schools", schoolService.getSchoolAll());

        return "Work/edit";
    }



    /**
     * 编辑工作动态信息
     *
     * @param work
     * @return
     */
    @RequestMapping("/edit-work")
    @ResponseBody
    public String editWork(Model model,Work work){

//        // 查询所有的学校
//        model.addAttribute("schools", schoolService.getSchoolAll());

        work = workService.editWork(work);
        if (null != work){
            return "true";
        }
        return "false";
    }


    /**
     * 通过id删除工作动态
     * @param id
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public String delWork(Integer id){

        if (workService.delWork(id)){
            return "success";
        }
        return "false";

    }


    /**
     * 前往添加工作动态界面
     * @return
     */
    @RequestMapping("/toaddwork")
    public String toaddWork(Model model){

        // 查询所有的学校
        model.addAttribute("schools", schoolService.getSchoolAll());

        return "Work/add";
    }

    /**
     * 添加工作到数据库
     * @param work
     * @return
     */
    @ResponseBody
    @RequestMapping("/addwork")
    public String addWork(Work work, HttpSession session){
        // 设置编辑者
        work.setEditor(((User)session.getAttribute("loginUser")).getUserName());

        // 添加工作动态信息
        if (workService.addWork(work)){
            return "true";
        }

        return "false";
    }


    /**
     * 查看学校详细信息
     * @param model
     * @param work
     * @return
     */
    @RequestMapping("/show/{id}")
    public String show(Model model, Work work){
        // 查询需要显示的学校信息
        model.addAttribute("work", workService.getWorkById(work.getId()));

        return "Work/show";
    }


    /**
     * 工作动态搜索
     * @param param
     * @return
     */
    @RequestMapping("/search")
    public String workSearch(Model model, String param){
        Work work = workService.getWorkByName(param);
        System.out.println("1");
        if ( work!= null){
            model.addAttribute("work", work);
        }else {
            model.addAttribute("message", " "+ param );
        }
        return "Work/show";
    }

    /**
     * 判断工作动态title是否已经存在
     */
    @RequestMapping("/exist")
    @ResponseBody
    public String WorkIsExist(String title){
        return workService.isExist(title) ? "true" : "false";
    }


 }
