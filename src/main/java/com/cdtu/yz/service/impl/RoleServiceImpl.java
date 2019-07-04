package com.cdtu.yz.service.impl;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.dao.RoleDao;
import com.cdtu.yz.dao.RoleItemDao;
import com.cdtu.yz.entity.Role;
import com.cdtu.yz.entity.RoleItem;
import com.cdtu.yz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.session.InMemoryWebSessionStore;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 22:40
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    RoleItemDao roleItemDao;

    @Override
    public PageUtil getRolePage(PageUtil pageUtil) {
//        // 查询总的记录数
//        pageUtil.setTotalCount(roleDao.getRoleCount());  // 总数
//
//        // 查询当前页的数据
//        pageUtil.setData(roleDao.getRolePage(pageUtil));

        return pageUtil;
    }

    @Override
    public List<Role> getRoleAll() {
        return roleDao.getRoleAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public String updateRole(String roleid, String menuIds) {
        Integer roleId = Integer.parseInt(roleid);
        // 清空当前级别的所有权限
        roleItemDao.delRoleByRoleId(roleId);

        // 去掉菜单字符最后的 ,
        menuIds = menuIds.substring(0, menuIds.length() -2);

        String[] menuId = menuIds.split(",");
        for (String s : menuId) {
            RoleItem roleItem = new RoleItem();
            roleItem.setRoleId(roleId);
            roleItem.setMenuId(Integer.parseInt(s));
            //  插入数据到数据库中
            roleItemDao.insetByRoleId(roleItem);
        }

        return "修改成功！";
    }
}
