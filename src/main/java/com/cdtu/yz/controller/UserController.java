package com.cdtu.yz.controller;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.User;
import com.cdtu.yz.service.AuthService;
import com.cdtu.yz.service.SchoolService;
import com.cdtu.yz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * UserController 类
 * @Author: An
 * @Date: 2019/6/27 13:16
 * @Version 1.0
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    // 注入schoolService
    @Autowired
    SchoolService schoolService;

    // 注入权限管理服务
    @Autowired
    AuthService authService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String username, String password){

        return userService.login(username, password) ? "success" : "fail";
    }

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * 跳转到管理员列表页面
     *
     * @return
     */
    @RequestMapping("/list/{currPage}")
    public String userList(Model model, PageUtil pageUtil){
        // 查询所有的用户
//        List<User> users = userService.getUserAll();
        // 查询当前页内容
        PageUtil userPage = userService.getUserPage(pageUtil);
        // 将数据绑定到model中
        model.addAttribute("userPage", userPage);
        return "User/index";
    }


    /**
     * 前往添加管理员用户界面
     * @return
     */
    @RequestMapping("/toAddUser")
    public String toAddUser(Model model){
        // 查询所有的学校
        model.addAttribute("schools", schoolService.getSchoolAll());

        // 查询所有的角色
        model.addAttribute("authAll", authService.getAuthAll());

        return "User/add";
    }

    /**
     * 添加用户到数据库
     * @param user
     * @return
     */
    @RequestMapping("/adduser")
    public String addUser(User user){

        // 添加用户信息
        userService.addUser(user);

        return "forward:/user/list/1";
    }

    /**
     * 用户是否存在，存在返回true
     * @return
     */
    @RequestMapping("/exist")
    @ResponseBody
    public String userIsExist(String username){
        return userService.isExist(username) ? "true" : "false";
    }

    /**
     * 用户搜索
     * @param param
     * @return
     */
    @RequestMapping("/search")
    public String userSearch(Model model, String param){
        User user = userService.getUserByName(param);
        if (null != user){
            model.addAttribute("user", user);
        }else {
            model.addAttribute("message", " "+ param );
        }
        return "User/show";
    }

    /**
     * 修改用户
     * 通过id查询用户原有的信息
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/edit/{id}")
    public String toEdit(Model model, User user){
        //通过用户id查询数据库
        model.addAttribute("user", userService.getUserById(user.getId()));
        // 查询所有的权限级别
        model.addAttribute("authAll", authService.getAuthAll());

        return "User/edit";
    }

    @RequestMapping("/show/{id}")
    public String show(Model model, User user){
        model.addAttribute("user", userService.getUserById(user.getId()));
        //显示页面
        return "User/show";

    }

    /**
     * 将修改的用户信息保存到数据库中
     * @param user
     * @return
     */
    @RequestMapping("/edit-user")
    public String editUser(User user){
        userService.updateUser(user);
        // 转发到列表首页
        return "forward:/user/list/1";
    }

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public String delUser(Integer id){

        if (userService.delUser(id)){
            return "success";
        }
        return "false";
    }
}
