package com.cdtu.yz.controller;

import cn.hutool.core.lang.UUID;
import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Policy;
import com.cdtu.yz.entity.User;
import com.cdtu.yz.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * @Author: An
 * @Date: 2019/6/30 13:33
 * @Version 1.0
 */

@RequestMapping("/policy")
@Controller
public class PolicyController {

    //
    @Autowired
    PolicyService policyService;

    /**
     * 政策首页
     *
     * @param model
     * @param pageUtil
     * @return
     */
    @RequestMapping("/list/{currPage}")
    public String policyList(Model model, PageUtil pageUtil) {

        PageUtil policyPage = policyService.getPolicyPage(pageUtil);
        // 将数据绑定到model中
        model.addAttribute("policyPage", policyPage);

        return "Policy/index";
    }

    /**
     * 前往政策发布页面
     *
     * @return
     */
    @RequestMapping("/to-add")
    public String toAddPolicy() {
        return "Policy/add";
    }

    /**
     * 搜索相关政策
     *
     * @param model
     * @param param
     * @return
     */
    @RequestMapping("/search")
    public String search(Model model, String param) {
        PageUtil pageUtil = policyService.getPolicys(param);
        // 将数据绑定到model中
        model.addAttribute("policyPage", pageUtil);
        model.addAttribute("param", param);

        return "Policy/index";
    }

    /**
     * 跳转到编辑页面
     *
     * @param model
     * @param policy
     * @return
     */
    @RequestMapping("/to-edit/{id}")
    public String toEdit(Model model, Policy policy) {
        model.addAttribute("policy", policyService.getPolicyById(policy.getId()));
        return "Policy/edit";
    }

    @RequestMapping("/show/{id}")
    public String show(Model model, Policy policy){
        model.addAttribute("policy", policyService.getPolicyById(policy.getId()));

        return "Policy/show";
    }

    /**
     * 添加政策信息到数据库中, 包含文件上传
     *
     * @param file
     * @param policy
     * @return
     */
    @RequestMapping("add-policy")
    @ResponseBody
    public String addPolicy(@RequestParam("file") MultipartFile file, Policy policy, HttpSession session) {
        try {
            // 文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成一个uuid作为文件的名称
            fileName = UUID.randomUUID() + suffixName;
            // 获取文件保存的路径
            String path = new File("..").getCanonicalPath() + "\\policyFile\\";
            // 文件保存路径
            String filePath = path + fileName;

            File dir = new File(filePath);
            //  检测目录是否存在
            if (!dir.getParentFile().exists()) {
                dir.getParentFile().mkdirs();  // 目录不存在时创建目录
            }
            // 文件写入
            file.transferTo(dir);
            policy.setFilePath(fileName);

            policy.setEditor(((User)session.getAttribute("loginUser")).getUserName());
            policyService.addPolicy(policy);

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    /**
     * 文件下载
     *
     * @param res
     * @param fileName
     * @return
     * @throws IOException
     */
    @RequestMapping("/policyFile")
    public boolean download(HttpServletResponse res, @RequestParam("fileName") String fileName) throws IOException {
        // 获取文件保存的路径
        String path = new File("..").getCanonicalPath() + "\\policyFile\\";
        File file = new File(path + fileName);
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
            //  修改政策下载量
            policyService.incrementCount(fileName);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }


    /**
     * 添加政策信息到数据库中, 包含文件上传
     *
     * @param file
     * @param policy
     * @return
     */
    @RequestMapping("edit-policy")
    @ResponseBody
    public String editPolicy(@RequestParam("file") MultipartFile file, Policy policy) {
        try {
            // 文件名
            String fileName = file.getOriginalFilename();
            // 获取文件保存的路径
            String path = new File("..").getCanonicalPath() + "\\policyFile\\";
            // 文件保存路径
            String filePath = path + fileName;

            File dir = new File(filePath);
            //  检测目录是否存在
            if (!dir.getParentFile().exists()) {
                dir.getParentFile().mkdirs();  // 目录不存在时创建目录
            }
            // 文件写入
            file.transferTo(dir);
            policy.setFilePath(fileName);
            policyService.editPolicy(policy);

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
