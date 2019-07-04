package com.cdtu.yz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Menu;
import com.cdtu.yz.entity.Role;
import com.cdtu.yz.service.MenuServices;
import com.cdtu.yz.service.RoleService;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 22:32
 * @Version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuServices menuServices;

    /**
     * 跳转到角色管理首页
     * @param model
     * @param pageUtil
     * @return
     */
    @RequestMapping("/list")
    public String index(Model model, PageUtil pageUtil){

        // 查询所有的角色内容
        List<Role> roles = roleService.getRoleAll();
        // 将数据绑定到model中
        model.addAttribute("roles", roles);
        return "Role/index";
    }

    /**
     * 跳转到权限管理的修改页面
     * @param model
     * @param role
     * @return
     */
    @RequestMapping("/to-edit")
    public String toEdit(Model model, Role role){
        // 查询角色对应得信息
        // 根据管理员的id查询出管理员对应的菜单信息
        List<Menu> menus = menuServices.findMenuByRole(role.getId());
        JSONArray jsonMenu = JSONArray.parseArray(JSON.toJSONString(menus));

        model.addAttribute("menus", jsonMenu);

        //查询出所有的菜单信息
        List<Menu> menuList = menuServices.getMenuAll();

        model.addAttribute("menuList", JSONArray.parseArray(JSON.toJSONString(menuList)));
        // 角色相关信息
//        role = roleService.getRoleById(role.getId());
        model.addAttribute("roleId", role.getId());

        return "Role/edit";
    }

    /**
     * 将用户修改后的权限信息保存到数据库中
     * @param roleId
     * @param menuIds
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public String edit(String roleId, String menuIds){
        //
        String result = roleService.updateRole(roleId, menuIds);

        return result;
    }

}
