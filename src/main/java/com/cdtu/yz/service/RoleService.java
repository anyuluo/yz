package com.cdtu.yz.service;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Role;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 22:34
 * @Version 1.0
 */
public interface RoleService {

    /**
     * 查询当前页的内容
     * @param pageUtil
     * @return
     */
    PageUtil getRolePage(PageUtil pageUtil);

    /**
     * 返回所有的用户
     * @return
     */
    List<Role> getRoleAll();

    /**
     * 通过id返回角色的相关信息
     * @param id
     * @return
     */
    Role getRoleById(Integer id);

    /**
     * 将角色权限信息数据更新到数据库中
     * @param roleId
     * @param menuIds
     * @return
     */
    String updateRole(String roleId, String menuIds);
}
