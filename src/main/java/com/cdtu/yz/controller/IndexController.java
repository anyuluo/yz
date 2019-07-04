package com.cdtu.yz.controller;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Menu;
import com.cdtu.yz.entity.Work;
import com.cdtu.yz.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * 处理用户首页请求
 * @Author: An
 * @Date: 2019/7/1 11:22
 * @Version 1.0
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    PolicyService policyService;

    @Autowired
    WorkService workService;

    @Autowired
    SchoolService schoolService;

    @Autowired
    NeedService needService;

    @Autowired
    AdverService adverService;

    @Autowired
    ProcessService processService;

    /**
     * 援藏工作列表页
     * @param model
     * @return
     */
    @RequestMapping("/work")
    public String workIndex(Model model, Integer page){

        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrPage(page == null ? 1:page);

        //  查询工作动态相关信息
        pageUtil = workService.getWorkPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/workindex";
    }

    @RequestMapping("/toWorkShow")
    public String workShow(Model model, Integer id){
        // 查询工作动态的详细信息
        model.addAttribute("work", workService.getWorkById(id));
        // 修改工作动态的阅读量
        workService.incrementCount(id);

        //  查询工作动态相关信息
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(5);
        pageUtil = workService.getWorkPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/workshow";
    }

    /**
     * 前往政策首页
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/policy")
    public String policyIndex(Model model, Integer page){

        // 用于封装分页数据
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrPage(page == null ? 1:page);

        pageUtil = policyService.getPolicyPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/policyindex";
    }

    /**
     * 学校列表首页
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/school")
    public String schoolIndex(Model model, Integer page){
        // 用于封装分页数据
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrPage(page == null ? 1:page);

        pageUtil = schoolService.getSchoolPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/schoolindex";
    }

    /**
     * 高校详情
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/toSchoolShow")
    public String schoolShow(Model model, Integer id){
        // 查询id对应的高校信息
        model.addAttribute("school", schoolService.getSchoolById(id));

        // 查询其他高校
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(5);
        pageUtil = schoolService.getSchoolPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);
        return "index/schoolshow";
    }

    /**
     * 需求列表页
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/need")
    public String needIndex(Model model, Integer page){
        // 用于封装分页数据
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrPage(page == null ? 1:page);

        pageUtil = needService.getNeedPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/needindex";
    }

    /**
     * 需求详情页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/toNeedShow")
    public String needShow(Model model, Integer id){
        // 查询id对应的高校信息
        model.addAttribute("need", needService.getNeedById(id));
        // 修改工作动态的阅读量
        needService.incrementCount(id);

        // 查询其他高校
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(5);
        pageUtil = needService.getNeedPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/needshow";
    }

    /**
     * 人员招聘列表首页
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/adver")
    public String adverIndex(Model model, Integer page){
        // 用于封装分页数据
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrPage(page == null ? 1:page);

        pageUtil = adverService.getAdverPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/adverindex";
    }

    /**
     * 人员招聘信息详情页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/toAdverShow")
    public String adverShow(Model model, Integer id){
        // 查询id对应的高校信息
        model.addAttribute("adver", adverService.getRecruitById(id));

        // 修改工作动态的阅读量
        adverService.incrementCount(id);

        // 查询其他高校
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(5);
        pageUtil = adverService.getAdverPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/advershow";
    }

    /**
     * 援藏路线列表首页
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/process")
    public String processIndex(Model model, Integer page){
        // 用于封装分页数据
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrPage(page == null ? 1:page);

        pageUtil = processService.getProcessPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/processindex";
    }

    @RequestMapping("/toProcessShow")
    public String processShow(Model model, Integer id){
        // 查询id对应的高校信息
        model.addAttribute("process", processService.getProcessById(id));

        // 查询其他高校
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(5);
        pageUtil = processService.getProcessPage(pageUtil);
        model.addAttribute("pageUtil", pageUtil);

        return "index/processshow";
    }


}
