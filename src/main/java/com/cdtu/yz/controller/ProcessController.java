package com.cdtu.yz.controller;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Process;
import com.cdtu.yz.entity.User;
import com.cdtu.yz.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/30 23:28
 * @Version 1.0
 */
@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    /**
     * 跳转到路线管理列表页面
     *
     * @return
     */
    @RequestMapping("/list/{currPage}")
    public String userList(Model model, PageUtil pageUtil){
        // 查询当前页需要显示的路线内容
        PageUtil processPage = processService.getProcessPage(pageUtil);
        // 将数据绑定到model中
        model.addAttribute("processPage", processPage);
        return "Process/index";
    }

    /**
     * 跳转到添加路线页面
     * @return
     */
    @RequestMapping("/toAddProcess")
    public String toAddProcess(){
        return "Process/add";
    }

    /**
     * 添加路线信息
     * @param session
     * @param process
     * @return
     */
    @RequestMapping("/add-process")
    @ResponseBody
    public String addProcess(HttpSession session, Process process){
        //  设置创建者的信息
        User user = (User)session.getAttribute("loginUser");
        process.setCreator(user.getCreator());
        process.setSchoolName(user.getSchoolName());
        if(processService.addProcess(process)){

            return "success";
        }
        return "fail";
    }

    /**
     * 跳转到编辑页面
     * @param model
     * @param process
     * @return
     */
    @RequestMapping("/edit/{id}")
    public String toEdit(Model model, Process process){
        model.addAttribute("process", processService.getProcessById(process.getId()));
        return "Process/edit";
    }

    /**
     * 修改路线信息到数据库中
     * @param model
     * @param process
     * @return
     */
    @RequestMapping("/edit-process")
    @ResponseBody
    public String edit(Model model, Process process){
        if(processService.updateProcess(process)){

            return "success";
        }
        return "fail";
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Integer id){
        if (processService.delProcess(id)){
            return "success";
        }
        return "false";
    }
}
